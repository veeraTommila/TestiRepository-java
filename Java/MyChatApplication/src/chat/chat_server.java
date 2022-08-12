package chat;

import javax.swing.JFrame;
import javax.swing.JTextPane;
import java.awt.BorderLayout;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Rectangle;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.awt.ComponentOrientation;
import java.awt.EventQueue;

import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Component;
import net.miginfocom.swing.MigLayout;
import javax.swing.Box;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class chat_server extends JFrame{
	
	static ServerSocket ss;
	static Socket s;
	static DataInputStream dis;
	static DataOutputStream dout;
	
	//------------------------------------------------------------
	JFrame frame;
	static JTextField msg_text;
	static JTextArea msg_Area;
	private JLabel lblNewLabel;
	 
	
	public chat_server() {
		initComponent();
	}
	
	
	public void initComponent() {
		frame = new JFrame("Chat server");
		frame.setSize(400, 400);
		frame.getContentPane().setLayout(new MigLayout("", "[3px][295px][86px]", "[][][338px][][23px]"));
		
		lblNewLabel = new JLabel("Server");
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
		
		JButton SendButton = new JButton("Send");
		SendButton.addActionListener(new ActionListener() {			
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
		SendButton.setBounds(new Rectangle(0, 0, 200, 100));
		
		//frame.getContentPane().add(SendButton, 100,100);
		frame.getContentPane().add(SendButton, "cell 2 4,growx,aligny top");
		frame.setVisible(true);
	}
	//------------------------------------------------------
	
	public static void main(String[] args) {
		new chat_server();
		
		//--------------------------------------
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
			ss = new ServerSocket(1201); //Port number where the server socket will run.
		
			//To accept a request from a client. S means a socket object.
			s = ss.accept();
			dis = new DataInputStream(s.getInputStream());
			dout = new DataOutputStream(s.getOutputStream());
		
		while(!msgin.equals("exit")) {
			msgin = dis.readUTF();
			msg_Area.setText(msg_Area.getText()+"\n Client: "+msgin);
		}
		
		}catch(Exception e) {
			//Handle the exception here.
		}
		//-------------------------------------------
	}

}
