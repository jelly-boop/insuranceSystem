package view.consultation;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.Border;

import control.cConsultationAnswer;
import model.consultation.consultation;

public class consultationAnswerPanel implements ActionListener {
	// controller
	cConsultationAnswer cConsultationAnswer = new cConsultationAnswer();
	
	public JPanel mainPanel;
	private ArrayList<JPanel> arr;	
	private JComboBox<String> inquiryList;
	private JButton checkButton;
	private JTextArea contents;
	private JButton okButton;
	private Border border = BorderFactory.createLineBorder(Color.BLACK);
		
	public consultationAnswerPanel() {		
		this.mainPanel = new JPanel();
		this.mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		this.arr = new ArrayList<>();
		
		JPanel panel1 = new JPanel();
		this.inquiryList = new JComboBox<String>();
		for (consultation consultation: cConsultationAnswer.getConsultationList()) {
			this.inquiryList.addItem(Integer.toString(consultation.getConsultationID()));
		}
		this.checkButton = new JButton("���ǳ���Ȯ��");
		this.checkButton.setBackground(Color.white);
		this.checkButton.addActionListener(this);
		panel1.add(this.inquiryList);
		panel1.add(this.checkButton);
		this.arr.add(panel1);
		
		JPanel panel2 = new JPanel();
		this.contents = new JTextArea("�� ��Ͽ��� �ϳ��� ���� �� ���ǳ���Ȯ���� �����ÿ�",10,45);
		this.contents.setBorder(border);
		panel2.add(this.contents);
		this.arr.add(panel2);
		
		JPanel panel3 = new JPanel();
		this.okButton = new JButton("���Ϸ�");
		this.okButton.addActionListener(this);
		panel3.add(this.okButton);
		this.arr.add(panel3);
		
		for(JPanel panel:this.arr) {
			this.mainPanel.add(panel);
			panel.setBackground(Color.white);
		}
	}

	@Override
	public void actionPerformed(ActionEvent actionEvent) {	
		String selectedItem = this.inquiryList.getSelectedItem().toString();
		
		if(actionEvent.getActionCommand().equals("���ǳ���Ȯ��")) {
			if (cConsultationAnswer.showContents(selectedItem) != null) {
				this.contents.setText(cConsultationAnswer.showContents(selectedItem).getEnquirerName() 
						+ "\n" + cConsultationAnswer.showContents(selectedItem).getContactNumber() 
						+ "\n" + cConsultationAnswer.showContents(selectedItem).getInquiry());
				}
			
		} else if(actionEvent.getActionCommand().equals("���Ϸ�")) {
			cConsultationAnswer.finishConsultation();
			
			// ���̾�α�
			JOptionPane.showMessageDialog(null,
					"����� �Ϸ�Ǿ����ϴ�.",
					"�ȳ�â",
					JOptionPane.INFORMATION_MESSAGE);	
		}
	}
	
}
