package com.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import com.model.NetflixModel;
import com.view.Netflix;

public class NetflixImpl implements Netflix2024{

	@Override
	public void addUserThroughSignUp(NetflixModel user) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/netflix ","root","Shyam1122");
			String sql="insert into new_table set(Username,email,phone_no,password)values ('"+user.getUserName()+"','"+user.getEmail()+"','"+user.getPhone_no()+"','"+user.getPassword()+"')";
			Statement stm = con.createStatement();
			stm.execute(sql);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}

	@Override
	public boolean LoginOldUser(NetflixModel user) {
		String query = "SELECT password FROM users WHERE username = '"+user.getUserName()+"'";
        try (Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/netflix","root","Shyam1122");
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1,user.getUserName() );
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String storedPassword = rs.getString("password");
                // Compare hashed passwords (use appropriate hashing logic)
                return user.getPassword().equals(storedPassword);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
		


	@Override
	public void removeUser() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<NetflixModel> getAllUSer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void LoginOldUser() {
		// TODO Auto-generated method stub
		
	}
	
	

}
