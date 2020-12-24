package model.insurance;
import model.customer.customer;

public class cancerInsurance extends insurance { // �Ϻ���

	public cancerInsurance(){

	}

	public float calculateRate(customer targetCustomer) {
		float rate = 1;
		
		// ����
		if (targetCustomer.isGender()) rate*=1.3; // female // �ֱ� ������ �� �߻��� ����
		else rate*=1.1; // male
		
		// ����
		if (targetCustomer.getAge()<30) rate*=1.1;
		else if (targetCustomer.getAge()<50) rate*=1.2;
		else if (targetCustomer.getAge()<70) rate*=1.3;
		else rate*=1.4;
		
		// ������
		switch(targetCustomer.getFamilyIllHistory()) {
		case NOTHING: rate*=0.9;
		break;
		case CANCER: rate*=1.5;
		break;
		default:
			break;
		}
		
		return rate;
	}
	
}