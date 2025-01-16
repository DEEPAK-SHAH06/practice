package design;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;

public class NewBill extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewBill frame = new NewBill();
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
	public NewBill() {
		setTitle("New Bill");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 776, 656);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Bill No");
		lblNewLabel.setBounds(17, 34, 106, 24);
		contentPane.add(lblNewLabel);
		
		JLabel lblCustomerName = new JLabel("Customer Name");
		lblCustomerName.setBounds(17, 74, 106, 24);
		contentPane.add(lblCustomerName);
		
		JLabel lblProductId = new JLabel("Product Id");
		lblProductId.setBounds(17, 110, 106, 24);
		contentPane.add(lblProductId);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(17, 146, 106, 24);
		contentPane.add(lblName);
		
		JLabel lblMrp = new JLabel("MRP");
		lblMrp.setBounds(17, 182, 106, 24);
		contentPane.add(lblMrp);
		
		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setBounds(17, 218, 106, 24);
		contentPane.add(lblQuantity);
		
		JLabel lblDiscount = new JLabel("Discount");
		lblDiscount.setBounds(17, 254, 106, 24);
		contentPane.add(lblDiscount);
		
		textField = new JTextField();
		textField.setBounds(135, 33, 154, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(135, 73, 154, 26);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(135, 145, 154, 26);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(135, 181, 154, 26);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(135, 217, 154, 26);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(135, 253, 154, 26);
		contentPane.add(textField_5);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Select", "101", "102", "103", "104", "105", "106", "107", "108", "109", "110"}));
		comboBox.setBounds(135, 110, 154, 27);
		contentPane.add(comboBox);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.setBounds(45, 328, 117, 29);
		contentPane.add(btnNewButton);
		
		JButton btnRemove = new JButton("Remove");
		btnRemove.setBounds(172, 328, 117, 29);
		contentPane.add(btnRemove);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setBounds(369, 38, 106, 24);
		contentPane.add(lblDate);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(431, 33, 154, 26);
		contentPane.add(textField_6);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(358, 74, 380, 349);
		contentPane.add(scrollPane);
		
		JLabel lblTotal = new JLabel("Total");
		lblTotal.setBounds(405, 459, 106, 24);
		contentPane.add(lblTotal);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(471, 458, 154, 26);
		contentPane.add(textField_7);
		
		JButton btnNewButton_1 = new JButton("Print");
		btnNewButton_1.setBounds(381, 507, 117, 29);
		contentPane.add(btnNewButton_1);
	}
}
