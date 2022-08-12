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
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

// A server for chatting.
public class Server extends JFrame {

	private JPanel contentPane;
	private JTextField name1;
	private JTextField name2;

	public static void main(String[] args) {
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
		
		// An event handler for name1-text field.
		name1 = new JTextField();
		name1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				createRoom();
			}
		});
		name1.setBounds(45, 48, 344, 31);
		contentPane.add(name1);
		name1.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("1st username");
		lblNewLabel.setBounds(178, 23, 125, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblndUsername = new JLabel("2nd username");
		lblndUsername.setBounds(180, 124, 123, 14);
		contentPane.add(lblndUsername);
		
		// An event handler for name2-text field.
		name2 = new JTextField();
		name2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				createRoom();
			}
		});
		name2.setColumns(10);
		name2.setBounds(45, 149, 344, 31);
		contentPane.add(name2);
		
		// An event handler for JOIN CHAT-button.
		JButton btnNewButton = new JButton("JOIN CHAT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				createRoom();
			}
		});
		btnNewButton.setBounds(156, 206, 123, 44);
		contentPane.add(btnNewButton);
	}

	private void createRoom() {
		String p1, p2;	// These act as the usernames.
		
		p1 = name1.getText();
		p2 = name2.getText();
		
		if(p1.equals("") || p2.equals("")) {
			JOptionPane.showMessageDialog(null, "Please enter a valid username!");
			return;
		}
		
		Window_1.username1 = name1.getText();	// This username is equal to the text input on the first name field.
		Window_2.username2 = name2.getText();	// This username is equal to the text input on the second name field.
		ChatRoom.createRoom();
	}
}
