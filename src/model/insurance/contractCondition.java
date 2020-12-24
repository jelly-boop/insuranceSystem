package model.insurance;
import java.util.Date;

enum guaranteeType {}
enum paymentType {}

public class contractCondition {
	
	private int id;
	private int contractConditionID; // �������ID
	private Date expirationDate; // ������
	private int guaranteeAmount; // �����
	private int paymentAmount; // �����
	private int paymentDay; // �� ���Գ�¥(��ĥ)

	public contractCondition(){
		
	}
	
	public int getContractConditionID() {
		return contractConditionID;
	}

	public void setContractConditionID(int contractConditionID) {
		this.contractConditionID = contractConditionID;
	}

	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	public int getGuaranteeAmount() {
		return guaranteeAmount;
	}

	public void setGuaranteeAmount(int guaranteeAmount) {
		this.guaranteeAmount = guaranteeAmount;
	}

	public int getPaymentAmount() {
		return paymentAmount;
	}

	public void setPaymentAmount(int paymentAmount) {
		this.paymentAmount = paymentAmount;
	}

	public int getPaymentDay() {
		return paymentDay;
	}

	public void setPaymentDay(int paymentDay) {
		this.paymentDay = paymentDay;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}