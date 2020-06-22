package tranaction;

public class Transaction 
{
	private String tranactionAccountNo;
	private String tranactionAccountHolderName;
	private String tranactionAmount;
	public String getTranactionAmount() {
		return tranactionAmount;
	}
	public void setTranactionAmount(String tranactionAmount) {
		this.tranactionAmount = tranactionAmount;
	}
	public String getTranactionAccountNo() {
		return tranactionAccountNo;
	}
	public void setTranactionAccountNo(String tranactionAccountNo) {
		this.tranactionAccountNo = tranactionAccountNo;
	}
	public String getTranactionAccountHolderName() {
		return tranactionAccountHolderName;
	}
	public void setTranactionAccountHolderName(String tranactionAccountHolderName) {
		this.tranactionAccountHolderName = tranactionAccountHolderName;
	}
}
