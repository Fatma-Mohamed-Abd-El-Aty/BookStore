package test;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class MYSQLAccess {
	
  private Connection connect = null;
  private Statement statement = null;
  private PreparedStatement preparedStatement = null;
  private ResultSet resultSet = null;

  final private String myUrl="jdbc:mysql://localhost/book_store";
  public void readDataBase() throws Exception {
    try {
      // This will load the MySQL driver, each DB has its own driver
     

      
      // Statements allow to issue SQL queries to the database
      statement = connect.createStatement();
      preparedStatement = connect.prepareStatement("call book_store.view.cart('salma');");
      resultSet = preparedStatement.executeQuery("call book_store.view_cart('salma');");
      writeResultSet(resultSet);

    } catch (Exception e) {
      throw e;
    } finally {
      //close();
    }

  }

  private void writeMetaData(ResultSet resultSet) throws SQLException {
    //   Now get some metadata from the database
    // Result set get the result of the SQL query
    
    System.out.println("The columns in the table are: ");
    
    System.out.println("Table: " + resultSet.getMetaData().getTableName(1));
    for  (int i = 1; i<= resultSet.getMetaData().getColumnCount(); i++){
      System.out.println("Column " +i  + " "+ resultSet.getMetaData().getColumnName(i));
    }
  }

  private void writeResultSet(ResultSet resultSet) throws SQLException {
    // ResultSet is initially before the first data set
    while (resultSet.next()) {
      // It is possible to get the columns via name
      // also possible to get the columns via the column number
      // which starts at 1
      // e.g. resultSet.getSTring(2);
      String user = resultSet.getString(1);
      String website = resultSet.getString(2);
      String summary = resultSet.getString(3);

      System.out.println("title: " + user);
      System.out.println("ISBN: " + website);
      System.out.println("price: " + summary);
    }
  }

  // You need to close the resultSet
  private void close() {
    try {
      if (resultSet != null) {
        resultSet.close();
      }

      if (statement != null) {
        statement.close();
      }

      if (connect != null) {
        connect.close();
      }
    } catch (Exception e) {

    }
  }

}

