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

public class Window_2 extends JFrame {

	// The user name of the Window_2.
	static String username2;
		
	private JPanel contentPane;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window_2 frame = new Window_2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Window_2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 493);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		display2 = new JTextArea();
		display2.setBounds(10, 39, 414, 364);
		contentPane.add(display2);
		
		text2 = new JTextArea();
		text2.setBounds(10, 414, 315, 29);
		contentPane.add(text2);
		
		// An event handler for SEND-button.
		send2 = new JButton("SEND");
		send2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s = text2.getText();
				if(s.equals("")) {
					return;
				}				
				// If the string is not empty, the code runs.
				display2.append(username2 + ":"+ s + "\n");
				Window_1.sendText();
				text2.setText("");	// To clear the writing field after press SEND-button.
			}
		});
		send2.setBounds(335, 411, 89, 32);
		contentPane.add(send2);
		
		label2 = new JLabel("Chat window for: "+username2);
		label2.setBounds(10, 10, 255, 15);
		contentPane.add(label2);
		
		// An event handler for CLEAR-button.
		JButton clear2 = new JButton("CLEAR");
		clear2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				display2.setText("");
			}
		});
		clear2.setBounds(335, 5, 89, 25);
		contentPane.add(clear2);
	}

	public static void sendText() {
		String s = Window_1.text1.getText();	// This makes a string to get a text from the text writing field of Window_1.
		if(s.equals("")) {	// If the text of string s equals to nothing. It returns; the program does nothing.
			return;
		}
		display2.append(Window_1.username1 + ":" + s + "\n");	// If string s is not empty. This part will be done. The text written by Window_1 will be added to the main text area of the Window_1 like this: Peter: Hello everyone!
	}

	private javax.swing.JLabel label2;
	private static javax.swing.JTextArea display2;
	private javax.swing.JButton send2;
	public static javax.swing.JTextArea text2;



}
