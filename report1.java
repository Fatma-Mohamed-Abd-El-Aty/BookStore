package test;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class report1 {

	public JFrame frmReport;
	JTextArea textArea = new JTextArea();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					report1 window = new report1();
					window.frmReport.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public report1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmReport = new JFrame();
		frmReport.setTitle("Report1");
		frmReport.setBounds(100, 100, 584, 728);
		frmReport.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmReport.getContentPane().setLayout(null);
		
		
		textArea.setFont(new Font("Courier New", Font.PLAIN, 13));
		textArea.setBounds(10, 10, 550, 626);
		frmReport.getContentPane().add(textArea);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmReport.dispose();
			}
		});
		btnExit.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnExit.setBounds(239, 660, 85, 21);
		frmReport.getContentPane().add(btnExit);
	}
}
