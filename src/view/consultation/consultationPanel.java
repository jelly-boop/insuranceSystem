package view.consultation;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

public class consultationPanel implements ActionListener {
	public JPanel panel;

	// ����û, ���亯 �г�
	private consultationRequestPanel consultationRequestPanel;
	private consultationAnswerPanel consultationAnswerPanel;
	
	public consultationPanel() {
		this.panel = new JPanel();
		
		JButton btn1 = new JButton("����û�ϱ�");
		JButton btn2 = new JButton("���亯�ϱ�");
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn1.setBackground(Color.white);
		btn2.setBackground(Color.white);
		this.panel.add(btn1);
		this.panel.add(btn2);
		this.panel.setBackground(Color.white);
		this.panel.setBorder(BorderFactory.createEmptyBorder(50,50,20,20));
	}

	@Override
	public void actionPerformed(ActionEvent actionEvent) {		
		this.panel.removeAll();
		this.panel.updateUI();
		
		if(actionEvent.getActionCommand().equals("����û�ϱ�")) {
			this.consultationRequestPanel = new consultationRequestPanel();
			this.panel.add(this.consultationRequestPanel.mainPanel);
		} else if(actionEvent.getActionCommand().equals("���亯�ϱ�")) {
			this.consultationAnswerPanel = new consultationAnswerPanel();
			this.panel.add(this.consultationAnswerPanel.mainPanel);
		}
	}
	
}
