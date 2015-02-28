/*
 * This class handles the concurrency of every client that connects to the server.
 * When a client connects to the server with he port given, the user will be handled by a separate thread.
 * This will ensure that all clients can carry out actions and all actions will be handled by the servers under different clients.
 */
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
public class mainServer {
	private boolean condition = true;
	private ExecutorService executor;
	private ServerSocket server;
	private int socket = 6003;
	private Connection dataBaseConnection;
	private mainController controller;
    /**
     * Runs the server.
     */
	//This will make sure clients can concurrently connect to the server, and every client will be handled by a thread.
		public mainServer(Connection dataBaseConnection){
			//The database connection is exchanged to be able to have multi-threading with multiple users.
			this.dataBaseConnection = dataBaseConnection;
			controller = new mainController(this.dataBaseConnection);
			executor = Executors.newCachedThreadPool();
		}
		//This function will run the server
		public void runServer() {
			//mainController main = new mainController(s);
			try {
				server = new ServerSocket(socket);
				controller.createUpdatedTable();
				System.out.println("Server started");
				try{
					System.out.println("Waiting for client to connect.");
					System.out.println(" ");
					//The condition has to remain true to ensure that the server will keep accepting new incoming connections.
					//The server could be turned off by changing the condition to false
					while(condition){
						//This will handle the threading of each client as it accepts clients.
						mainThreading thread = new mainThreading(server.accept(), controller);
						//This initiates the thread of every client
						executor.execute(thread);
						System.out.println("Client connected");
						System.out.println(" ");
					}
				}
				catch(IOException a){
					System.out.println(a);
				}
				finally{
					server.close();
				}
			} catch(IOException a){
				System.out.println(a);
			}
		}
}