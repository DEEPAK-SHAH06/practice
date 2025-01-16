package design;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class FirstPageUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FirstPageUI frame = new FirstPageUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FirstPageUI() {
		setTitle("Quick Bill");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 709, 472);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 153, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome to Super Market Billing System");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 19));
		lblNewLabel.setBounds(141, 21, 410, 23);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Admin Login");
		btnNewButton.setBounds(464, 107, 178, 47);
		contentPane.add(btnNewButton);
		
		JButton btnCashierLogin = new JButton("Cashier Login");
		btnCashierLogin.setBounds(464, 182, 178, 47);
		contentPane.add(btnCashierLogin);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("/Users/deepakshah/Desktop/Second portfolio/1727972764385 copy.jpg"));
		lblNewLabel_1.setBounds(67, 91, 178, 178);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Quick Bill");
		lblNewLabel_2.setFont(new Font("Lucida Grande", Font.BOLD, 44));
		lblNewLabel_2.setBounds(55, 284, 225, 54);
		contentPane.add(lblNewLabel_2);
	}

}
