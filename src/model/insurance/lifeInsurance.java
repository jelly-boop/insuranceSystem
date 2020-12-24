package model.insurance;
import model.customer.customer;

public class lifeInsurance extends insurance { // ���ź���

	public lifeInsurance(){

	}
	
	public float calculateRate(customer targetCustomer) {
		float rate = 1;
		
		// ����
		if (targetCustomer.isGender()) rate*=0.9; // female
		else rate*=1.1; // male
		
		// ����
		if (targetCustomer.getAge()<10) rate*=1.1;
		else if (targetCustomer.getAge()<50) rate*=0.9;
		else rate*=1.3;
		
		// ����
		switch(targetCustomer.getJob()) {
		case DRIVER: rate*=1.3;
		break;
		case INTERNALEMPLOYEE: rate*=0.9;
		break;
		case EXTERNALEMPLOYEE: rate*=1.1;
		break;
		case SOLDIER: rate*=1.2;
		break;
		case NO_JOB: rate*=0.6;
		break;
		default:
			break;
		}
		
		// ���� ����
		switch(targetCustomer.getIllHistory()) {
		case NOTHING: rate*=0.5;
		break;
		case CANCER: rate*=1.4;
		break;
		case BLOODPRESURE: rate*=1.3;
		break;
		case GLYCOSURIA: rate*=1.2;
		break;
		case ACCIDENT: rate*=1.2;
		break;
		default:
			break;
		}

		// ������
		switch(targetCustomer.getFamilyIllHistory()) {
		case NOTHING: rate*=0.6;
		break;
		case CANCER: rate*=1.5;
		break;
		case BLOODPRESURE: rate*=1.4;
		break;
		case GLYCOSURIA: rate*=1.3;
		break;
		default:
			break;
		}
		
		return rate;
	}

}