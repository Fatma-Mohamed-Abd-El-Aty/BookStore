package test;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MYSQLAccess dao = new MYSQLAccess();
		Book_store b=new Book_store();
		//b.add_new_books("12349", "saloma", "1997",100, 10, 20, 1,1);
		//b.sign_up("jehan","789", "ali", "jehan", "jgfj,hmn.com","034592199", "borg el-arab");
		//b.add_to_cart("jehan", "12349", 5);
		//b.edit_personal_information("last_name", "shatta", "jehan");
		//b.log_out();
		//b.modify_existing_books("12349", 50);
		//b.promot("jehan", "salma");
		//b.remove_item_from_cart("jehan", "12349");
		//b.search_for_books("saloma");
		//b.sign_in("salma", "123765867");
		//b.check_out();
		//b.view_cart();
		//b.view_top_five_customers();
		//b.view_top_ten_books();
		//b.view_total_sales();
		
	    try {
			//dao.readDataBase();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
