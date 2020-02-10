package test;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Cart {

	public JFrame cart;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	JTextArea textArea = new JTextArea();
	public static Book_store book_store=new Book_store();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cart window = new Cart(book_store);
					window.cart.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Cart(Book_store bookStore) {
		book_store=bookStore;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		cart = new JFrame();
		cart.setTitle("My cart");
		cart.setBounds(100, 100, 450, 717);
		cart.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		cart.getContentPane().setLayout(null);
		
		JLabel lblItems = new JLabel("Items :");
		lblItems.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblItems.setBounds(10, 10, 71, 19);
		cart.getContentPane().add(lblItems);
		
		JLabel lblTotalPrice = new JLabel("Total price :");
		lblTotalPrice.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTotalPrice.setBounds(10, 320, 91, 19);
		cart.getContentPane().add(lblTotalPrice);
		
		JLabel lblRemoveAnItem = new JLabel("Remove an item :");
		lblRemoveAnItem.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblRemoveAnItem.setBounds(10, 467, 119, 19);
		cart.getContentPane().add(lblRemoveAnItem);
		
		
		textArea.setEditable(false);
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 13));
		textArea.setBounds(57, 32, 369, 278);
		cart.getContentPane().add(textArea);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField.setEditable(false);
		textField.setBounds(177, 322, 96, 19);
		cart.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel label = new JLabel("ISBN");
		label.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label.setBounds(20, 496, 45, 13);
		cart.getContentPane().add(label);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Dialog", Font.PLAIN, 12));
		textField_1.setColumns(10);
		textField_1.setBounds(58, 496, 96, 19);
		cart.getContentPane().add(textField_1);
		
		JButton btnNewButton = new JButton("Remove");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(177, 496, 103, 19);
		cart.getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				book_store.remove_item_from_cart(textField_1.getText());
			}
			
		});
		
		JLabel lblAddAnItem = new JLabel("Add an item :");
		lblAddAnItem.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAddAnItem.setBounds(10, 374, 119, 19);
		cart.getContentPane().add(lblAddAnItem);
		
		JLabel label_2 = new JLabel("ISBN");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_2.setBounds(20, 403, 45, 13);
		cart.getContentPane().add(label_2);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Dialog", Font.PLAIN, 12));
		textField_2.setColumns(10);
		textField_2.setBounds(58, 403, 96, 19);
		cart.getContentPane().add(textField_2);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAdd.setBounds(331, 403, 64, 19);
		cart.getContentPane().add(btnAdd);
		btnAdd.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				book_store.add_to_cart(textField_2.getText(), Integer.parseInt(textField_3.getText()));
			}
			
		});
		JLabel label_1 = new JLabel("Quantity");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_1.setBounds(164, 403, 64, 13);
		cart.getContentPane().add(label_1);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Dialog", Font.PLAIN, 12));
		textField_3.setColumns(10);
		textField_3.setBounds(222, 403, 96, 19);
		cart.getContentPane().add(textField_3);
		
		
		JLabel lblCheckOut = new JLabel("Check out :");
		lblCheckOut.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCheckOut.setBounds(10, 562, 119, 19);
		cart.getContentPane().add(lblCheckOut);
		
		JLabel lblCredit = new JLabel("Credit");
		lblCredit.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCredit.setBounds(20, 591, 45, 13);
		cart.getContentPane().add(lblCredit);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Dialog", Font.PLAIN, 12));
		textField_4.setColumns(10);
		textField_4.setBounds(58, 591, 96, 19);
		cart.getContentPane().add(textField_4);
		
		JButton btnBuy = new JButton("Buy");
		btnBuy.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnBuy.setBounds(177, 591, 57, 19);
		cart.getContentPane().add(btnBuy);
		btnBuy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				book_store.check_out(textField_4.getText());
				
			}
			
		});
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1.setBounds(10, 656, 71, 21);
		cart.getContentPane().add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener () {

			public void actionPerformed(ActionEvent e) {
				cart.dispose();
				
			}
			
		});
		
	}
}