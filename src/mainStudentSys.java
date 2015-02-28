/*
 * This will run the mainframe as many times as the user wants as it is the main class for the client and it automatically initiates a connection to the server.
 * This class initiates a client, the server will handle the multiple threads and will take care of the concurrency issues.
 */
import java.awt.EventQueue;
/**
 * Launch the application.
 */
/*
 * The Main Class
 */
public class mainStudentSys {
	public static void main(String[] args) {
		//This will ensure that multiple clients can make connections to the server.
		final clientConnection connection = new clientConnection();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				/**
				 * Creates the frame.
				 */
				try {
					//Creates the main frame from the GUI class
					System.out.println("tie!");
					mainFrame frame = new mainFrame(connection);
					System.out.println("here12");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		//Calling the connection to initialize the socket connection per client.
		System.out.println("here!");
		connection.intSocket();
		}
}