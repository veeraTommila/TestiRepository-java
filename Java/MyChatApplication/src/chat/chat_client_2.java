package chat;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Rectangle;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import net.miginfocom.swing.MigLayout;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.awt.event.ActionEvent;

public class chat_client_2 extends JFrame {

	//-------------------------------------------------
	static Socket s;
	static DataInputStream dis;
	static DataOutputStream dout;
	//-------------------------------------------------
	private JPanel contentPane;

	//These were not original.
	JFrame frame;
	static JTextField msg_text;
	static JTextArea msg_Area;
	private JLabel lblNewLabel;
	/**
	 * Launch the application.
	 */
	
	public chat_client_2() {
		initComponent();
		//-------------------------------------------------
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		//--------------------------------------------------
	}
	
	public void initComponent() {
		frame = new JFrame("Chat client");
		frame.setSize(400, 400);
		frame.getContentPane().setLayout(new MigLayout("", "[3px][295px][86px]", "[][][338px][][23px]"));
		
		lblNewLabel = new JLabel("Client");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		frame.getContentPane().add(lblNewLabel, "cell 1 1");
		
		JTextArea msg_Area = new JTextArea();
		msg_Area.setBounds(new Rectangle(0, 0, 20, 400));
		msg_Area.setBorder(new LineBorder(new Color(0, 0, 0)));
		msg_Area.setBounds(0, 0, 200, 300);
		//frame.getContentPane().add(msg_Area, 300,400);
		frame.getContentPane().add(msg_Area, "cell 1 2 2 1,grow");
		
		msg_text = new JTextField();
		msg_text.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		//frame.getContentPane().add(message_text, BorderLayout.WEST);
		frame.getContentPane().add(msg_text, "cell 1 4,grow");
		msg_text.setColumns(10);
		
		JButton msg_send = new JButton("Send");
		msg_send.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				
				//To send a message to a client.
				try {
					String msg = "";
					msg = msg_text.getText();
					dout.writeUTF(msg);
					msg_text.setText("");
				
				}catch(Exception ex) {
					//Handle the exception here.
				}
			
			}
		});
		msg_send.setBounds(new Rectangle(0, 0, 200, 100));
		
		//frame.getContentPane().add(SendButton, 100,100);
		frame.getContentPane().add(msg_send, "cell 2 4,growx,aligny top");
		frame.setVisible(true);
	}
	//The not originals end.
	
	public static void main(String[] args) {
		new chat_client_2();
		
		//--------------------------------------------------
		//Opens an extra window.
		
		/*EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					chat_client_2 frame = new chat_client_2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});*/
		
		try {
			String msgin ="";
			/*
			 * To make a socket object. One wants to connect the client to the server running on the port number 1201.
			 * Passing with two methods. No. 1 is to pass the IP address of the server and the no. 2 is the port number.
			 * The IP address is of a local host because the server runs on the same machine.
			 */			
			s = new Socket("127.0.0.1", 1201);
			
			dis = new DataInputStream(s.getInputStream());
			dout = new DataOutputStream(s.getOutputStream());
		
		while(!msgin.equals("exit")) {
			msgin = dis.readUTF();
			msg_Area.setText(msg_Area.getText()+"\n Server: "+msgin);
		}
		
		}catch(Exception e) {
			//Handle the exception here.
		}
		//--------------------------------------------------
	}

	/**
	 * Create the frame.
	 */
	/*public chat_client_2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}*/

}
