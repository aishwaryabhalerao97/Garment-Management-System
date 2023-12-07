import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;


public class Garment_Management_Sys {

	
		private int custId;
		private String cust_name;
		private Long cust_mob;
		private String cust_meas;
		private int order_id;
		private String order_date;
		private String delivery_date;
		private int No_Of_Items;
		private int Bill_no;
		
		
		Garment_Management_Sys(int custId,String cust_name,Long cust_mob)
		{
		  this.custId=custId;
		  this.cust_name=cust_name;
		  this.cust_mob=cust_mob;
		  this.setCust_meas(cust_meas);
		  this.setOrder_id(order_id);
		  this.setOrder_date(order_date);
		  this.setDelivery_date(delivery_date);
		  this.setNo_Of_Items(No_Of_Items);
		  this.setBill_no(Bill_no);
		
		}		
		
		
		public int getCustId() {
			return custId;
			
		}
        public String getCust_name() {
			return cust_name;
        	
        }
        public Long getCust_mob() {
			return cust_mob;
        	
        }
        
        public String toString() {
			return custId+""+cust_name+""+cust_mob;
        	
        }

		public String getCust_meas() {
			return cust_meas;
		}

		public String getDelivery_date() {
			return delivery_date;
		}

		public void setDelivery_date(String delivery_date) {
			this.delivery_date = delivery_date;
		}

		public int getOrder_id() {
			return order_id;
		}

		public String getOrder_date() {
			return order_date;
		}

		public void setOrder_date(String order_date) {
			this.order_date = order_date;
		}

		public void setOrder_id(int order_id) {
			this.order_id = order_id;
		}

		public void setCust_meas(String cust_meas) {
			this.cust_meas = cust_meas;
		}

		public int getNo_Of_Items() {
			return No_Of_Items;
		}

		public void setNo_Of_Items(int no_Of_Items) {
			No_Of_Items = no_Of_Items;
		}

		public int getBill_no() {
			return Bill_no;
		}

		public void setBill_no(int bill_no) {
			Bill_no = bill_no;
		}
	}
 class CRUDDemo{
	 private static boolean add;
	private static Scanner s;
	private static Scanner s1;

	public static void main(String[] args)throws ClassNotFoundException, SQLException {
		 {
			 
		       try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				
				
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","aishu");	
		       
				Statement st=con.createStatement();
		 
			 
		 
		 List<Garment_Management_Sys>c= new ArrayList<Garment_Management_Sys>();
		 s = new Scanner(System.in);
		 s1 = new Scanner(System.in);
		 int ch = s.nextInt();
		  int cust=s.nextInt(); 
		 
		 do {
			 System.out.println("Welcome to Masters Choice");
			 System.out.println("1.Customer ");
			 System.out.println("2.Customer give your Measurements");
			 System.out.println("3.Orders ");
			 System.out.println("4.Customer Bill ");
			 System.out.println("5.Worker");
			 
			  ch=s.nextInt();
			  
			  System.out.println("1.Enter your Details: ");
				 System.out.println("2.See your Details");
				 System.out.println("3.SEARCH your Details");
				 System.out.println("4.DELETE your Data");
				 System.out.println("5.UPDATE Your Details");
				 System.out.println("ENTER YOUR CHOICE: ");
				 
				 cust=s.nextInt();
				 
				 int InMea=0;
				 System.out.println("1.Enter Your Measurements");
	             System.out.println("2.UPDATE Your Measurements");
				 System.out.println("ENTER YOUR CHOICE: ");
				  
				  InMea=s.nextInt();
				
				  System.out.println("1.INSERT your orders");
		             System.out.println("2.Cancel your orders");
					 System.out.println("ENTER YOUR CHOICE: ");  
				  int orders=s.nextInt();
					

				  System.out.println("1.INSERT your Bill");
		             System.out.println("2.Cancel your orders");
					 System.out.println("ENTER YOUR CHOICE: ");  
				  int bill=s.nextInt();
					
				  
		
			 
			
		switch(ch) {
		case 1:
			System.out.println("FOR CUSTOMERS");
		System.out.println("ENTER YOUR CHOICE: ");
		
		     
		switch(cust) {
		
		      
								case 1:
									
									 String Query="insert into Cust values(?,?,?)";
									 PreparedStatement p1=con.prepareStatement(Query);
									
						
									 System.out.println("Enter CustId: ");
									int custId=s.nextInt();
						            p1.setInt(1,custId);
						            
						            System.out.println("Enter Customer Name: ");
						            String cust_name=s1.nextLine();
									p1.setString(2,cust_name);
									
									System.out.println("Enter Customer mobile no: ");
									Long cust_mob=s1.nextLong();
									p1.setLong(3, cust_mob);
									 
									 int Inserted=p1.executeUpdate();
									 
									
								 c.add(new Garment_Management_Sys(custId, cust_name, cust_mob));
								 
								 System.out.println("You Successfully Inserted your data!"+Inserted);
									
										
								 break;
									
								case 2:
									ResultSet rs=st.executeQuery("select * from Cust");
									while(rs.next())
									{
										System.out.println(rs.getLong(1)+"  "+rs.getString(2)+"  "+rs.getLong(3));
													
									} 
									  System.out.println("-----------------------------------");
									  Iterator<Garment_Management_Sys> i=c.iterator();
									  while(i.hasNext()) {
										  Garment_Management_Sys g=i.next();
										  System.out.println(g);
										  
									  }
									  System.out.println("-----------------------------------");
						              break;
						              default:
						            	  System.out.println("Records not found!");
						              break;
								case 3:
									boolean found=false;
									 System.out.println("Enter Customer_Id to Search");
									
									 String Id="select from Cust where custId=?";
									 PreparedStatement p=con.prepareStatement(Id);
										int custId1 = s.nextInt();
										p.setInt(1,custId1);
										
										 System.out.println("Your Bill! ");
										
										  System.out.println("-----------------------------------");
										  
									 
									
									 
									   i=c.iterator();
									  while(i.hasNext()) {
										  Garment_Management_Sys g=i.next();
										  if(g.getCustId()==custId1) {
											  
										  
										  System.out.println(g);
										  found=true;
										  }
									  }
							
						           if(!found) {
						        	   System.out.println("Record not found");
						        	   
						           }
						           System.out.println("-----------------------------------");
						           
									  break;
									  
								case 4:
									 System.out.println("Delete your data here");
									 String Delete="Delete from Cust where custId>=1";
									 PreparedStatement p2=con.prepareStatement(Delete);
									 
									 System.out.println("Enter Customer_Id to Delete");
									 
									 int Deleted=p2.executeUpdate();
									 System.out.println("You Successfully Deleted your data!"+Deleted);
									 
									 found=false;
									  System.out.println("Enter Customer_Id to Delete");
									 custId1 =s.nextInt();
									  System.out.println("-----------------------------------");
									   i=c.iterator();
									  while(i.hasNext()) {
										  Garment_Management_Sys g=i.next();
										  if(g.getCustId()==custId1) {
											  
										  
									      i.remove();
										  found=true;
										  }
									  }
							
						           if(!found) {
						        	   System.out.println("Record not found");
						        	   
						           }
						           else { System.out.println("Record is deleted Successfully");
						    	   
						        	   
						           }
						           System.out.println("-----------------------------------");
						           
									  break;  
								case 5:
									 found=false;
									 System.out.println("Enter Customer_Id to Update: ");
									 System.out.println("-----------------------------------");
									   
									String Update="Update Cust set cust_name=?,cust_mob=? where custId=? ";
									 PreparedStatement p3=con.prepareStatement(Update);
						
						            int custId11 =s.nextInt();
									p3.setInt(1,custId11);
									
									 System.out.println("Enter new Customer_Name: ");
									   String cust_name11=s1.nextLine();
									  p3.setString(2,cust_name11);
									  
									  System.out.println("Enter new Mobile_No: ");
									 long cust_mob11=s1.nextLong();
									 p3.setLong(3, cust_mob11);
									 
									 int Updated=p3.executeUpdate();
									 System.out.println("You Successfully Updated your data!"+Updated);
									
									
								  ListIterator<Garment_Management_Sys>li =c.listIterator();
									  while(li.hasNext()) {
										  Garment_Management_Sys g=li.next();
										  if(g.getCustId()==custId11) {
											  
											
											 
											 li.set(new Garment_Management_Sys(custId11, cust_name11, cust_mob11)); 
									      
										  found=true;
										  }
									  }
							
						          if(!found) {
						       	   System.out.println("Record not found");
						       	   
						          }
						          else { System.out.println("Record is Updated Successfully");
						   	   
						       	   
						          }
						          System.out.println("-----------------------------------");
						          
									  break;    
								}
		break;
								
		case 2:
									
			
			System.out.println("For Measurements ");
			
			
	
		    switch(InMea) {
				    case 1:
				    	 
							
					 String InsertMea="insert into Cust_Measurements values(?,?)";
					 PreparedStatement p4=con.prepareStatement(InsertMea);
					 
					 System.out.println("Enter your Measurements: ");
					String cust_meas = s1.nextLine();
					p4.setString(1,cust_meas);
					
					System.out.println("Enter your Customer_Id ");
					 int custId = s.nextInt();
					p4.setInt(2,custId);
					
					 
					 int Inserted=p4.executeUpdate();
					 
					 System.out.println("You Successfully Inserted your Measurements!"+Inserted);
					 
					 break;
					 
				    case 2:
				    	 String Update="Update Cust set cust_meas=? where custId=? ";
						 PreparedStatement p5=con.prepareStatement(Update);
		   
						 System.out.println("Enter Customer_Id to Update your Measurements");
					    	
			            int custId11 = s.nextInt();
						p5.setInt(1,custId11);
						
						 System.out.println("Enter New Measurements to Update: ");
					    	
						 String cust_meas1=s1.nextLine();
						  p5.setString(2,cust_meas1);
						
						 int Updated=p5.executeUpdate();
						 System.out.println("You Successfully Updated your Measurements!"+Updated);
						 break;
						
				    }
		    break;
		case 3:
			 System.out.println("Your orders are Here");
	          
			 switch(orders) {
			 
						 case 1:
				  			 System.out.println("Enter your orders Here");
							 
				  			String InOr="insert into Cust_order values(?,?,?,?,?)";
							 PreparedStatement p6=con.prepareStatement(InOr);
							 
							 System.out.println("Enter Order Id: ");
						    	
							int order_id = s.nextInt() ;
							p6.setInt(1,order_id);
							
							 System.out.println("Enter Order Date: ");
							String order_date=s1.nextLine();
							p6.setString(2,order_date);
							
							 System.out.println("Enter Delivery Date : ");
							String delivery_date=s1.nextLine();
							p6.setString(3,delivery_date);
							
							 System.out.println("Enter No of Items to be Stitched: ");
							 int No_Of_Items= s.nextInt() ;
							p6.setInt(4,No_Of_Items);
							
							 System.out.println("Please Give your Customer_Id for Reference: ");
							 int custId = s.nextInt();
							p6.setInt(5,custId);
							
							 
							 int OrInserted=p6.executeUpdate();
							 
							 System.out.println("You Successfully Inserted your Orders!"+OrInserted);
							 break;
						 
						 case 2:	
							 System.out.println("Cancel your orders Here");
							 
							 String DeleteOrder="Delete order_id=? from Cust_order where custId=?";
							 PreparedStatement p7=con.prepareStatement(DeleteOrder);
							 System.out.println("Enter Order Id to Cancel your Order: ");
							int order_id1=s.nextInt();
							 p7.setInt(1,order_id1);
							 
							 System.out.println("Enter Custmer_Id for Cancellation process: ");
							 int cust_id1=s.nextInt();
							 p7.setInt(2,cust_id1);
							 
							 
							 
							 int DeleteOr=p7.executeUpdate();
							 System.out.println("You Successfully Deleted your data!"+DeleteOr);
							 break;
							
						 }
			 break;
			
		case 4:
			 System.out.println("Bill Section: --You can find your bill here--");
			
			switch(bill) {
						case 1:
						
							 System.out.println("Insert Bill Details");
							 String InBill="insert into Cust_Bill values(?,?,?)";
							 PreparedStatement p8=con.prepareStatement(InBill);
							 
							 System.out.println("Enter Bill_Id: ");
							int bill_id = s.nextInt() ;
							p8.setInt(1,bill_id);
							
							 System.out.println("Enter Customer_Id: ");
							int cust_id = s.nextInt();
							p8.setInt(1,cust_id);
							
							 System.out.println("Enter Order Id: ");
							int order_id = s.nextInt();
							p8.setInt(1,order_id);
							
							int BillIn=p8.executeUpdate();
							 
							 System.out.println("You Successfully Inserted your data!"+BillIn);
							 break;
							 
						case 2:
							 System.out.println("Enter Bill_no: ");
							 String DisplayBill="select from Cust_Bill where bill_no=?";
							 PreparedStatement p9=con.prepareStatement(DisplayBill);
								int bill_id1 = s.nextInt() ;
								p9.setInt(1,bill_id1);
								
								 System.out.println("Your Bill! ");
								
								  System.out.println("-----------------------------------");
								  
							
							 break;
						}
			
			break;
		}	
		 }while(ch!=0);
	  

			 con.close();

		       }catch(Exception e) {
				System.out.println("error"+e);
				 
		       }
		 }}

	public static boolean isAdd() {
		return add;
	}

	public static void setAdd(boolean add) {
		CRUDDemo.add = add;
	}}
 
 

		