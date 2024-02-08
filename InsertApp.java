package in.ineuron.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertApp {

	public static void main(String[] args) {
		// Resources is used
		Connection connection = null;
		Statement statement = null;

		// Step 1 Autoloading of DriverClassName

		try {
			// Step 2 Established the connection
			String url = "jdbc:mysql://localhost:3306/ineuron";
			String user = "root";
			String password = "BhuseAmit@123";
			connection = DriverManager.getConnection(url, user, password);
			System.out.println("CONNECTION ESTABLISHED SUCCESSFULLY...");

			// Step 3 Create Statement Object and Write the query
			statement = connection.createStatement();
			System.out.println("STATEMENT OBJECT CREATED SUCCESSFULLY...");

			// Step 4 Process the resultSet and execute the query
			String sqlInsertQuery = "INSERT INTO STUDENT(`SNAME`,`SAGE`,`SADDRESS`) VALUES('Rinku',25,'KKR')";
			int rowCount = statement.executeUpdate(sqlInsertQuery);
			System.out.println("NO OF ROWAFFECTED :: " + rowCount);

			// Step 5 Handle the Exception if occur
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Step 6 Close the resource is use
			if (connection != null) {
				try {
					connection.close();
					System.out.println("CLOSING THE RESOURCES");
				} catch (SQLException e) {
					e.printStackTrace();
				}

			}

		}

	}

}
