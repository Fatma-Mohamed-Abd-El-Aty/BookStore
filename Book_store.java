package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JTextArea;

public class Book_store {

	private Connection connect = null;
	  private Statement statement = null;
	  private PreparedStatement preparedStatement = null;
	  private ResultSet resultSet = null;

	  final private String myUrl="jdbc:mysql://localhost/book_store";
	public Book_store() {
		
		 try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      // Setup the connection with the DB
	      try {
			connect = DriverManager
			      .getConnection(myUrl,"root","lba4mohndsa" );
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	// will be modified
	 private void writeResultSet(ResultSet resultSet,JTextArea text) throws SQLException {
		 ResultSetMetaData rsmd = resultSet.getMetaData();
		 int columnsNumber = rsmd.getColumnCount();
		 String temp;
		 for(int i = 1; i<=columnsNumber; i++){
	           if(i> 1) System.out.print("  ");
	           System.out.println(rsmd.getColumnLabel(i));
	           text.append(rsmd.getColumnLabel(i)+"		");
	       }
		 text.append("\n");
		    while (resultSet.next()) {
		    	//System.out.print(columnsNumber);
		    	for(int i=1;i<=columnsNumber;i++) {
		    		temp=resultSet.getString(i);
		    		System.out.print(temp+"		");
		    		text.append(temp+"		");
		    	}
		    	System.out.println();
		    	text.append("\n");
		      
		    }
		  }
	 void confirm_order(int orderId) {
		 try {
				statement = connect.createStatement();
				preparedStatement = connect.prepareStatement("call book_store.confirm_order("+orderId+");\r\n");
				resultSet = preparedStatement.executeQuery("call book_store.confirm_order("+orderId+");\r\n");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	 }
	 
	 void view_total_price(JTextArea text) {
		 try {
				statement = connect.createStatement();
				preparedStatement = connect.prepareStatement("call book_store.view_total_price();\r\n");
				resultSet = preparedStatement.executeQuery("call book_store.view_total_price();\r\n");
				writeResultSet(resultSet,text);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	 }
	 void view_total_sales(JTextArea text) {
		 try {
				statement = connect.createStatement();
				preparedStatement = connect.prepareStatement("call book_store.view_total_sales();\r\n");
				resultSet = preparedStatement.executeQuery("call book_store.view_total_sales();\r\n");
				writeResultSet(resultSet,text);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	 }
	 void view_top_ten_books(JTextArea text) {
		 try {
				statement = connect.createStatement();
				preparedStatement = connect.prepareStatement("call book_store.view_top_ten_books();\r\n");
				resultSet = preparedStatement.executeQuery("call book_store.view_top_ten_books();\r\n");
				writeResultSet(resultSet,text);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	 }
	 void view_top_five_customers(JTextArea text) {
		 try {
				statement = connect.createStatement();
				preparedStatement = connect.prepareStatement("call book_store.view_top_five_customers();\r\n");
				resultSet = preparedStatement.executeQuery("call book_store.view_top_five_customers();\r\n");
				writeResultSet(resultSet,text);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	 }
	 void view_cart(JTextArea text) {
		 try {
				statement = connect.createStatement();
				preparedStatement = connect.prepareStatement("call book_store.view_cart();\r\n");
				resultSet = preparedStatement.executeQuery("call book_store.view_cart();\r\n");
				writeResultSet(resultSet,text);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	 }
	 boolean checkLuhn(String cardNo) 
	 { 
	     int nDigits = cardNo.length(); 
	   
	     int nSum = 0; 
	     boolean isSecond = false; 
	     for (int i = nDigits - 1; i >= 0; i--){
	         int d = cardNo.charAt(i) - '0'; 
	         if (isSecond == true) 
	             d = d * 2;
	         // We add two digits to handle 
	         // cases that make two digits  
	         // after doubling 
	         nSum += d / 10; 
	         nSum += d % 10; 
	   
	         isSecond = !isSecond; 
	     } 
	     return (nSum % 10 == 0); 
	 } 
	 void check_out(String cardNo) {
		 try {
			 if(checkLuhn(cardNo)) {
				statement = connect.createStatement();
				preparedStatement = connect.prepareStatement("call book_store.check_out();\r\n");
				resultSet = preparedStatement.executeQuery("call book_store.check_out();\r\n");
			 }
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	 }
	
	boolean sign_in(String entered_user_name ,String entered_pass_word ) {
		try {
			statement = connect.createStatement();
			preparedStatement = connect.prepareStatement("call book_store.sign_in('"+entered_user_name+"', '"+entered_pass_word+"');\r\n");
			resultSet = preparedStatement.executeQuery("call book_store.sign_in('"+entered_user_name+"', '"+entered_pass_word+"');\r\n");

			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	void search_for_books(String input,JTextArea text) {
		try {
			statement = connect.createStatement();
			preparedStatement = connect.prepareStatement("call book_store.search_for_books('"+input+"');\r\n");
			resultSet = preparedStatement.executeQuery("call book_store.search_for_books('"+input+"');\r\n");
			writeResultSet(resultSet,text);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	void remove_item_from_cart(String entered_ISBN ){
		try {
			statement = connect.createStatement();
			preparedStatement = connect.prepareStatement("call book_store.remove_item_from_cart('"+entered_ISBN+"');\r\n");
			resultSet = preparedStatement.executeQuery("call book_store.remove_item_from_cart('"+entered_ISBN+"');\r\n");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	void promot(String input_username ) {
		try {
			statement = connect.createStatement();
			preparedStatement = connect.prepareStatement("call book_store.promot('"+input_username+"');\r\n");
			resultSet = preparedStatement.executeQuery("call book_store.promot('"+input_username+"');\r\n");


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	void modify_existing_books(String book_ISBN ,int new_quantity) {
		try {
			statement = connect.createStatement();
			preparedStatement = connect.prepareStatement("call book_store.modify_existing_books('"+book_ISBN+"', "+new_quantity+");\r\n");
			resultSet = preparedStatement.executeQuery("call book_store.modify_existing_books('"+book_ISBN+"', "+new_quantity+");\r\n" ); 

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	void log_out() {
		try {
			statement = connect.createStatement();
			preparedStatement = connect.prepareStatement("call book_store.=log_out();\r\n");
			resultSet = preparedStatement.executeQuery("call book_store.log_out();\r\n" );

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	void edit_personal_information (String att_name ,String att_value ) {
		try {
			statement = connect.createStatement();
			preparedStatement = connect.prepareStatement("call book_store.edit_personal_information('"+att_name+"', '"+att_value+"');\r\n");
			resultSet = preparedStatement.executeQuery("call book_store.edit_personal_information('"+att_name+"', '"+att_value+"');\r\n" ); 

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	void add_to_cart( String entered_Book_ISBN ,int entered_quantity ) {
		try {
			statement = connect.createStatement();
			preparedStatement = connect.prepareStatement("call book_store.add_to_cart('"+entered_Book_ISBN+"', "+entered_quantity+");\r\n");
			resultSet = preparedStatement.executeQuery("call book_store.add_to_cart('"+entered_Book_ISBN+"', "+entered_quantity+");\r\n" ); 

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	boolean sign_up(String user_name ,String pass_word ,String last_name,String first_name ,String email ,String phone,String address ) {
		try {
			statement = connect.createStatement();
			preparedStatement = connect.prepareStatement("call book_store.sign_up('"+user_name+"', '"+pass_word+"', '"+last_name+"','"+ first_name+"','"+ email+"','"+ phone+"','"+ address+"');\r\n");
			resultSet = preparedStatement.executeQuery("call book_store.sign_up('"+user_name+"', '"+pass_word+"', '"+last_name+"','"+ first_name+"','"+ email+"','"+ phone+"','"+ address+"');\r\n" ); 
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
	}
	void add_new_books( String ISBN, String  title, String p_year, double price, int threshold, int quantity,  int categ_id, int  pub_id) {
		try {
			statement = connect.createStatement();
			preparedStatement = connect.prepareStatement("call book_store.add_new_book('"+ISBN+"', '"+title+"', '"+p_year+"',"+ price+","+ threshold+","+ quantity+","+ categ_id+","+ pub_id+");\r\n");
			resultSet = preparedStatement.executeQuery("call book_store.add_new_book('"+ISBN+"', '"+title+"', '"+p_year+"',"+ price+","+ threshold+","+ quantity+","+ categ_id+","+ pub_id+");\r\n" ); 

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
