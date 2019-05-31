package util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
 
 
public class DbHelper {
	/**
	 * GET DB Connection
	 * @return 
	 */
	public static Connection getConnection(){
		Connection conn=null;
		try {
			JdbcConfig jdbcConfig = XmlConfigReader.getInstance().getJdbcConfig();
			//get oracle drive name
			
			
			Class.forName(jdbcConfig.getDriverName());
			// String url = "jdbc:oracle:thin:@MyDbComputerNameOrIP:1521:ORCL";
			// connect to db, thin:@MyDbComputerNameOrIP database ip address£»
			//1521 port number£»ORCL db name
			conn = DriverManager.getConnection(jdbcConfig.getUrl(), jdbcConfig.getUserName(), jdbcConfig.getPassword());
			if(conn!=null){
				System.out.println("Database has been connected£¡");
			}
			else
			{
				System.out.println("Database connection failed!");
			}			
						
		}  catch (SQLException|ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("Database connection failed!");
		}
		return conn;
		
	}
	
	
//	public static void main(String[] args) {
//		
//		try
//		{
//		   Connection conn = getConnection();
//		   if(conn!=null)
//		   {
//			   System.out.println("Database has been connected£¡");
//		   }
//		   else
//		   {
//			   System.out.println("Database connection failed!");
//		   }
//		}
//		catch(Exception ex)
//		{
//			ex.printStackTrace();
//		}
//		
//	}
}
	

