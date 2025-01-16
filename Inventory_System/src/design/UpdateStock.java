package design;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import com.jgoodies.forms.factories.DefaultComponentFactory;

public class UpdateStock extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateStock frame = new UpdateStock();
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
	public UpdateStock() {
		setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		setTitle("Update Stock");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 855, 546);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(411, 31, 426, 447);
		contentPane.add(scrollPane);
		
		JLabel lblNewLabel = new JLabel("Product Id");
		lblNewLabel.setBounds(24, 106, 96, 26);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(190, 106, 198, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblProductName = new JLabel("Product Name");
		lblProductName.setBounds(24, 147, 102, 26);
		contentPane.add(lblProductName);
		
		JLabel lblQuantityAvailable = new JLabel("Quantity Available");
		lblQuantityAvailable.setBounds(24, 185, 130, 26);
		contentPane.add(lblQuantityAvailable);
		
		JLabel lblQuantityAdded = new JLabel("Quantity Added");
		lblQuantityAdded.setBounds(24, 223, 130, 26);
		contentPane.add(lblQuantityAdded);
		
		JLabel lblMrp = new JLabel("MRP");
		lblMrp.setBounds(24, 261, 96, 26);
		contentPane.add(lblMrp);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(190, 147, 198, 26);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(190, 185, 198, 26);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(190, 223, 198, 26);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(190, 261, 198, 26);
		contentPane.add(textField_4);
		
		JButton btnNewButton = new JButton("New");
		btnNewButton.setBounds(47, 343, 117, 29);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Update");
		btnNewButton_1.setBounds(211, 343, 117, 29);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewJgoodiesLabel = DefaultComponentFactory.getInstance().createLabel("Update Stock");
		lblNewJgoodiesLabel.setFont(new Font("Lucida Grande", Font.BOLD, 23));
		lblNewJgoodiesLabel.setBounds(78, 31, 237, 44);
		contentPane.add(lblNewJgoodiesLabel);
	}
}
