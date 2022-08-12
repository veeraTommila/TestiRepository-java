
public class ChatRoom {
	// Some stuff to get the application run simultaneously.
	static Window_1 wind1;
	static Window_2 wind2;
	static Server server;
	
	// A construction method of an object named ChatRoom. The code inside it runs when the project starts and the transform object will be made.
	public ChatRoom() {
		server = new Server();	// A server object that is relative to null.
		server.setLocationRelativeTo(null);
		server.setVisible(true);	// To set the visibility of the server to true.
		
	}
	
	public static void createRoom() {
		wind1 = new Window_1();
		wind2 = new Window_2();
		wind1.setLocation(100, 200);
		wind2.setLocation(1000, 200);
		wind1.setVisible(true);
		wind2.setVisible(true);
		server.setVisible(false);
	}
	
	public static void main(String[] args) {
		ChatRoom chatRoom = new ChatRoom();
	}

}
