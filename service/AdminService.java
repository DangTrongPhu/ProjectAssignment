package com.example.javawebtutor.service;

import java.util.List;

import com.example.javawebtutor.dao.AdminDao;
import com.example.javawebtutor.form.Admin;;

public class AdminService {
	AdminDao adminDao;
	public AdminService()
	{
		adminDao= new AdminDao();
	}
	public List<Admin> getAllAdmin()
	{
		return adminDao.getAllAdmin();
	}
	public Admin getAdminById(int id)
	{
		return adminDao.getAdminById(id);
	}
	public Admin getAdminByName(String name)
	{
		return adminDao.getAdminByName(name);
	}
	public boolean addAdmin(Admin admin)
	{
		return adminDao.addAdmin(admin);
	}
	public boolean updateAdmin(Admin admin)
	{
		return adminDao.updateAdmin(admin);
	}
	public boolean deleteAdmin(int id)
	{
		return adminDao.deleteAdmin(id);
	}
}
