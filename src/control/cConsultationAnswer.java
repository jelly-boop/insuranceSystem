package control;

import java.sql.SQLException;
import java.util.ArrayList;

import model.consultation.consultation;
import model.main.insuranceSystemMain;

public class cConsultationAnswer {
	private consultation consultation; // model
	private ArrayList<consultation> consultationList; // ��� ����Ʈ
	
	public cConsultationAnswer() {
		try {
			this.consultationList = insuranceSystemMain.consultationDao.selectAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<consultation> getConsultationList() {
		return this.consultationList;
	}

	public consultation showContents(String selectedItem) { // ���ǳ���Ȯ��
		for (consultation consultation: consultationList) {
			if (Integer.parseInt(selectedItem) == consultation.getConsultationID()) {
				this.consultation = consultation;
				return consultation;
			}
		}
		return null;
	}

	public void finishConsultation() { // ���Ϸ�
		// update
		try {
			insuranceSystemMain.consultationDao.update(consultation);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
