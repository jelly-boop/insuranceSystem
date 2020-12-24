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

import control.cCarInsurance;
import model.insurance.carInsurance.carType;
import model.insurance.insurance.insuranceType;

public class carInsurancePanel implements ActionListener {
	// controller
	private cCarInsurance cCarInsurance = new cCarInsurance();
	
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
	private JComboBox<String> accidentComboBox;
	private JLabel accidentHistoryLabel; // 3�� �̳� ����̷�
	private JLabel drivingExperienceLabel; // ������� // ���� : ��
	private JTextField drivingExperienceField;
	private JComboBox<carType> typeComboBox;
	private JLabel carTypeLabel; // ����
	private JLabel carNumberLabel; // �ڵ��� ��ȣ
	private JTextField carNumberField;
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

	public carInsurancePanel() {
		this.mainPanel = new JPanel();
		this.mainPanel.setLayout(new BoxLayout(this.mainPanel, BoxLayout.Y_AXIS));
		this.arr = new ArrayList<>();

		// insuranceID
		JPanel panel1 = new JPanel();
		this.idLabel = new JLabel("����ID");
		this.idField = new JTextField(10);
		this.idField.setText(cCarInsurance.getID());
		panel1.add(this.idLabel);
		panel1.add(this.idField);
		this.arr.add(panel1);

		// insuranceName
		JPanel panel2 = new JPanel();
		this.nameLabel = new JLabel("�����̸�");
		this.nameField = new JTextField(10);
		this.nameField.setText("�ڵ�������");
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

		// accidentHistory
		JPanel panel4 = new JPanel();
		this.accidentHistoryLabel = new JLabel("3�� �̳� ��� �̷�");
		this.accidentComboBox = new JComboBox<String>();
		this.accidentComboBox.addItem("�ִ�");
		this.accidentComboBox.addItem("����");
		panel4.add(this.accidentHistoryLabel);
		panel4.add(this.accidentComboBox);
		this.arr.add(panel4);

		// drivingExperience
		JPanel panel5 = new JPanel();
		this.drivingExperienceLabel = new JLabel("�������(1�� �̸��� ��� 0���� �Է��Ͻÿ�)");
		this.drivingExperienceField = new JTextField(10);
		this.drivingExperienceField.setText("0");
		panel5.add(this.drivingExperienceLabel);
		panel5.add(this.drivingExperienceField);
		this.arr.add(panel5);

		// carType
		JPanel panel6 = new JPanel();
		this.carTypeLabel = new JLabel("�ڵ��� ����");
		this.typeComboBox = new JComboBox<carType>();
		this.typeComboBox.addItem(carType.COMPACT_CAR);
		this.typeComboBox.addItem(carType.MIDSIZE_CAR);
		this.typeComboBox.addItem(carType.FULLSIZE_CAR);
		panel6.add(this.carTypeLabel);
		panel6.add(this.typeComboBox);
		this.arr.add(panel6);

		// carRegistrationNumber
		JPanel panel7 = new JPanel();
		this.carNumberLabel = new JLabel("�ڵ��� ��ȣ");
		this.carNumberField = new JTextField(10);
		this.carNumberField.setText("35��1234");
		panel7.add(this.carNumberLabel);
		panel7.add(this.carNumberField);
		this.arr.add(panel7);

		// contractCondition - contractConditionID
		JPanel panel8 = new JPanel();
		this.cCIDLabel = new JLabel("�������ID");
		this.cCIDField = new JTextField(10);

		this.cCIDField.setText(cCarInsurance.getID());
		panel8.add(this.cCIDLabel);
		panel8.add(this.cCIDField);
		this.arr.add(panel8);

		// contractCondition - expirationDate
		JPanel panel9 = new JPanel();
		this.expirationDateLabel = new JLabel("������(yyyy-MM-dd)");
		this.expirationDateField = new JTextField(10);
		this.expirationDateField.setText("2025-06-20");
		panel9.add(this.expirationDateLabel);
		panel9.add(this.expirationDateField);
		this.arr.add(panel9);

		// contractCondition - guaranteeAmount
		JPanel panel10 = new JPanel();
		this.guaranteeAmountLabel = new JLabel("�����");
		this.guaranteeAmountField = new JTextField(20);
		this.guaranteeAmountField.setText("100000000");
		panel10.add(this.guaranteeAmountLabel);
		panel10.add(this.guaranteeAmountField);
		this.arr.add(panel10);

		// contractCondition - paymentAmount
		JPanel panel11 = new JPanel();
		this.paymentAmountLabel = new JLabel("�� �⺻ �����");
		this.paymentAmountField = new JTextField(10);
		this.paymentAmountField.setText("20000");
		panel11.add(this.paymentAmountLabel);
		panel11.add(this.paymentAmountField);
		this.arr.add(panel11);

		// contractCondition - paymentDay
		JPanel panel12 = new JPanel();
		Calendar cal = Calendar.getInstance();
		String date = Integer.toString(cal.get(cal.DATE));
		this.paymentDayLabel = new JLabel("���� ��¥");
		this.paymentDayField = new JTextField(10);
		this.paymentDayField.setText(date); // ���ó�¥�� �⺻����
		panel12.add(this.paymentDayLabel);
		panel12.add(this.paymentDayField);
		this.arr.add(panel12);

		// buttons
		JPanel panel13 = new JPanel();
		this.saveButton = new JButton("����");
		this.saveButton.addActionListener(this);
		panel13.add(this.saveButton);
		this.arr.add(panel13);

		for (JPanel panel : this.arr) {
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
		String accidentHistory = this.accidentComboBox.getSelectedItem().toString();
		boolean accident;
		if (accidentHistory.equals("�ִ�"))
			accident = true;
		else
			accident = false;
		int drivingExperience = Integer.parseInt(this.drivingExperienceField.getText());
		String cType = this.typeComboBox.getSelectedItem().toString();
		String carNumber = this.carNumberField.getText();
		// contractCondition
		int contractConditionID = Integer.parseInt(this.cCIDField.getText());
		String date = this.expirationDateField.getText();

		int guaranteeAmount = Integer.parseInt(this.guaranteeAmountField.getText());
		int paymentAmount = Integer.parseInt(this.paymentAmountField.getText());
		int paymentDay = Integer.parseInt(this.paymentDayField.getText());

		if (actionEvent.getActionCommand().equals("����")) {
			cCarInsurance.makeInsurance(insuranceID, insuranceName, insuranceType.CARINSURANCE, description, accident,
					drivingExperience, cType, carNumber, contractConditionID, date, guaranteeAmount,
					paymentAmount, paymentDay);

			// set �Ϸ� ���̾�α� ����
			JOptionPane.showMessageDialog(this.mainPanel, "����ID: " + insuranceID + "\n" + "�����̸�: " + insuranceName,
					"����Ϸ�", JOptionPane.INFORMATION_MESSAGE);
		}
	}

}
