import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Window_1 extends JFrame {

	// The user name of the Window_1
	static String username1;
	
	private JPanel contentPane;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window_1 frame = new Window_1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Window_1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 451, 493);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		display1 = new JTextArea();
		display1.setBounds(10, 37, 415, 368);
		contentPane.add(display1);
		
		text1 = new JTextArea();
		text1.setBounds(10, 416, 316, 29);
		contentPane.add(text1);
		
		// An event handler for SEND-button.
		send1 = new JButton("SEND");
		send1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// To get the written text of the user and put it to a string. If it is empty, nothing happens.
				String s = text1.getText();
				if(s.equals("")) {
					return;
				}				
				// If the string is not empty, the code runs.
				display1.append(username1 + ":"+ s + "\n");
				Window_2.sendText();
				text1.setText("");	// To clear the writing field after press SEND-button.
			}
			
		});
		send1.setBounds(336, 416, 89, 29);
		contentPane.add(send1);
		
		label1 = new JLabel("Chat window for: "+username1);
		label1.setBounds(10, 11, 255, 15);
		contentPane.add(label1);
		
		// An event handler for CLEAR-button.
		JButton clear1 = new JButton("CLEAR");
		clear1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				display1.setText("");
			}
		});
		clear1.setBounds(336, 7, 89, 23);
		contentPane.add(clear1);
	}

	public static void sendText() {
		String s = Window_2.text2.getText();	// This makes a string to get a text from the text writing field of Window_2.
		if(s.equals("")) {	// If the text of string s equals to nothing. It returns; the program does nothing.
			return;
		}
		display1.append(Window_2.username2 + ":" + s + "\n");	// If string s is not empty. This part will be done. The text written by Window_2 will be added to the main text area of the Window_1 like this: Peter: Hello everyone!
	}
	
	private javax.swing.JLabel label1;
	private static javax.swing.JTextArea display1;
	private javax.swing.JButton send1;
	public static javax.swing.JTextArea text1;
}
