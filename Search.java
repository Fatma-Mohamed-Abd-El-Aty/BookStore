package test;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Search {

	public JFrame search;
	static Search window;
	public JTextArea textArea = new JTextArea();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window = new Search();
					window.search.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Search() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		search = new JFrame();
		search.setTitle("Search");
		search.setBounds(100, 100, 773, 494);
		search.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		search.getContentPane().setLayout(null);
		
		textArea.setEditable(false);
		textArea.setBounds(10, 10, 739, 361);
		search.getContentPane().add(textArea);
		
		JButton btnNext = new JButton("Following");
		btnNext.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNext.setBounds(393, 381, 95, 21);
		search.getContentPane().add(btnNext);
		
		JButton btnPrevious = new JButton("Previous");
		btnPrevious.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnPrevious.setBounds(283, 381, 95, 21);
		search.getContentPane().add(btnPrevious);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				search.dispose();
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnBack.setBounds(10, 426, 95, 21);
		search.getContentPane().add(btnBack);
	}

}