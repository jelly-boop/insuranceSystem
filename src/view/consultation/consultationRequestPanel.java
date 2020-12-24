package view.consultation;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

import control.cConsultationRequest;

public class consultationRequestPanel implements ActionListener, Runnable {
	// controller
	private cConsultationRequest cConsultationRequest = new cConsultationRequest();

	public JPanel mainPanel;
	private ArrayList<JPanel> arr;	
	private JButton saveButton;
	private JButton okButton;
	private JButton removeButton;
	private JLabel now;
	private Thread thread;
	private JLabel name;
	private JLabel number;
	private JLabel inquiry;
	private JTextArea contents;
	private JTextField enquirerName;
	private JTextField contactNumber;
	private Border border;
			
	public consultationRequestPanel() {		
		this.mainPanel = new JPanel();
		this.mainPanel.setLayout(new BoxLayout(this.mainPanel, BoxLayout.Y_AXIS));
		this.arr = new ArrayList<>();
		
		// time
		JPanel panel1 = new JPanel();
		this.now = new JLabel();
		this.now.setFont(new Font("Font", Font.ROMAN_BASELINE, 15));
	    if (thread == null) {
		   thread = new Thread(this);
		   thread.start();
	    }
	    panel1.add(this.now);
		this.arr.add(panel1);
		
		// name
		JPanel panel2 = new JPanel();
		this.name = new JLabel("����");
		this.enquirerName = new JTextField(10);
		this.enquirerName.setText("ȫ�浿");
		panel2.add(this.name);
		panel2.add(this.enquirerName);
		this.arr.add(panel2);
		
		// contact number
		JPanel panel3 = new JPanel();
		this.number = new JLabel("����ó");
		this.contactNumber = new JTextField(20);
		this.contactNumber.setText("010-1234-1234");
		panel3.add(this.number);
		panel3.add(this.contactNumber);
		this.arr.add(panel3);
		
		// contents
		JPanel panel4 = new JPanel();
		this.inquiry = new JLabel("���ǳ���");
		this.contents = new JTextArea("������ �Է��ϼ���" + "\n" + "������ ���� ������ ����û�� ��������",10,45);
		this.border = BorderFactory.createLineBorder(Color.BLACK);
		this.contents.setBorder(this.border);
		panel4.add(this.inquiry);
		panel4.add(this.contents);
		this.arr.add(panel4);
		
		// buttons
		JPanel panel5 = new JPanel();
		this.saveButton = new JButton("����");
		this.saveButton.setBackground(Color.white);
		this.removeButton = new JButton("����");
		this.removeButton.setBackground(Color.white);
		this.okButton = new JButton("����û");
		this.okButton.setBackground(Color.white);
		this.saveButton.addActionListener(this);
		this.removeButton.addActionListener(this);
		this.okButton.addActionListener(this);
		panel5.add(this.saveButton);
		panel5.add(this.removeButton);
		panel5.add(this.okButton); 
		panel5.setBorder(BorderFactory.createEmptyBorder(40, 20, 20, 20));
		this.arr.add(panel5);
		
		for(JPanel panel:this.arr) {
			this.mainPanel.add(panel);
			panel.setBackground(Color.white);
		}
	}
		
	@Override
	public void actionPerformed(ActionEvent actionEvent) {		
		String name = this.enquirerName.getText();
		String contactNum = this.contactNumber.getText();
		String inquiryDetails = this.contents.getText();
		
		if(actionEvent.getActionCommand().equals("����")) { // �� ����, ��㳻�� ����
			this.cConsultationRequest.saveContents(name, contactNum, inquiryDetails);
			
		} else if(actionEvent.getActionCommand().equals("����")) { // �Է¶��� ��� �������� ����
			this.enquirerName.setText("");
			this.contactNumber.setText("");
			this.contents.setText("");
			
		} else if(actionEvent.getActionCommand().equals("����û")) { // ������ ����� -> ���翡�� ����û
			this.cConsultationRequest.requestConsultation();
						
			// ���̾�α�
			JOptionPane.showMessageDialog(null,
					"�������ּż� �����մϴ�. Ȯ�� �� �Է��Ͻ� ����ó�� �����帮�ڽ��ϴ�.",
					"�ȳ�â",
					JOptionPane.INFORMATION_MESSAGE);	
		}
	}

	@Override
	public void run() {
		while(true){
	        Calendar cal = Calendar.getInstance();
	        String clock = cal.get(Calendar.YEAR) + "/" +
	                    (cal.get(Calendar.MONTH)+1) + "/" +
	                    cal.get(Calendar.DATE) + "  " +
                        cal.get(Calendar.HOUR) + ":" +
	                    cal.get(Calendar.MINUTE) + ":" +
	                    cal.get(Calendar.SECOND);
	        this.now.setText(clock);
	        try{
	        	Thread.sleep(1000);
	        }catch(InterruptedException e){
	        	e.printStackTrace();
	        }
		}
	}

}
