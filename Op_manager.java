package test;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Op_manager {

	public JFrame op_manager;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	public static Book_store book_store=new Book_store();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Op_manager window = new Op_manager(book_store);
					window.op_manager.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Op_manager(Book_store bookStore) {
		book_store=bookStore;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		op_manager = new JFrame();
		op_manager.setResizable(false);
		op_manager.setTitle("Operations for manager");
		op_manager.setBounds(100, 100, 617, 725);
		op_manager.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		op_manager.getContentPane().setLayout(null);
		
		JButton button_5 = new JButton("Log out");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				book_store.log_out();
			}
		});
		button_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		button_5.setBounds(501, 654, 94, 27);
		op_manager.getContentPane().add(button_5);
		
		
		JButton btnReport = new JButton("Report1");
		btnReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				report1 r=new report1();
				r.frmReport.setVisible(true);
				book_store.view_total_sales(r.textArea);
			}
		});
		btnReport.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnReport.setBounds(150, 654, 94, 27);
		op_manager.getContentPane().add(btnReport);
		
		JButton btnReport_1 = new JButton("Report2");
		btnReport_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				report1 r=new report1();
				r.frmReport.setVisible(true);
				book_store.view_top_five_customers(r.textArea);			}
		});
		btnReport_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnReport_1.setBounds(254, 654, 94, 27);
		op_manager.getContentPane().add(btnReport_1);
		
		JButton btnReport_2 = new JButton("Report3");
		btnReport_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				report1 r=new report1();
				r.frmReport.setVisible(true);
				book_store.view_top_ten_books(r.textArea);
			}
		});
		btnReport_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnReport_2.setBounds(358, 654, 94, 27);
		op_manager.getContentPane().add(btnReport_2);
		
		
		JLabel lblOrder = new JLabel("Order :");
		lblOrder.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblOrder.setBounds(10, 316, 82, 13);
		op_manager.getContentPane().add(lblOrder);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField.setColumns(10);
		textField.setBounds(10, 10, 462, 27);
		op_manager.getContentPane().add(textField);
		
		JButton button_3 = new JButton("Search");
		button_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		button_3.setBounds(486, 10, 90, 27);
		button_3.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				Search manager_frame =new Search();
		        manager_frame.search.setVisible(true);
		        book_store.search_for_books(textField.getText(),manager_frame.textArea);
			}
			
		});
		op_manager.getContentPane().add(button_3);
		
		JLabel label = new JLabel("Edit personal information :");
		label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label.setBounds(10, 66, 287, 27);
		op_manager.getContentPane().add(label);
		
		final JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"User name", "Password", "First name", "Last name", "E-mail", "Address", "Phone"}));
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox.setBounds(20, 103, 114, 27);
		op_manager.getContentPane().add(comboBox);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(144, 103, 234, 27);
		op_manager.getContentPane().add(textField_1);
		
		JButton button_4 = new JButton("Edit \r\n");
		button_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		button_4.setBounds(405, 103, 90, 27);
		button_4.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				book_store.edit_personal_information((String)comboBox.getSelectedItem(),textField_1.getText());
			}
			
		});
		op_manager.getContentPane().add(button_4);
		
		JButton button_6 = new JButton("View my cart");
		button_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		button_6.setBounds(10, 654, 124, 27);
		op_manager.getContentPane().add(button_6);
		button_6.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				Cart cart=new Cart(book_store);
				cart.cart.setVisible(true);
				book_store.view_cart(cart.textArea);
				
			}
			
		});
		
		JLabel lblAddNewBook = new JLabel("Add new book :");
		lblAddNewBook.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAddNewBook.setBounds(10, 166, 287, 27);
		op_manager.getContentPane().add(lblAddNewBook);
		
		JLabel lblIsbn = new JLabel("ISBN");
		lblIsbn.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblIsbn.setBounds(10, 203, 45, 13);
		op_manager.getContentPane().add(lblIsbn);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Dialog", Font.PLAIN, 12));
		textField_2.setBounds(48, 203, 96, 19);
		op_manager.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblTitle = new JLabel("Title");
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTitle.setBounds(10, 226, 45, 13);
		op_manager.getContentPane().add(lblTitle);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Dialog", Font.PLAIN, 12));
		textField_3.setColumns(10);
		textField_3.setBounds(48, 226, 96, 19);
		op_manager.getContentPane().add(textField_3);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPrice.setBounds(10, 249, 45, 13);
		op_manager.getContentPane().add(lblPrice);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Dialog", Font.PLAIN, 12));
		textField_4.setColumns(10);
		textField_4.setBounds(48, 249, 96, 19);
		op_manager.getContentPane().add(textField_4);
		
		JLabel lblPyear = new JLabel("Pyear");
		lblPyear.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPyear.setBounds(154, 203, 45, 13);
		op_manager.getContentPane().add(lblPyear);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Dialog", Font.PLAIN, 12));
		textField_5.setColumns(10);
		textField_5.setBounds(211, 203, 96, 19);
		op_manager.getContentPane().add(textField_5);
		
		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblQuantity.setBounds(154, 226, 64, 13);
		op_manager.getContentPane().add(lblQuantity);
		
		textField_6 = new JTextField();
		textField_6.setFont(new Font("Dialog", Font.PLAIN, 12));
		textField_6.setColumns(10);
		textField_6.setBounds(212, 226, 96, 19);
		op_manager.getContentPane().add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setFont(new Font("Dialog", Font.PLAIN, 12));
		textField_7.setColumns(10);
		textField_7.setBounds(212, 249, 96, 19);
		op_manager.getContentPane().add(textField_7);
		
		JLabel lblThreshold = new JLabel("Threshold");
		lblThreshold.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblThreshold.setBounds(154, 249, 64, 13);
		op_manager.getContentPane().add(lblThreshold);
		
		textField_8 = new JTextField();
		textField_8.setFont(new Font("Dialog", Font.PLAIN, 12));
		textField_8.setColumns(10);
		textField_8.setBounds(399, 203, 96, 19);
		op_manager.getContentPane().add(textField_8);
		
		JLabel lblPublisherid = new JLabel("Publisher_id");
		lblPublisherid.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPublisherid.setBounds(317, 203, 64, 13);
		op_manager.getContentPane().add(lblPublisherid);
		
		textField_9 = new JTextField();
		textField_9.setFont(new Font("Dialog", Font.PLAIN, 12));
		textField_9.setColumns(10);
		textField_9.setBounds(400, 232, 96, 19);
		op_manager.getContentPane().add(textField_9);
		
		JButton btnAddNewBook = new JButton("Add");
		btnAddNewBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				book_store.add_new_books(textField_2.getText(),textField_3.getText(), textField_5.getText(), Double.parseDouble(textField_4.getText()), Integer.parseInt(textField_6.getText()), Integer.parseInt(textField_7.getText()), Integer.parseInt(textField_8.getText()), Integer.parseInt(textField_9.getText()));
			}
		});
		btnAddNewBook.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAddNewBook.setBounds(505, 203, 90, 27);
		op_manager.getContentPane().add(btnAddNewBook);
		
		JLabel lblCategoryid = new JLabel("Category_id");
		lblCategoryid.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCategoryid.setBounds(318, 232, 64, 13);
		op_manager.getContentPane().add(lblCategoryid);
		
		textField_10 = new JTextField();
		textField_10.setFont(new Font("Dialog", Font.PLAIN, 12));
		textField_10.setBounds(65, 352, 96, 19);
		op_manager.getContentPane().add(textField_10);
		textField_10.setColumns(10);

		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				book_store.confirm_order(Integer.parseInt(textField_10.getText()));
			}
		});
		btnConfirm.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnConfirm.setBounds(171, 352, 75, 19);
		op_manager.getContentPane().add(btnConfirm);
		
		JLabel lblOrderid = new JLabel("Order_id");
		lblOrderid.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblOrderid.setBounds(10, 354, 59, 13);
		op_manager.getContentPane().add(lblOrderid);
		
		JLabel lblPromoteAUser = new JLabel("Promote a user :");
		lblPromoteAUser.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPromoteAUser.setBounds(10, 419, 124, 13);
		op_manager.getContentPane().add(lblPromoteAUser);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblUsername.setBounds(10, 452, 59, 13);
		op_manager.getContentPane().add(lblUsername);
		
		textField_11 = new JTextField();
		textField_11.setFont(new Font("Dialog", Font.PLAIN, 12));
		textField_11.setBounds(79, 452, 96, 19);
		op_manager.getContentPane().add(textField_11);
		textField_11.setColumns(10);
		JButton btnPromoteAUser = new JButton("Promote");
		btnPromoteAUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				book_store.promot(textField_11.getText());
			}
		});
		btnPromoteAUser.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnPromoteAUser.setBounds(212, 452, 95, 19);
		op_manager.getContentPane().add(btnPromoteAUser);
		
		JLabel label_1 = new JLabel("ISBN");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_1.setBounds(10, 576, 45, 13);
		op_manager.getContentPane().add(label_1);
		
		textField_12 = new JTextField();
		textField_12.setFont(new Font("Dialog", Font.PLAIN, 12));
		textField_12.setColumns(10);
		textField_12.setBounds(48, 576, 96, 19);
		op_manager.getContentPane().add(textField_12);
		
		JLabel label_2 = new JLabel("Quantity");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_2.setBounds(154, 576, 64, 13);
		op_manager.getContentPane().add(label_2);
		
		textField_13 = new JTextField();
		textField_13.setFont(new Font("Dialog", Font.PLAIN, 12));
		textField_13.setColumns(10);
		textField_13.setBounds(212, 576, 96, 19);
		op_manager.getContentPane().add(textField_13);
		
		JButton btnModifyABook = new JButton("Modify");
		btnModifyABook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				book_store.modify_existing_books(textField_12.getText(), Integer.parseInt(textField_13.getText()));
			}
		});
		btnModifyABook.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnModifyABook.setBounds(334, 576, 94, 19);
		op_manager.getContentPane().add(btnModifyABook);
		JLabel lblModifyABook = new JLabel("Modify a book :");
		lblModifyABook.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblModifyABook.setBounds(10, 540, 124, 13);
		op_manager.getContentPane().add(lblModifyABook);
	}

}