package test;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Op_user {

	public JFrame op_user;
	private JTextField txtEnterWordRelated;
	private JTextField textField;
	public static Book_store book_store=new Book_store();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Op_user window = new Op_user(book_store);
					window.op_user.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Op_user(Book_store bookStore) {
		book_store=bookStore;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		op_user = new JFrame();
		op_user.setResizable(false);
		op_user.setTitle("Operations for users");
		op_user.setBounds(100, 100, 589, 261);
		op_user.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		op_user.getContentPane().setLayout(null);
		
		
		JButton btnLogOut = new JButton("Log out");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				book_store.log_out();
			}
		});
		btnLogOut.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnLogOut.setBounds(482, 184, 83, 27);
		op_user.getContentPane().add(btnLogOut);
		
		JButton btnViewMyCart = new JButton("View my cart");
		btnViewMyCart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cart cart=new Cart(book_store);
				cart.cart.setVisible(true);
				book_store.view_cart(cart.textArea);
			}
		});
		btnViewMyCart.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnViewMyCart.setBounds(10, 184, 234, 27);
		op_user.getContentPane().add(btnViewMyCart);
		
		txtEnterWordRelated = new JTextField();
		txtEnterWordRelated.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtEnterWordRelated.setBounds(10, 12, 462, 27);
		op_user.getContentPane().add(txtEnterWordRelated);
		txtEnterWordRelated.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Search manager_frame =new Search();
		        manager_frame.search.setVisible(true);
		        book_store.search_for_books(txtEnterWordRelated.getText(),manager_frame.textArea);
			}
		});
		btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSearch.setBounds(482, 12, 90, 27);
		op_user.getContentPane().add(btnSearch);
		JLabel lblEditPersonalInformation = new JLabel("Edit personal information :");
		lblEditPersonalInformation.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEditPersonalInformation.setBounds(10, 85, 287, 27);
		op_user.getContentPane().add(lblEditPersonalInformation);
		
		final JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"User name", "Password", "First name", "Last name", "E-mail", "Address", "Phone"}));
		comboBox.setBounds(20, 120, 114, 27);
		op_user.getContentPane().add(comboBox);
		
		textField = new JTextField();
		textField.setBounds(144, 120, 234, 27);
		op_user.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Edit \r\n");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				book_store.edit_personal_information((String)comboBox.getSelectedItem(),textField.getText());

			}
		});
		btnNewButton.setBounds(405, 120, 90, 27);
		op_user.getContentPane().add(btnNewButton);
	}
}