package com.trongphu;

import java.sql.Date;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.trongphu.dao.CustomerDao;

public class AddAction extends ActionSupport{
	private static final long serialVersionUID = 1263832928803089315L;
	private Customer customer = new Customer();
	private CustomerDao customerDao = new CustomerDao();
	
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	private int customer_id;
	private String customer_name;
	private String sex;
	private String birthday;
	private String email;
	private String address;
	private Date delete_ymd;
	private Date insert_ymd;
	private int insert_psn_cd;
	private Date update_ymd;
	private int update_psn_cd;
	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	public String getCustomer_name() {
		return customer_name;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getDelete_ymd() {
		return delete_ymd;
	}
	public void setDelete_ymd(Date delete_ymd) {
		this.delete_ymd = delete_ymd;
	}
	public Date getInsert_ymd() {
		return insert_ymd;
	}
	public void setInsert_ymd(Date insert_ymd) {
		this.insert_ymd = insert_ymd;
	}
	public int getInsert_psn_cd() {
		return insert_psn_cd;
	}
	public void setInsert_psn_cd(int insert_psn_cd) {
		this.insert_psn_cd = insert_psn_cd;
	}
	public Date getUpdate_ymd() {
		return update_ymd;
	}
	public void setUpdate_ymd(Date update_ymd) {
		this.update_ymd = update_ymd;
	}
	public int getUpdate_psn_cd() {
		return update_psn_cd;
	}
	public void setUpdate_psn_cd(int update_psn_cd) {
		this.update_psn_cd = update_psn_cd;
	}
	public String add()
	{
		HttpSession session=ServletActionContext.getRequest().getSession(true);  
		//Kiem tra da dang nhap chua
		if(session.getAttribute("user")==null)
		{
			return "login";
		}
		long millis=System.currentTimeMillis();  
		java.sql.Date date=new java.sql.Date(millis);  
		 UserAction userAction = (UserAction)session.getAttribute("user");
		try {
			if(String.valueOf(customer_id)==null || customer_id==0)
			{
				if(customerDao.addCustomer(new Customer(0,customer_name,
						sex, birthday, email, address,null, date,
						userAction.getPsn_cd(),date,userAction.getPsn_cd())))
				{
					return "success";
				}
			}
			
			else
			{
				if(customerDao.updateCustomer(new Customer(customer_id,customer_name,
						sex, birthday, email, address,null, date,
						userAction.getPsn_cd(),date,userAction.getPsn_cd())))
			{
				return "success";
			}
			}
			
		}catch (Exception e) {
			
			e.printStackTrace();
		}
		return "error";
		
	}

}
