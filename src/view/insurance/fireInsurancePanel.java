package view.insurance;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import control.cFireInsurance;
import model.insurance.insurance.insuranceType;

public class fireInsurancePanel implements ActionListener {
	// controller
	private cFireInsurance cFireInsurance = new cFireInsurance();
	
	// panel
	public JPanel mainPanel;
	private ArrayList<JPanel> arr;	
	// insurance
	private JLabel idLabel;
	private JTextField idField;
	private JLabel nameLabel;
	private JTextField nameField;
	private JLabel descriptionLabel;
	private JTextField descriptionField;
	private JComboBox<Integer> comboBox;
	private JLabel buildingGradeLabel; // �ǹ��޼�(1~4��)
	private JLabel buildingSurfaceAreaLabel; // ���
	private JTextField buildingSurfaceAreaField;
	// contractCondition
	private JLabel cCIDLabel;
	private JTextField cCIDField;
	private JLabel expirationDateLabel;
	private JTextField expirationDateField;
	private JLabel guaranteeAmountLabel;
	private JTextField guaranteeAmountField;
	private JLabel paymentAmountLabel;
	private JTextField paymentAmountField;
	private JLabel paymentDayLabel;
	private JTextField paymentDayField;
	// save button
	private JButton saveButton;

	public fireInsurancePanel() {
		this.mainPanel = new JPanel();
		this.mainPanel.setLayout(new BoxLayout(this.mainPanel, BoxLayout.Y_AXIS));
		this.arr = new ArrayList<>();

		// insuranceID
		JPanel panel1 = new JPanel();
		this.idLabel = new JLabel("����ID");
		this.idField = new JTextField(10);
		this.idField.setText(cFireInsurance.getID());
	    panel1.add(this.idLabel);
	    panel1.add(this.idField);
		this.arr.add(panel1);
		
		// insuranceName
		JPanel panel2 = new JPanel();
		this.nameLabel = new JLabel("�����̸�");
		this.nameField = new JTextField(10);
		this.nameField.setText("ȭ�纸��");
		panel2.add(this.nameLabel);
		panel2.add(this.nameField);
		this.arr.add(panel2);
		
		// description
		JPanel panel3 = new JPanel();
		this.descriptionLabel = new JLabel("���輳��");
		this.descriptionField = new JTextField(30);
		this.descriptionField.setText("�� ������ ");
		panel3.add(this.descriptionLabel);
		panel3.add(this.descriptionField);
		this.arr.add(panel3);
		
		// buildingGrade
		JPanel panel4 = new JPanel();
		this.buildingGradeLabel = new JLabel("�ǹ��޼�(1~4)");
		this.comboBox = new JComboBox<Integer>();
		this.comboBox.addItem(1);
		this.comboBox.addItem(2);
		this.comboBox.addItem(3);
		this.comboBox.addItem(4);
		panel4.add(this.buildingGradeLabel);
		panel4.add(this.comboBox);
		this.arr.add(panel4);
		
		// buildingSurfaceArea
		JPanel panel5 = new JPanel();
		this.buildingSurfaceAreaLabel = new JLabel("���");
		this.buildingSurfaceAreaField = new JTextField(10);
		this.buildingSurfaceAreaField.setText("50");
		panel5.add(this.buildingSurfaceAreaLabel);
		panel5.add(this.buildingSurfaceAreaField);
		this.arr.add(panel5);
		
		// contractCondition - contractConditionID
		JPanel panel6 = new JPanel();
		this.cCIDLabel = new JLabel("�������ID");
		this.cCIDField = new JTextField(10);
		this.cCIDField.setText(cFireInsurance.getID());
		panel6.add(this.cCIDLabel);
		panel6.add(this.cCIDField);
		this.arr.add(panel6);
		
		// contractCondition - expirationDate
		JPanel panel7 = new JPanel();
		this.expirationDateLabel = new JLabel("������(yyyy-MM-dd)");
		this.expirationDateField = new JTextField(10);
		this.expirationDateField.setText("2025-06-20");
		panel7.add(this.expirationDateLabel);
		panel7.add(this.expirationDateField);
		this.arr.add(panel7);
		
		// contractCondition - guaranteeAmount
		JPanel panel8 = new JPanel();
		this.guaranteeAmountLabel = new JLabel("�����");
		this.guaranteeAmountField = new JTextField(20);
		this.guaranteeAmountField.setText("300000000");
		panel8.add(this.guaranteeAmountLabel);
		panel8.add(this.guaranteeAmountField);
		this.arr.add(panel8);
		
		// contractCondition - paymentAmount
		JPanel panel9 = new JPanel();
		this.paymentAmountLabel = new JLabel("�� �⺻ �����");
		this.paymentAmountField = new JTextField(10);
		this.paymentAmountField.setText("20000");
		panel9.add(this.paymentAmountLabel);
		panel9.add(this.paymentAmountField);
		this.arr.add(panel9);
		
		// contractCondition - paymentDay
		JPanel panel10 = new JPanel();
		Calendar cal = Calendar.getInstance();
		String date =  Integer.toString(cal.get(cal.DATE)) ;
		this.paymentDayLabel = new JLabel("���� ��¥");
		this.paymentDayField = new JTextField(10);
		this.paymentDayField.setText(date); // ���ó�¥�� �⺻����
		panel10.add(this.paymentDayLabel);
		panel10.add(this.paymentDayField);
		this.arr.add(panel10);
		
		// buttons
		JPanel panel11 = new JPanel();
		this.saveButton = new JButton("����");
		this.saveButton.addActionListener(this);
		panel11.add(this.saveButton);
		this.arr.add(panel11);
		
		for(JPanel panel:this.arr) {
			this.mainPanel.add(panel);
			panel.setBackground(Color.white);
		}
	}

	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		// insurance
		int insuranceID = Integer.parseInt(this.idField.getText());
		String insuranceName = this.nameField.getText();
		String description = this.descriptionField.getText();
		int buildingGrade = Integer.parseInt(this.comboBox.getSelectedItem().toString());
		int buildingSurfaceArea = Integer.parseInt(this.buildingSurfaceAreaField.getText());
		// contractCondition
		int contractConditionID = Integer.parseInt(this.cCIDField.getText());
		String date = this.expirationDateField.getText();
		
		int guaranteeAmount = Integer.parseInt(this.guaranteeAmountField.getText());
		int paymentAmount = Integer.parseInt(this.paymentAmountField.getText());
		int paymentDay = Integer.parseInt(this.paymentDayField.getText());
		
		if(actionEvent.getActionCommand().equals("����")) {
			cFireInsurance.makeInsurance(insuranceID,insuranceName,insuranceType.FIREINSURANCE,description,
					buildingGrade,buildingSurfaceArea,contractConditionID,date,guaranteeAmount,paymentAmount,paymentDay);
	
			// set �Ϸ� ���̾�α� ����
			JOptionPane.showMessageDialog(this.mainPanel,
					"����ID: "+insuranceID+"\n"+"�����̸�: "+insuranceName,
					"����Ϸ�",
					JOptionPane.INFORMATION_MESSAGE);
		}
	}
}