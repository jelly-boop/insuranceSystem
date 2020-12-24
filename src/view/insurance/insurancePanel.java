package view.insurance;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import model.main.insuranceSystemMain;

public class insurancePanel implements ActionListener {
	
	// panel, buttons
	public JPanel panel;
	private JPanel panel1;
	private JPanel panel2;
	private ArrayList<JButton> arr;
	private JButton btnLife;
	private JButton btnFire;
	private JButton btnCancer;
	private JButton btnCar;
	private JButton btnInsuranceList;
	
	// panels
	public lifeInsurancePanel lifeInsurancePanel; // ������
	public fireInsurancePanel fireInsurancePanel; // ȭ�纸��
	public cancerInsurancePanel cancerInsurancePanel; // �Ϻ���
	public carInsurancePanel carInsurancePanel; // �ڵ�������
	private insuranceListPanel insuranceListPanel; // ���踮��Ʈ

	public insurancePanel() {	
		this.panel = new JPanel();
		this.panel.setLayout(new BoxLayout(this.panel, BoxLayout.Y_AXIS));
		this.panel.setBackground(Color.white);
		
		this.panel1 = new JPanel();
		this.panel1.setBorder(BorderFactory.createEmptyBorder(30,10,10,10));
		this.panel1.setBackground(Color.white);
		this.panel1.setLayout(new GridLayout(2,2));
		this.btnLife = new JButton("������");
		this.btnFire = new JButton("ȭ�纸��");
		this.btnCancer = new JButton("�Ϻ���");
		this.btnCar = new JButton("�ڵ�������");
		
		this.panel2 = new JPanel();
		this.panel2.setBackground(Color.white);
		this.btnInsuranceList = new JButton("���踮��Ʈ");
		this.btnInsuranceList.addActionListener(this);
		this.panel2.add(this.btnInsuranceList);
		
		this.panel.add(this.panel1);
		this.panel.add(this.panel2);
		
		// arrayList�� btn �߰�
		this.arr = new ArrayList<>();
		this.arr.add(this.btnLife);
		this.arr.add(this.btnFire);
		this.arr.add(this.btnCancer);
		this.arr.add(this.btnCar);
		
		Dimension dimension = new Dimension(200,200);
		for(JButton btn:this.arr) {
			btn.setBackground(Color.white);
			btn.setForeground(new Color(0,177, 78));
			btn.setPreferredSize(dimension);
			btn.addActionListener(this);
			this.panel1.add(btn);
		}
	}

	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		this.panel.removeAll();
		this.panel.updateUI();
		
		if(actionEvent.getActionCommand().equals("������")) {
			this.lifeInsurancePanel = new lifeInsurancePanel();
			this.panel.add(this.lifeInsurancePanel.mainPanel);			
		} else if(actionEvent.getActionCommand().equals("ȭ�纸��")) {
			this.fireInsurancePanel = new fireInsurancePanel();
			this.panel.add(this.fireInsurancePanel.mainPanel);
		} else if(actionEvent.getActionCommand().equals("�Ϻ���")) {
			this.cancerInsurancePanel = new cancerInsurancePanel();
			this.panel.add(this.cancerInsurancePanel.mainPanel);
		} else if(actionEvent.getActionCommand().equals("�ڵ�������")) {
			this.carInsurancePanel = new carInsurancePanel();
			this.panel.add(this.carInsurancePanel.mainPanel);
			
		} else if(actionEvent.getActionCommand().equals("���踮��Ʈ")) {
			if(actionEvent.getActionCommand().equals("���踮��Ʈ")) {
				this.panel.removeAll();
				this.panel.updateUI();	
				try {
					insuranceListPanel = new insuranceListPanel(insuranceSystemMain.insuranceDao.selectAll());
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				this.panel.add(insuranceListPanel.panel);
			}
		}
	}
	
}
