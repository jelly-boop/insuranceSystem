package model.insurance;
import model.customer.customer;

public class carInsurance extends insurance { // �ڵ�������
	public enum carType {COMPACT_CAR, MIDSIZE_CAR, FULLSIZE_CAR}
	
	private boolean accidentHistory; // 3�� �̳� ����̷�
	private int drivingExperience; // ������� // ���� : ��
	public carType carType; // ����
	private String carRegistrationNumber; // �ڵ��� ��ȣ

	public carInsurance(){

	}

	public float calculateRate(customer targetCustomer) { // �ڵ������� ����
		float rate = 1;
		
		// car property
		if (targetCustomer.getProperty().getCar()>100000000) rate*=1.5;
		else if (targetCustomer.getProperty().getCar()>50000000) rate*=1.2;
		else rate*=1.1;
		
		// 3�� �̳� ����̷�
		if (this.accidentHistory) rate*=1.4;
		else rate*=0.8;
		
		// �������� �������
		if (this.drivingExperience<1) rate*=1.5;
		else rate*=1.1;

		// ����
		switch (carType) {
		case COMPACT_CAR: rate*=1.1;
			break;
		case MIDSIZE_CAR: rate*=1.3;
			break;
		case FULLSIZE_CAR: rate*=1.5;
			break;
		default:
			break;
		}
		
		return rate;
	}

	public boolean isAccidentHistory() {
		return accidentHistory;
	}

	public void setAccidentHistory(boolean accidentHistory) {
		this.accidentHistory = accidentHistory;
	}

	public int getDrivingExperience() {
		return drivingExperience;
	}

	public void setDrivingExperience(int drivingExperience) {
		this.drivingExperience = drivingExperience;
	}

	public carType getCarType() {
		return carType;
	}

	public void setCarType(carType carType) {
		this.carType = carType;
	}

	public String getCarRegistrationNumber() {
		return carRegistrationNumber;
	}

	public void setCarRegistrationNumber(String carRegistrationNumber) {
		this.carRegistrationNumber = carRegistrationNumber;
	}

}