package view.customer;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import control.cCustomer;

public class customerPanel extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	
	// controller
	private cCustomer cCustomer = new cCustomer();
	// �� ����Ʈ �г�
	private customerListPanel customerListPanel;

	public JPanel panel = new JPanel();
	JPanel panelID = new JPanel();
	JPanel panelPW = new JPanel();
	JPanel panel1 = new JPanel();
	JPanel panel2 = new JPanel();
	JPanel panel3 = new JPanel();
	JPanel panel4 = new JPanel();
	JPanel panel5 = new JPanel();
	JPanel panel6 = new JPanel();
	JPanel panel7 = new JPanel();
	JPanel panel8 = new JPanel();
	JPanel panel9 = new JPanel();
	JPanel panel10 = new JPanel();
	JPanel panel11 = new JPanel();
	JPanel panel12=new JPanel();

	JLabel lbName = new JLabel("�̸�"); 
	JLabel lbGen = new JLabel("����"); 
	JLabel lbAddress = new JLabel("�ּ�");
	JLabel lbIdentificationNo = new JLabel("�ֹε�Ϲ�ȣ");
	JLabel lbPhoneNo = new JLabel("��ȭ��ȣ"); 
	JLabel lbJob = new JLabel("����");
	JLabel lbProperty = new JLabel("���");
	JLabel lbHouse = new JLabel("��");
	JLabel lbCar = new JLabel("��");
	JLabel lbAge = new JLabel("����");
	JLabel lbIllHistory = new JLabel("����");
	JLabel lbFamilyIll = new JLabel("������");
	JLabel lbAccident=new JLabel("���");
	JTextField name, gender, address, identificationNO, phoneNo, house, car, age, txtJob, txtIllHistory, txtFamilyIll,txtAccident;
	String sname, sgender, saddress, sidentificationNO, sphoneNo, shouse, scar, sage, stxtJob, stxtIllHistory, stxtFamilyIll,stxtAccident;
	
	ArrayList<JPanel> al = new ArrayList<>();
	ArrayList<JLabel> labels = new ArrayList<>();
	JButton btn1 = new JButton("�����ϱ�");
	JButton btn2 = new JButton("������Ʈ");
	Font font = new Font("SanSerif", Font.BOLD, 15);

	public customerPanel() {
		lbName.setFont(font);
		panel1.add(lbName);
		name = new JTextField("�ֹ̳�");
		panel1.add(name);

		lbAge.setFont(font);
		panel2.add(lbAge);
		age = new JTextField("20");
		panel2.add(age);

		lbGen.setFont(font);
		panel3.add(lbGen);
		panel3.add(gender = new JTextField("����"));

		lbIdentificationNo.setFont(font);
		panel4.add(lbIdentificationNo);
		identificationNO = new JTextField("010504");
		panel4.add(identificationNO);
		panel4.add(new JPasswordField("345234"));

		lbPhoneNo.setFont(font);
		panel5.add(lbPhoneNo);
		phoneNo = new JTextField("010-1234-1234");
		panel5.add(phoneNo);

		lbProperty.setFont(font);
		panel6.add(lbProperty);
		panel6.add(lbHouse);
		panel6.add(house = new JTextField("1000000000"));
		panel6.add(lbCar);
		panel6.add(car = new JTextField("390000000"));
		panel.add(panel6);

		lbJob.setFont(font);
		panel7.add(lbJob);
		panel7.add(txtJob = new JTextField("SOLDIER"));

		lbIllHistory.setFont(font);
		panel8.add(lbIllHistory);
		panel8.add(txtIllHistory = new JTextField("GLYCOSURIA"));

		lbFamilyIll.setFont(font);

		panel9.add(lbFamilyIll);
		panel9.add(txtFamilyIll = new JTextField("NOTHING"));

		lbAddress.setFont(font);
		panel10.add(lbAddress);
		address = new JTextField("����");
		panel10.add(address);

		btn1.setBackground(Color.white);
		btn2.setBackground(Color.white);
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		panel11.setBorder(BorderFactory.createEmptyBorder(30, 20, 20, 20));

		panel11.add(btn1);
		panel11.add(btn2);
		
		panel12.add(lbAccident); 
		panel12.add(txtAccident=new JTextField("����"));

		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		al.add(panel1);
		al.add(panel2);
		al.add(panel3);
		al.add(panel4);
		al.add(panel5);
		al.add(panel6);
		al.add(panel7);
		al.add(panel8);
		al.add(panel9);
		al.add(panel10);
		al.add(panel12);
		al.add(panel11);
		
		for (JPanel p : al) {
			panel.add(p);
			p.setBackground(Color.WHITE);
		}
		panel.setSize(600, 400);

	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		sname=name.getText();
		sgender=gender.getText();
		saddress=address.getText();
		sidentificationNO=identificationNO.getText();
		sphoneNo=phoneNo.getText();
		shouse=house.getText();
		scar=car.getText();
		sage=age.getText();
		stxtJob=txtJob.getText();
		stxtIllHistory=txtIllHistory.getText();
		stxtFamilyIll=txtFamilyIll.getText();
		stxtAccident=txtAccident.getText();
		
		if (e.getActionCommand().equals("�����ϱ�")) {
			cCustomer.addCustomer(sname,sgender,saddress,sidentificationNO,sphoneNo,
					shouse,scar,sage,stxtJob,stxtIllHistory,stxtFamilyIll,stxtAccident);			
			JOptionPane.showMessageDialog(null, name.getText() + "�� ���ԵǼ̽��ϴ�!",
					"Success", JOptionPane.WARNING_MESSAGE);

		} 
		else if(e.getActionCommand().equals("������Ʈ")) {
			this.panel.removeAll();
			this.panel.updateUI();		
			this.customerListPanel = new customerListPanel(cCustomer.getCustomerList());
			this.panel.add(this.customerListPanel.panel);
		}
	}

}
