package in.cdac.webclient.userservice;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.zip.Deflater;
import java.util.zip.GZIPInputStream;
import java.util.zip.Inflater;
import javax.imageio.ImageIO;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.io.IOUtils;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import in.cdac.webclient.model.QR_codepojo;

@Component
public class OfflineQRCodeImpl implements OfflineQRCodeService {

	private static final Charset UTF_8 = null;
	private final static Logger logger = Logger.getLogger(OfflineQRCodeService.class);

	public QR_codepojo ValidateData(String UserData) throws IOException, NoSuchAlgorithmException {
		


		// Convert string to Big Integer
		BigInteger UDBigInteger = new BigInteger(UserData);

		// Convert the Big Integer into byte array.
		byte[] UDByteArray = UDBigInteger.toByteArray();

		// decompress data INTO BYTE ARRAY
		byte[] UDdecompdata = decompressdata(UDByteArray);

		// byte[] UDdecompdata3 = decompress(UDByteArray);

		byte[] temp = new byte[UDdecompdata.length];

		// total field in data till we get value of the VTC field.
		String[] converted = new String[16];
		int count = 0;
		int dcount = 0;
		int tempIndex = 0;
		for (tempIndex = 0; tempIndex < UDdecompdata.length && count < converted.length; tempIndex++) {

			// first delimiter value “255” i.e -1 in ASCII character and convert with
			// "ISO-8859-1”
			if (UDdecompdata[tempIndex] == -1) {
				converted[count++] = (new String(temp, "ISO-8859-1")).substring(0, dcount);
				temp = new byte[UDdecompdata.length];

				dcount = 0;
			} else
				temp[dcount++] = UDdecompdata[tempIndex];

		}

		// last delimiter value
		int VTCDelimiterEnd = tempIndex;

		byte[] signatureHash = new byte[256];
		for (int x = UDdecompdata.length - 1, y = 0; x >= UDdecompdata.length - 256; x--) {
			signatureHash[y++] = UDdecompdata[x];
		}

		String signatureHashString = new String(signatureHash, "ISO-8859-1");

		// call getQRpojo to set a data
		QR_codepojo pojo = getQRPojo(converted);

		// Post getting signature value, check the value of
		// Email_mobile_present_bit_indicator_value
		byte[] mobileNumber = new byte[32];
		byte[] emailId = new byte[32];

		int lastLength = UDdecompdata.length - 256 - 1;

		// 1 then only mobile is present.
		if (pojo.getEmail_mobile_value() == 1) {
			lastLength -= 32;
			for (int x = UDdecompdata.length - 1 - 256, y = 31; x > UDdecompdata.length - 256 - 32 - 1; x--) {
				mobileNumber[y--] = UDdecompdata[x];
			}

			// 2 then only email is present.
		} else if (pojo.getEmail_mobile_value() == 2) {
			lastLength -= 32;
			for (int x = UDdecompdata.length - 1 - 256, y = 31; x > UDdecompdata.length - 256 - 32 - 1; x--) {
				emailId[y--] = UDdecompdata[x];
			}

			// If Email_mobile_present_bit_indicator_value is 3 then no mobile or email
			// present.
		} else if (pojo.getEmail_mobile_value() == 3) {
			lastLength -= 64;
			for (int x = UDdecompdata.length - 1 - 256, y = 31; x > UDdecompdata.length - 256 - 32 - 1; x--) {
				mobileNumber[y--] = UDdecompdata[x];
			}
			for (int x = UDdecompdata.length - 1 - 256 - 32, y = 31; x > UDdecompdata.length - 256 - 32 - 32 - 1; x--) {
				emailId[y--] = UDdecompdata[x];
			}
		}

		// read the photo from index (VTC delimeter value of “255” + 1) toindex (Byte
		// array length – 1- 256 – (if mobile present then -32 if emailpresent then -32
		byte[] photoByte = new byte[lastLength - VTCDelimiterEnd + 1];

		int photoCount = 0;
		for (int x = VTCDelimiterEnd; x < lastLength; x++) {
			photoByte[photoCount++] = UDdecompdata[x];
		}

		try {
			logger.info("photoByte size::"+photoByte.length);
			BufferedImage buffereddata=createImageFromBytes(photoByte);
			//BufferedImage buffereddata = createImageFromBytes(photoByte);
			logger.info("buffereddata==>"+buffereddata);
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ImageIO.write(buffereddata, "PNG", baos);
			baos.flush();
			byte[] imageInByte = baos.toByteArray();
			baos.close();
			String imageinString = java.util.Base64.getEncoder().encodeToString(imageInByte);

			pojo.setPhoto(imageinString);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.log(Level.ERROR,e.getMessage(),e);
		}

		String hexmobileNumber = bytesToHex(mobileNumber);
		String hexemailId = bytesToHex(emailId);

		pojo.setMobileNumberHash(hexmobileNumber);
		pojo.setEmailIdHash(hexemailId);

		// Remove the signature value from secure qr code byte array to get signed data.
		byte[] signedData = new byte[UDdecompdata.length - 256];
		for (int x = 0; x < signedData.length; x++) {
			signedData[x] = UDdecompdata[x];
		}
		String finalsignedData = new String(signedData, "ISO-8859-1");

		String mobileno = "";
		String mobilenohash = "";
		String emailid = "";
		String emailidhash = "";

		String ReferenceId = pojo.getReferenceId();

		String fouthdigit = ReferenceId.substring(3, 4);

		mobilenohash = mobileno;
		emailidhash = emailid;
		for (int i = 1; i <= Integer.parseInt(fouthdigit); i++) {
			mobilenohash = convertStringToSHA256(mobilenohash);

			emailidhash = convertStringToSHA256(emailidhash);

		}

		return pojo;
	
	}

	// populate the appropriate field.. with POJO
	public QR_codepojo getQRPojo(String[] converted) {
		QR_codepojo pojo = new QR_codepojo();
		pojo.setEmail_mobile_value(Integer.parseInt(converted[0]));
		pojo.setReferenceId(converted[1]);
		pojo.setName(converted[2]);
		pojo.setDateofbirth(converted[3]);
		pojo.setGender(converted[4]);
		pojo.setCareof(converted[5]);
		pojo.setDistrict(converted[6]);
		pojo.setLandmark(converted[7]);
		pojo.setHouse(converted[8]);
		pojo.setLocation(converted[9]);
		pojo.setPincode(Integer.parseInt(converted[10]));
		pojo.setPostoffice(converted[11]);
		pojo.setState(converted[12]);
		pojo.setStreet(converted[13]);
		pojo.setSubdistrict(converted[14]);
		pojo.setVTC(converted[15]);
		return pojo;
	}

	// ===============================================================

	// Method implementation is here

	// Decompress byte array
	public byte[] decompressByteArray(byte[] UDByteArray) {

		ByteArrayOutputStream baos = null;
		Inflater iflr = new Inflater();
		iflr.setInput(UDByteArray);
		baos = new ByteArrayOutputStream();
		byte[] tmp = new byte[8 * 1024];
		try {
			while (!iflr.finished()) {
				int size = iflr.inflate(tmp);
				baos.write(tmp, 0, size);
			}
		} catch (Exception ex) {

		} finally {
			try {
				if (baos != null)
					baos.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		// System.out.println("decompressByteArray" + baos.toByteArray());
		return baos.toByteArray();
	}

	// compress the byte array
	public byte[] compressByteArray(byte[] bytes) {

		ByteArrayOutputStream baos = null;
		Deflater dfl = new Deflater();
		dfl.setLevel(Deflater.BEST_COMPRESSION);
		dfl.setInput(bytes);
		dfl.finish();
		baos = new ByteArrayOutputStream();
		byte[] tmp = new byte[4 * 1024];
		try {
			while (!dfl.finished()) {
				int size = dfl.deflate(tmp);
				baos.write(tmp, 0, size);
			}
		} catch (Exception ex) {

		} finally {
			try {
				if (baos != null)
					baos.close();
			} catch (Exception ex) {
				logger.log(Level.ERROR,ex.getMessage(),ex);

			}
		}

		return baos.toByteArray();
	}

	// final decompress array function call
	public byte[] decompressdata(byte[] UDByteArray) {
		ByteArrayOutputStream out = new ByteArrayOutputStream();

		try {
			IOUtils.copy(new GZIPInputStream(new ByteArrayInputStream(UDByteArray)), out);
		} catch (IOException e) {
			logger.log(Level.ERROR,e.getMessage(),e);
			throw new RuntimeException(e);
		}
		// System.out.println("decompressByteArray while retutning from method"
		// + out.toByteArray());
		return out.toByteArray();
	}

	private static boolean isNull(byte[] compressed) {
		// TODO Auto-generated method stub
		return false;
	}

	// final bytesToHex function call
	private final static char[] hexArray = "0123456789ABCDEF".toCharArray();

	public static String bytesToHex(byte[] bytes) {
		char[] hexChars = new char[bytes.length * 2];
		for (int j = 0; j < bytes.length; j++) {
			int v = bytes[j] & 0xFF;
			hexChars[j * 2] = hexArray[v >>> 4];
			hexChars[j * 2 + 1] = hexArray[v & 0x0F];
		}
		return new String(hexChars);
	}

	public String convertHexToString(String hex) {

		StringBuilder sb = new StringBuilder();
		StringBuilder temp = new StringBuilder();

		// 49204c6f7665204a617661 split into two characters 49, 20, 4c...
		for (int i = 0; i < hex.length() - 1; i += 2) {

			// grab the hex in pairs
			String output = hex.substring(i, (i + 2));
			// convert hex to decimal
			int decimal = Integer.parseInt(output, 16);
			// convert the decimal to character
			sb.append((char) decimal);

			temp.append(decimal);
		}

		return sb.toString();
	}

	public  String decodeQRCode(MultipartFile qrCodeimage) throws NotFoundException,Exception {
		


		CommonsMultipartFile commonsMultipartFile = (CommonsMultipartFile) qrCodeimage;
		FileItem fileItem = commonsMultipartFile.getFileItem();
		DiskFileItem diskFileItem = (DiskFileItem) fileItem;
		String absPath = diskFileItem.getStoreLocation().getAbsolutePath();
		File file = new File(absPath);

		Result result = null;
		String resultdata = null;
		try {
			BufferedImage bufferedImage = ImageIO.read(file);
			LuminanceSource source = new BufferedImageLuminanceSource(bufferedImage);
			BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));

			result = new MultiFormatReader().decode(bitmap);
			resultdata = result.getText();

		} catch (NotFoundException e) {
			logger.log(Level.ERROR,e.getMessage(),e);
		} catch (Exception e) {
			logger.log(Level.ERROR,e.getMessage(),e);
		}
		return resultdata;

	
	}
	
	

	// convert string to sha256
	public String convertStringToSHA256(String clearText) throws NoSuchAlgorithmException {
		// logger.info("Convert String to SHA2.");
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		md.update(clearText.getBytes());
		byte byteData[] = md.digest();
		// convert the byte to hex format method 1
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < byteData.length; i++) {
			sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
		}

		// convert the byte to hex format method 2
		StringBuffer hexString = new StringBuffer();
		for (int i = 0; i < byteData.length; i++) { 
			String hex = Integer.toHexString(0xff & byteData[i]);
			if (hex.length() == 1)
				hexString.append('0'); 
			hexString.append(hex);
		}
		// logger.debug("Hex format : " + hexString.toString());
		return hexString.toString();

	}

	

	public BufferedImage createImageFromBytes(byte[] photoByte) throws IOException  {
		
		logger.info("inside createImageFromBytes::"+photoByte.length);
		
		logger.info("in createImageFromBytes ");
		ByteArrayInputStream bais = new ByteArrayInputStream(photoByte);
		BufferedImage bi=ImageIO.read(bais);
		logger.info("bi==>"+bi);
		return bi;
			 //return JDeli.read(bais);
	}

}
