import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestApp{
	public static void main(String[] args) {

				Connection connection =null;
				Statement statement = null;
				ResultSet resultSet = null;
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					System.out.println("Driver loaded successfully.....");
								
					System.out.println();
					
					//Step2. Establish the Connection
					String url = "jdbc:mysql://localhost:3306/ineuron";
					String user = "root";
					String password = "BhuseAmit@123";
					connection = DriverManager.getConnection(url,user,password);
					System.out.println("Cnnection is Established.....");
					System.out.println("The implementation class name is :: "+ connection.getClass().getName());
					
					System.out.println();
				  
					//Step3. Create Statement Object and Send the Query
					 statement = connection.createStatement();
					System.out.println("Statement object is created.....");
					System.out.println("The implementation class name is :: "+statement.getClass().getName());
				
					System.out.println();
				
					//Step4. Execute the Query and process the resultSet
					String sqlSelectQuery="select id,name,age,address from cricketplayersdetails";
					 resultSet=statement.executeQuery(sqlSelectQuery);
					System.out.println("ResultSet  object is created.....");
					System.out.println("The implementation class name is :: "+ resultSet.getClass().getName());
				
					System.out.println();
				
					System.out.println("ID\tNAME\tAGE\tADDRESS");
					while(resultSet.next()) {
					
					int id = resultSet.getInt("id");
					String name = resultSet.getNString("name");
					int age = resultSet.getInt("age");
					String address = resultSet.getNString("address");
					System.out.println(id+"\t"+name+"\t"+age+"\t"+ address);
					}
				
				}catch(ClassNotFoundException e){
					e.printStackTrace();
				}catch(SQLException e){
					e.printStackTrace();
				}catch(Exception e){
					e.printStackTrace();
				}finally {
					if (connection!=null) {
		                try{
		                	connection.close();
		                	System.out.println("Closing the Resources...");
		                }
		                catch (SQLException se){
		                    se.printStackTrace();
		                }
		           }
				}
	}
}
		




