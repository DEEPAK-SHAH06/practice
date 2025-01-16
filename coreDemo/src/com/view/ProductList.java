package com.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.model.Product;
import com.service.ProductService;
import com.service.ProductServiceImpl;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.List;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.print.PrinterException;

public class ProductList extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField nameTxt;
	private JTextField priceTxt;
	private JTextField companyTxt;
    private JComboBox categoryCmb;
    int id;
    private JTextField searchTxt;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProductList frame = new ProductList();
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
	public ProductList() {
		setTitle("ProductList");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 963, 541);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(293, 79, 500, 300);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id", "Name", "Price", "Category", "Company"
			}
		));
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("ProductList");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel.setBounds(403, 6, 250, 30);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Delete");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(table.getSelectedRow()<0) {
					JOptionPane.showMessageDialog(null, "Select any data");
					return ;
				}
				
				int selro = table.getSelectedRow();
				int id = (int) table.getModel().getValueAt(selro, 0);
				
				ProductService ps = new ProductServiceImpl();
				ps.deleteProduct(id);
				
				JOptionPane.showMessageDialog(null, "Deleted successfully");
				
				displayData();
			}
		});
		btnNewButton.setBounds(481, 409, 117, 29);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Edit");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(table.getSelectedRow()<0) {
					JOptionPane.showMessageDialog(null, "Select any data");
					return ;
				}
				
				int selro = table.getSelectedRow();
				  id = (int) table.getModel().getValueAt(selro, 0);
				
				
				nameTxt.setText(table.getModel().getValueAt(selro, 1).toString());
				priceTxt.setText(table.getModel().getValueAt(selro, 2).toString());
				categoryCmb.setSelectedItem(table.getModel().getValueAt(selro, 3).toString());
				companyTxt.setText(table.getModel().getValueAt(selro, 4).toString());

				
			}
		});
		btnNewButton_1.setBounds(337, 409, 117, 29);
		contentPane.add(btnNewButton_1);
		
		JLabel price = new JLabel("Price");
		price.setBounds(6, 140, 61, 16);
		contentPane.add(price);
		
		JLabel name = new JLabel("Name");
		name.setBounds(6, 99, 61, 16);
		contentPane.add(name);
		
		JLabel category = new JLabel("category");
		category.setBounds(6, 173, 61, 16);
		contentPane.add(category);
		
		JLabel company = new JLabel("Company");
		company.setBounds(6, 213, 61, 16);
		contentPane.add(company);
		
//	    comboBox = new JComboBox();
//		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Select", "Electronics", "Mechanics", "Food ", "Clothing", "Cosmetics"}));
//		comboBox.setBounds(79, 169, 108, 27);
//		contentPane.add(comboBox);
	//	btnNewButton_2.setBounds(46, 293, 117, 29);
	//	contentPane.add(btnNewButton_2);
		
	    categoryCmb = new JComboBox();
		categoryCmb.setModel(new DefaultComboBoxModel(new String[] {"Select", "Electronics", "Mechanical", "Food", "Clothing", "Cosmetics", ""}));
		categoryCmb.setBounds(79, 169, 84, 27);
		contentPane.add(categoryCmb);
		
		displayData();
	
		
		nameTxt = new JTextField();
		nameTxt.setBounds(57, 94, 130, 26);
		contentPane.add(nameTxt);
		nameTxt.setColumns(10);
		
		priceTxt = new JTextField();
		priceTxt.setColumns(10);
		priceTxt.setBounds(57, 135, 130, 26);
		contentPane.add(priceTxt);
		
		companyTxt = new JTextField();
		companyTxt.setColumns(10);
		companyTxt.setBounds(79, 208, 130, 26);
		contentPane.add(companyTxt);
		
		JButton btnNewButton_3 = new JButton("Update");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
            Product p = new Product();
				
				p.setId(id);
				p.setName(nameTxt.getText());
				p.setPrice(Integer.parseInt(priceTxt.getText()));
				p.setCompany(companyTxt.getText());
				p.setProductCategory(categoryCmb.getSelectedItem().toString());
				
				ProductService ps = new ProductServiceImpl();
				
				ps.updateProduct(p);
				JOptionPane.showMessageDialog(null,"udate success");
				displayData();
				
				//clear input data
				nameTxt.setText("");
				companyTxt.setText("");
				categoryCmb.setSelectedIndex(0);
				companyTxt.setText("");
				
			}
		});
		btnNewButton_3.setBounds(46, 280, 117, 29);
		contentPane.add(btnNewButton_3);
		
		JLabel lblNewLabel_1 = new JLabel("Search");
		lblNewLabel_1.setBounds(16, 17, 61, 16);
		contentPane.add(lblNewLabel_1);
		
		searchTxt = new JTextField();
		searchTxt.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String sdata = searchTxt.getText().trim();
				ProductService ps = new ProductServiceImpl();
				
				List<Product> plist = ps.searchProduct(sdata);
				DefaultTableModel tmodel = (DefaultTableModel) table.getModel();
				tmodel.setRowCount(0);//reset table data
				
				for(Product p : plist) {
					tmodel.addRow(new Object[] {p.getId(),p.getName(),p.getPrice(),p.getCompany(),p.getProductCategory()});
				}		
			}
		});
		searchTxt.setBounds(79, 12, 130, 26);
		contentPane.add(searchTxt);
		searchTxt.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("Print");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					table.print();
				} catch (PrinterException e1) {
					
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton_2.setBounds(628, 409, 117, 29);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_4 = new JButton("Refresh");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displayData();
			}
		});
		btnNewButton_4.setBounds(791, 12, 117, 29);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Add product");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProductForm pro = new ProductForm();
			    pro.setVisible(true);
		    }
		});
		btnNewButton_5.setBounds(16, 357, 117, 29);
		contentPane.add(btnNewButton_5);
		
		
	}

	//display data in jtable
	
	private void displayData(){
		
		ProductService ps = new ProductServiceImpl();
		List<Product> plist = ps.getAllProducts();
		
		DefaultTableModel tmodel = (DefaultTableModel) table.getModel();
		tmodel.setRowCount(0);//reset table data
		
		for(Product p : plist) {
			tmodel.addRow(new Object[] {p.getId(),p.getName(),p.getPrice(),p.getCompany(),p.getProductCategory()});
		}
		
	}
}







