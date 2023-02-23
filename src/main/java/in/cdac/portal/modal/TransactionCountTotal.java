package in.cdac.portal.modal;

public class TransactionCountTotal {
	
private int success;
private int failure;
private int total;

public TransactionCountTotal()
{
	success=0;
	failure=0;
	total=0;
}

public int getSuccess() {
	return success;
}

public void setSuccess(int success) {
	this.success = success;
}

public int getFailure() {
	return failure;
}

public void setFailure(int failure) {
	this.failure = failure;
}

public int getTotal() {
	return total;
}

public void setTotal(int total) {
	this.total = total;
}



}
