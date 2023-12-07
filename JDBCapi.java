import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;


public class JDBCapi {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		 Scanner s= new Scanner(System.in);
		 int ch = 0;
		System.out.println("Welcome to Masters Choice");
		 System.out.println("1.Customer ");
		 System.out.println("2.Customer give your Measurements");
		 System.out.println("3.Orders ");
		 System.out.println("4.Customer Bill ");
		 System.out.println("5.Worker");
		 
		 System.out.println("ENTER YOUR CHOICE: ");
		 ch=s.nextInt();
		 
		 
		 
       try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","aishu");	
       
		Statement st=con.createStatement();
 
		switch(ch) {
		case 1:
			System.out.println("FOR CUSTOMERS");
			
			
			System.out.println("Do you want to Update Your Data");
			 Scanner s1= new Scanner(System.in);
			 System.out.println("1.INSERT");
			 System.out.println("2.DELETE");
			 System.out.println("3.UPDATE");
			 System.out.println("4.DISPLAY");
			 
			 int cust=s1.nextInt();
			 
			 switch(cust){
			 case 1:
				 System.out.println("INSERT your data here");
				 int custId1 = 1 ;
					String cust_name = null;
					 Long cust_mob1=1L;
				 String Query="insert into Cust values(?,?,?)";
				 PreparedStatement p1=con.prepareStatement(Query);
				
                 p1.setInt(1,custId1);
				 
				  p1.setString(2,cust_name);
				 
				 p1.setLong(3, cust_mob1);
				 
				 int Inserted=p1.executeUpdate();
				 
				 System.out.println("You Successfully Inserted your data!"+Inserted);
				 break;
				 
			 case 2:
				 System.out.println("Delete your data here");
				 String Delete="Delete from Cust where custId>=1";
				 PreparedStatement p2=con.prepareStatement(Delete);
				 
				 System.out.println("Enter Customer_Id to Delete");
				 
				 int Deleted=p2.executeUpdate();
				 System.out.println("You Successfully Deleted your data!"+Deleted);
				 break;
				 
				 
			 case 3:
				 System.out.println("Update your data here");
				 String Update="Update Cust set cust_name=?,cust_mob=? where custId=? ";
				 PreparedStatement p3=con.prepareStatement(Update);

                 int custId = 1;
				p3.setInt(1,custId);
				 String cust_name1=null;
				  p3.setString(2,cust_name1);
				 long cust_mob11=1;
				 p3.setLong(3, cust_mob11);
				 
				 int Updated=p3.executeUpdate();
				 System.out.println("You Successfully Updated your data!"+Updated);
				 break;
			
			 case 4:
				 ResultSet rs=st.executeQuery("select * from Cust");
					while(rs.next())
					{
						System.out.println(rs.getLong(1)+"  "+rs.getString(2)+"  "+rs.getLong(3));
									
					} 
			 }
     
			break;
			

          
	
	} con.close();

       }catch(Exception e) {
		System.out.println("error"+e);
		 
	}

	}
}

