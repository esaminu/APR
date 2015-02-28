import java.sql.Connection;
import java.sql.DriverManager;

/* An addition has been made to link the driver library to the system,
 * And the connection to the database is made here.
 * 
 * This class runs the server, it has been initiated outside of the mainServer.
 * This is to avoid connectivity issues that may arise as functions clash.
 */
public class RunServer {
	public static void main(String[] args) throws Exception {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (ClassNotFoundException e) {
		    throw new RuntimeException("Cannot find the driver in the classpath!", e);
		}
		Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_database","root","");
		System.out.println("Database connected.");
		mainServer server = new mainServer(myConn);
		server.runServer();
		myConn.close();
	}
}