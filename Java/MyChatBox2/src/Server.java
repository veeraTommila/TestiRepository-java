import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.net.InetAddress;
import java.net.SocketException;

import javax.swing.JTextArea;

// A server for chatting.
public class Server extends JFrame {

	private JPanel contentPane;

	//-------------------------------------------------------- To UDP.
	private DatagramSocket datagramSocket;
	private byte [] buffer = new byte[256];
	
	public Server(DatagramSocket datagramSocket) {
		this.datagramSocket = datagramSocket;
	}
	
	public void receiveThenSend() {
		while (true) {
			try {
				DatagramPacket datagramPacket = new DatagramPacket(buffer, buffer.length);
				datagramSocket.receive(datagramPacket);
				InetAddress inetAddress = datagramPacket.getAddress();	//Inet equals to IP.
				int port = datagramPacket.getPort();
				String clientMessage = new String(datagramPacket.getData(), 0, datagramPacket.getLength());
				System.out.println("Message from a client: "+clientMessage);				
				datagramPacket = new DatagramPacket(buffer, buffer.length, inetAddress, port);
				datagramSocket.send(datagramPacket);
			}catch(IOException e) {
				e.printStackTrace();
				break;
			}
		}
	}
	//--------------------------------------------------------
	
	public static void main(String[] args) throws SocketException {
		//-------------------------------------------------------- To UDP.
		DatagramSocket datagramSocket = new DatagramSocket(1234);
		Server server = new Server(datagramSocket);
		server.receiveThenSend();
		//--------------------------------------------------------
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Server frame = new Server();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Server() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel Serverlabel = new JLabel("Server");
		Serverlabel.setBounds(10, 11, 125, 14);
		contentPane.add(Serverlabel);
		
		JTextArea display3 = new JTextArea();
		display3.setBounds(10, 36, 414, 214);
		contentPane.add(display3);
	}
	
	public static void getText() {
		String s = Window_1.text1.getText();	// This makes a string to get a text from the text writing field of Window_1.
		if(s.equals("")) {	// If the text of string s equals to nothing. It returns; the program does nothing.
			return;
		}
		display3.append("Message from:" + Window_1.username1 + ":" + s + "\n");	// If string s is not empty. This part will be done. The text written by Window_1 will be added to the main text area of the Window_1 like this: Peter: Hello everyone!
		display3.append("Message from:" + Window_2.username2 + ":" + s + "\n");	// If string s is not empty. This part will be done. The text written by Window_1 will be added to the main text area of the Window_1 like this: Peter: Hello everyone!
	}
	
	private javax.swing.JLabel label2;
	private static javax.swing.JTextArea display3;
	//private javax.swing.JButton send2;
	//public static javax.swing.JTextArea text2;
}
