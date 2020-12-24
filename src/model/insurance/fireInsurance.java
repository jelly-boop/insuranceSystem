package model.insurance;
import model.customer.customer;

public class fireInsurance extends insurance { // ȭ�纸��
	
	private int buildingGrade; // �ǹ��޼�(1~4�ޱ��� ����)
	private int buildingSurfaceArea; // ���

	public fireInsurance(){

	}

	public float calculateRate(customer targetCustomer) {
		float rate = 1;
		
		// building property
		if (targetCustomer.getProperty().getHouse()>=10000000) rate*=1.1; // 1��
		else if (targetCustomer.getProperty().getHouse()>=50000000) rate*=1.2; // 5��
		else if (targetCustomer.getProperty().getHouse()>=100000000) rate*=1.3; // 10��
		else if (targetCustomer.getProperty().getHouse()>=200000000) rate*=1.5; // 20��
		else rate*=0.9;
		
		if (targetCustomer.getProperty().getHouse()>500000000) rate*=1.3;
		else rate*=1.1;
		
		// �ǹ��޼� // �޼� �������� �ҿ� �� Ÿ�� ������ ����� ���
		switch (this.buildingGrade) {
		case 1: rate*=1.1;
			break;
		case 2: rate*=1.2;
			break;
		case 3: rate*=1.4;
			break;
		case 4: rate*=1.6;
			break;
		default:
			break;
		}
		
		// ���
		if (this.buildingSurfaceArea<20) rate*=0.9;
		else if (this.buildingSurfaceArea<50) rate*=1.1;
		else if (this.buildingSurfaceArea<100) rate*=1.2;
		else rate*=1.3;
		
		
		return rate;
	}

	public int getBuildingGrade() {
		return buildingGrade;
	}

	public void setBuildingGrade(int buildingGrade) {
		this.buildingGrade = buildingGrade;
	}

	public int getBuildingSurfaceArea() {
		return buildingSurfaceArea;
	}

	public void setBuildingSurfaceArea(int buildingSurfaceArea) {
		this.buildingSurfaceArea = buildingSurfaceArea;
	}

}