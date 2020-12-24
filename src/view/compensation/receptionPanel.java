package view.compensation;

import java.awt.Checkbox;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import control.cReception;

public class receptionPanel implements MouseListener { // �����ϱ�
	// controller
	private cReception cReception = new cReception();
	
	public JPanel panel;
	JPanel p0 = new JPanel();
	JPanel p1 = new JPanel();
	JPanel p2 = new JPanel();
	JPanel p3 = new JPanel();
	JPanel p4 = new JPanel();
	JPanel p5 = new JPanel();

	JTextField txtID = new JTextField();
	JTextField txtPlace = new JTextField(30);
	JTextField txtTime = new JTextField(10);
	JTextField txtDate = new JTextField(10);
	JTextField txtCustomerID = new JTextField(10);
	JTextField txtStatus = new JTextField(30);
	JTextField txtInsuranceID = new JTextField(30);

	JButton btn1, btn2;
	JButton btnSearch = new JButton("ã��");

	Checkbox cbLife, cbFire, cbMarine, cbCar;
	ArrayList<JPanel> al = new ArrayList<JPanel>();
	int id;

	public receptionPanel() {
		this.panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

		JLabel l0 = new JLabel("��ID ");
		p0.add(l0);
		p0.add(txtID);
		txtID.setText("3");
		al.add(p0);

		JLabel l1 = new JLabel("��� ��� ");
		p1.add(l1);
		p1.add(txtPlace);
		txtPlace.setText("��ǰ�");
		al.add(p1);

		JLabel l = new JLabel("���¥ ");
		p2.add(l);
		p2.add(txtDate);
		txtDate.setText("2020-06-18");
		al.add(p2);

		JLabel l2 = new JLabel("���ð� ");
		p3.add(l2);
		p3.add(txtTime);
		txtTime.setText("0318");
		al.add(p3);

		JLabel l4 = new JLabel("������  ");
		p4.add(l4);
		p4.add(txtStatus);
		txtStatus.setText("���ݹڻ� ��������");
		al.add(p4);

		JLabel l5 = new JLabel("����ID");
		p5.add(l5);
		btnSearch.addMouseListener(this);
		p5.add(txtInsuranceID);
		p5.add(btnSearch);
		al.add(p5);

		btn1 = new JButton("�����ϱ�");
		btn2 = new JButton(" �� ��  ");
		btn1.addMouseListener(this);
		btn2.addMouseListener(this);
		btn1.setBackground(Color.white);
		btn2.setBackground(Color.white);
		p3.add(btn1);
		p3.add(btn2);
		p3.setBorder(BorderFactory.createEmptyBorder(40, 20, 20, 20));
		al.add(p3);

		for (JPanel p : al) {
			panel.add(p);
			panel.setBorder(BorderFactory.createEmptyBorder(40, 20, 20, 20));
			p.setBackground(Color.white);
		}
		panel.setBackground(Color.white);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == btn1) { // �����ϱ�
			String time=this.txtTime.getText();
			String place=this.txtPlace.getText();
			String date=this.txtDate.getText();
			int customerID=Integer.parseInt(this.txtID.getText());
			String status=this.txtStatus.getText();
			int insuranceID=Integer.parseInt(txtInsuranceID.getText());
			cReception.makeReception(time,place,date,customerID,status,insuranceID);			
			JOptionPane.showMessageDialog(null, "�����Ǿ����ϴ�!");

		} else if (e.getSource() == btn2) {
			txtID.setText("");
			txtPlace.setText("");
			txtTime.setText("");
			txtDate.setText("");
			txtCustomerID.setText("");
			txtStatus.setText("");
			txtInsuranceID.setText("");
			JOptionPane.showMessageDialog(null, "��� �Ǿ����ϴ�! ���� Insurance System�� ���� �޴��� ���ư�����");

		} else if (e.getSource() == btnSearch) {
			int id = Integer.parseInt(txtID.getText());
			JOptionPane.showMessageDialog(null, "���Ե� ����:  " + cReception.checkInsuranceID(id));
		}
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

}
