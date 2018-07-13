package com.example.javawebtutor.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.example.javawebtutor.form.Admin;
import com.example.javawebtutor.form.User;
import com.example.javawebtutor.untills.JDBCConnection;

public class AdminDao {
	public List<Admin> getAllAdmin()
	{
		List<Admin> admins= new ArrayList<>();
		Connection connection= JDBCConnection.get_JDBCConnection();
		String sql="Select * from admin ";
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			ResultSet rs=preparedStatement.executeQuery();
			while (rs.next()) {
				Admin admin = new Admin();
				admin.setId(rs.getInt("id"));
				admin.setName(rs.getString("name"));
				admin.setSex(rs.getString("sex"));
				admin.setPass(rs.getString("pass"));
				admins.add(admin);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return admins;
	}
	public Admin getAdminById(int id)
	{
		String sql="Select * from admin where id= ? ";
		Connection connection= JDBCConnection.get_JDBCConnection();
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setInt(1,id);
			ResultSet rs=preparedStatement.executeQuery();
			while (rs.next()) {
				Admin admin = new Admin();
				admin.setId(rs.getInt("id"));
				admin.setName(rs.getString("name"));
				admin.setSex(rs.getString("sex"));
				admin.setPass(rs.getString("pass"));
				return admin;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}
	public Admin getAdminByName(String name)
	{
		String sql="Select * from admin where name= ? ";
		Connection connection= JDBCConnection.get_JDBCConnection();
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1,name);
			ResultSet rs=preparedStatement.executeQuery();
			while (rs.next()) {
				Admin admin = new Admin();
				admin.setId(rs.getInt("id"));
				admin.setName(rs.getString("name"));
				admin.setSex(rs.getString("sex"));
				admin.setPass(rs.getString("pass"));
				return admin;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}
	public boolean addAdmin(Admin admin)
	{
		Connection connection = JDBCConnection.get_JDBCConnection();
		String sql = "Insert into admin(name,sex,pass) values(?,?,?)";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1,admin.getName());
			preparedStatement.setString(2, admin.getSex());
			preparedStatement.setString(3,admin.getPass());
			int rs = preparedStatement.executeUpdate();
			if(rs>0)
			{
				return true;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean updateAdmin(Admin admin)
	{
		Connection connection = JDBCConnection.get_JDBCConnection();
		String sql = "Update admin set name= ?, sex=? , pass=? where id=?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1,admin.getName());
			preparedStatement.setString(2, admin.getSex());
			preparedStatement.setString(3,admin.getPass());
			preparedStatement.setInt(4, admin.getId());
			int rs = preparedStatement.executeUpdate();
			if(rs>0)
			{
				return true;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
	public boolean deleteAdmin(int id){
	    try {
	    	Connection connection = JDBCConnection.get_JDBCConnection();
	        String sql = "DELETE FROM admin WHERE id = ?";
	        PreparedStatement ps = connection.prepareStatement(sql);
	        ps.setInt(1,id);
	        int temp = ps.executeUpdate();
	        if(temp>0)
			{
				return true;
			}  
	    } catch (Exception e) {
	       
	    }
	    return false;
	}
}
