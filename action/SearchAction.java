package com.trongphu;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.trongphu.dao.CustomerDao;

public class SearchAction extends ActionSupport{

	private static final long serialVersionUID = 5375404430419531162L;
	private List<Customer> customerList = new ArrayList<Customer>();
	
	public List<Customer> getCustomerList() {
		return customerList;
	}
	public void setCustomerList(List<Customer> customerList) {
		this.customerList = customerList;
	}
	private String customer_name;
	private String birthdayFrom;
	private String birthdayTo;
	private String sex;
	private int first;
	private String page;
	private String next;
	private String pre;
	
	public String getPre() {
		return pre;
	}
	public void setPre(String pre) {
		this.pre = pre;
	}
	public String getNext() {
		return next;
	}
	public void setNext(String next) {
		this.next = next;
	}
	public String getPage() {
		return page;
	}
	public void setPage(String page) {
		this.page = page;
	}
	public int getFirst() {
		return first;
	}
	public void setFirst(int first) {
		this.first = first;
	}
	public String getCustomer_name() {
		return customer_name;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	public String getBirthdayFrom() {
		return birthdayFrom;
	}
	public void setBirthdayFrom(String birthdayFrom) {
		this.birthdayFrom = birthdayFrom;
	}
	public String getBirthdayTo() {
		return birthdayTo;
	}
	public void setBirthdayTo(String birthdayTo) {
		this.birthdayTo = birthdayTo;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	CustomerDao customerDao = new CustomerDao();
	
	@Override
	public String execute() throws Exception { 
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get( ServletActionContext.HTTP_REQUEST);
		HttpSession session=ServletActionContext.getRequest().getSession(true);  
		//Kiem tra da dang nhap chua
		if(session.getAttribute("user")==null)
		{
			return "error";
		}
		int f=1,l=15,pages=1;
		// Tinh tong so luong bang customer
		int total =customerDao.countCustomer();
		// Moi trang la 15 row
		// tongsotrang = (total/15+1) 
		// vidu : total = 48 => tongsotrang = total/15+1 = 4
		int tongsotrang;
		if(total%15==0)
		{
			tongsotrang = (int)total/15;
		}
		else
		{
			tongsotrang = (int)total/15 +1;
		}
		
		// Neu nguoi dung bam Next hoac Last
		if (request.getParameter("page") != null) {
	        pages = (int) Integer.parseInt(request.getParameter("page"));
	    }
		// Neu nguoi dung bam Next
		if (request.getParameter("next") != null) {			
				pages= pages+1;
			
	    }
		//Neu nguoi dung bam Previous 
		if(request.getParameter("pre")!=null&&pages>1)
		{
			pages = pages-1;
			
		}
		//Neu nguoi dung bam Last 
		if(request.getParameter("last")!=null)
		{
			pages = tongsotrang;
		}
		// Trang load
		if(pages==1)
		{
				f= 1; //first =0
			    l = 15;
			
		}
		else {
			
	        f = (pages - 1) * 15 + 1; // vidu p=2 => f=(2-1)*15+1=16 p=3 => f=(3-1)*15+1=31  
	        l= f+14; // f=16 => l =30, f=31=>l=45
	    }
		//Lay danh sach bang customer khi load
		customerList=customerDao.getAllCustomer(f, l);
		request.setAttribute("page",pages);
		// Neu nguoi dung thuc hien chuc nang Search
		if(birthdayFrom!=null&&birthdayFrom.length()>0)
		{
			f = 0;  l= 0;pages = 1;
			if (request.getParameter("page") != null) {
		        pages = (int) Integer.parseInt(request.getParameter("page"));
		    }
			// Neu an Next
			if (request.getParameter("next") != null) {
				
					pages= pages+1;
				
		    }
			// Neu an Previous
			if(request.getParameter("pre")!=null&&pages>1)
			{
				pages = pages-1;
				
			}
			
			// Tong so mau tin khi tim kiem khi search
			total = customerDao.getCustomerBySearch(birthdayFrom,birthdayTo,customer_name,sex);
			if(total%15==0)
			{
				tongsotrang = (int)total/15;
			}
			else
			{
				tongsotrang = (int)total/15 +1;
			}
			// Neu an Last
			if(request.getParameter("last")!=null)
			{
				pages = tongsotrang;
			}
			// Neu nguoi dung an First
			if(pages==1)
			{
					f = 1; //first =0
				     l = 15;
				
			}
			else {
				
		       f = (pages - 1) * 15 + 1;
		       l= f+14;
		    }
			customerList = customerDao.searchCustomer(birthdayFrom, birthdayTo, customer_name, sex, f,l);
			request.setAttribute("birthdayFrom",birthdayFrom);
			request.setAttribute("birthdayTo",birthdayTo);
			request.setAttribute("sex",sex);
			request.setAttribute("page", pages);
			if(customer_name!=null && customer_name.length()>0)
			{
				request.setAttribute("customer_name",customer_name);
			}
	
			
		
			
		}
		if(request.getParameter("listCustomerId")!=null)
		{
			String listCustomerId = request.getParameter("listCustomerId");
			StringTokenizer strToken = new StringTokenizer(listCustomerId.substring(1, listCustomerId.length()-1),",");
			while(strToken.hasMoreTokens()){
				String subStrToken = strToken.nextToken();
				if(!subStrToken.substring(1, subStrToken.length()-1).equals("on")){
					int idCustomer = Integer.parseInt(subStrToken.substring(1, subStrToken.length()-1));
					customerDao.deleteCustomer1(idCustomer);
				}
			}
		}
		request.setAttribute("last",tongsotrang);
		return "success";
	}
	
	

}
