package com.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.model.Product;
import com.service.ProductService;
import com.service.ProductServiceImpl;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ProductForm extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField nameTxt;
	private JLabel lblNewLabel_1;
	private JTextField companyTxt;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JTextField priceTxt;
	private JComboBox categoryCombo;
	private JButton btnNewButton;
	private JLabel lblNewLabel_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProductForm frame = new ProductForm();
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
	public ProductForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 564, 373);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setBounds(41, 95, 61, 16);
		contentPane.add(lblNewLabel);
		
		nameTxt = new JTextField();
		nameTxt.setBounds(114, 90, 130, 26);
		contentPane.add(nameTxt);
		nameTxt.setColumns(10);
		
		lblNewLabel_1 = new JLabel("Company");
		lblNewLabel_1.setBounds(41, 131, 61, 16);
		contentPane.add(lblNewLabel_1);
		
		companyTxt = new JTextField();
		companyTxt.setBounds(114, 128, 130, 26);
		contentPane.add(companyTxt);
		companyTxt.setColumns(10);
		
		lblNewLabel_2 = new JLabel("Price");
		lblNewLabel_2.setBounds(41, 169, 61, 16);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Category");
		lblNewLabel_3.setBounds(41, 209, 61, 16);
		contentPane.add(lblNewLabel_3);
		
		priceTxt = new JTextField();
		priceTxt.setBounds(114, 166, 130, 26);
		contentPane.add(priceTxt);
		priceTxt.setColumns(10);
		
		categoryCombo = new JComboBox();
		categoryCombo.setModel(new DefaultComboBoxModel(new String[] {"Select your category", "Electronics", "Cosmetics", "Clothing", "Mechanical", "Food"}));
		categoryCombo.setBounds(114, 205, 130, 27);
		contentPane.add(categoryCombo);
		
		btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				//input validation
				
				if(nameTxt.getText().isBlank()) {
					JOptionPane.showMessageDialog(nameTxt,"Name is required");
					return;
				}
				
				if(companyTxt.getText().isBlank()) {
					JOptionPane.showMessageDialog(companyTxt,"Company is required");
					return;
				}
				
				if(priceTxt.getText().isBlank()) {
					JOptionPane.showMessageDialog(priceTxt,"Price is required");
					return;
				}
				
				if(categoryCombo.getSelectedIndex()==0) {
					JOptionPane.showMessageDialog(categoryCombo,"Select Category");
					return;
				}
			
				//get data from productForm
				String nm = nameTxt.getText();
				String company = companyTxt.getText();
				int price = Integer.parseInt(priceTxt.getText());
				String category = categoryCombo.getSelectedItem().toString();
				
						
				//set data to product object
				Product p = new Product();
				p.setName(nm);
				p.setCompany(company);
				p.setPrice(price);
				p.setProductCategory(category);
				
				
				ProductService ps = new ProductServiceImpl();
				ps.adddProduct(p);
				
				JOptionPane.showInternalMessageDialog(null,"Added Success");
				
				//clear input data
				nameTxt.setText("");
				companyTxt.setText("");
				categoryCombo.setSelectedIndex(0);
				priceTxt.setText("");
			}
		});
		btnNewButton.setBounds(206, 245, 117, 29);
		contentPane.add(btnNewButton);
		
		lblNewLabel_4 = new JLabel("Product Details");
		lblNewLabel_4.setFont(new Font("Monospaced", Font.BOLD, 40));
		lblNewLabel_4.setBounds(90, 6, 360, 48);
		contentPane.add(lblNewLabel_4);
	}

}
