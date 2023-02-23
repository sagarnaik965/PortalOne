package in.cdac.webclient.userservice;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import javax.imageio.IIOException;

import org.springframework.stereotype.Service;

import in.cdac.webclient.model.QR_codepojo;



@Service
public interface OfflineQRCodeService {

	public QR_codepojo ValidateData(String userData)
			throws UnsupportedEncodingException, IOException, IIOException, NoSuchAlgorithmException, Exception;

}
