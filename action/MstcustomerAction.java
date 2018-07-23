package com.example.javawebtutor.action;


import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.MappingDispatchAction;
import com.example.javawebtutor.form.Mstcustomer;
import com.example.javawebtutor.service.MstcustomerService;


public class MstcustomerAction extends MappingDispatchAction{
	MstcustomerService mstcustomerService;
	public MstcustomerAction() {
		mstcustomerService = new MstcustomerService();
	}
	public ActionForward search(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
			int first = 0, last = 0, pages = 1;
			HttpSession session = request.getSession(true);
			Mstcustomer mstcustomer = new Mstcustomer();
			
			List<Mstcustomer> mstcustomers = new ArrayList<>();
			if(session.getAttribute("mstuser") == null){
			return mapping.findForward("login");
			}
				
			
			
			if (request.getParameter("page") != null) {
		        pages = (int) Integer.parseInt(request.getParameter("page"));
		    }
			if (request.getParameter("next") != null) {
				if(pages==1)
				{
					pages = pages+1; 
				}
				else
				{
					pages= pages+1;
				}
				
		    }
			if(request.getParameter("pre")!=null&&pages>1)
			{
				pages = pages-1;
				
			}
			int total =mstcustomerService.countCustomer();
			if(request.getParameter("last")!=null)
			{
				pages = (int)total/15 +1;
				mstcustomer.setNext(pages);
				mstcustomer.setLast(pages);
			}
			if(pages==1)
			{
					 first = 1; //first =0
				     last = 15;
				
			}
			else {
				
		        first = (pages - 1) * 15 + 1;
		        last= first+14;
		    }
			
			mstcustomers = mstcustomerService.getAllCustomer(first,last);
			request.setAttribute("customerList",mstcustomers);
			if(mstcustomer!=null && request.getParameter("birthdayFrom")!=null)
			{
				mstcustomer =(Mstcustomer) form;
				
				mstcustomer.setBirthdayFrom(request.getParameter("birthdayFrom"));
				mstcustomer.setBirthdayTo(request.getParameter("birthdayTo"));
				first = 0;  last= 0;pages = 1;
				if (request.getParameter("page") != null) {
			        pages = (int) Integer.parseInt(request.getParameter("page"));
			    }
				if (request.getParameter("next") != null) {
					if(pages==1)
					{
						pages = pages+1; 
					}
					else
					{
						pages= pages+1;
					}
					mstcustomer.setNext(pages);
					
			    }
				if(request.getParameter("pre")!=null&&pages>1)
				{
					pages = pages-1;
					
				}
				total = mstcustomerService.getCustomerBySeach(mstcustomer.getBirthdayFrom(),mstcustomer.getBirthdayTo(),mstcustomer.getCUSTOMER_NAME(),mstcustomer.getSEX());
				if(request.getParameter("last")!=null)
				{
					pages = (int)total/15 +1;
					mstcustomer.setNext(pages);
					mstcustomer.setLast(pages);
				}
				if(pages==1)
				{
						 first = 1; //first =0
					     last = 15;
					
				}
				else {
					
			        first = (pages - 1) * 15 + 1;
			        last= first+14;
			    }
				
				mstcustomer.setLast((int)total/15 +1);
				mstcustomer.setPage(pages);
			
				 mstcustomers = mstcustomerService.searchCustomer(mstcustomer.getBirthdayFrom(),mstcustomer.getBirthdayTo(),mstcustomer.getCUSTOMER_NAME(),mstcustomer.getSEX(),first,last);
				request.setAttribute("customer",mstcustomer);
				 request.setAttribute("customerList", mstcustomers);
				
				return mapping.findForward("search");
			}
			mstcustomer.setLast((int)total/15 +1);
			mstcustomer.setPage(pages);
			
			if(request.getParameter("listCustomerId")!=null)
			{
				String listCustomerId = request.getParameter("listCustomerId");
				StringTokenizer strToken = new StringTokenizer(listCustomerId.substring(1, listCustomerId.length()-1),",");
				while(strToken.hasMoreTokens()){
					String subStrToken = strToken.nextToken();
					if(!subStrToken.substring(1, subStrToken.length()-1).equals("on")){
						int idCustomer = Integer.parseInt(subStrToken.substring(1, subStrToken.length()-1));
						mstcustomerService.deleteCustomer(idCustomer);
					}
				}
				request.setAttribute("customer", mstcustomer);
				request.setAttribute("customerList", mstcustomers);
				return mapping.findForward("delete");
			}
			request.setAttribute("customer", mstcustomer);
			request.setAttribute("customerList", mstcustomers);
			return mapping.findForward("load");
		
		
	
	}
	
	public ActionForward add(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		Mstcustomer mstcustomer=null;
		if(id.equals("add"))
		{
			mstcustomer = new Mstcustomer();
			mstcustomer.setBIRTHDAY("");
			mstcustomer.setADDRESS("");
			mstcustomer.setEMAIL("");
			mstcustomer.setCUSTOMER_NAME("");
			request.setAttribute("status","Add New");
			request.setAttribute("customer", mstcustomer);
			return mapping.findForward("add");
		}
		else
		{
			mstcustomer =(Mstcustomer) form;
			mstcustomer = mstcustomerService.getCustomerById(id);
			request.setAttribute("customer", mstcustomer);
			request.setAttribute("status","Edit");
			return mapping.findForward("add");
		}
		
	}
	
	public ActionForward addPost(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession(true);
		Mstcustomer mstcustomer = new Mstcustomer();
		int psn_cd = Integer.parseInt(session.getAttribute("PSNCD").toString());
		String customerid=request.getParameter("CUSTOMER_ID") ;
		String customername= request.getParameter("CUSTOMER_NAME");
		if(customerid==null|| customerid.length()==0 )
		{
		mstcustomer = new Mstcustomer();
		customername= request.getParameter("CUSTOMER_NAME");
		String sex = request.getParameter("SEX");
		String birthday = request.getParameter("BIRTHDAY");
		String email = request.getParameter("EMAIL");
		String adddress = request.getParameter("ADDRESS");
		mstcustomer.setCUSTOMER_NAME(customername);
		mstcustomer.setSEX(sex);
		mstcustomer.setBIRTHDAY(birthday);
		mstcustomer.setEMAIL(email);
		mstcustomer.setADDRESS(adddress);
		mstcustomer.setINSERT_PSN_CD(psn_cd);
		long millis=System.currentTimeMillis();  
		
		java.sql.Date date=new java.sql.Date(millis);  

		mstcustomer.setINSERT_YMD(date);
		if(mstcustomerService.addCustomer(mstcustomer))
		{
			return mapping.findForward("success");
		}
		else
		{
		mstcustomer.addWarning("add customer error");
		}
		
		}
		else {
			long millis=System.currentTimeMillis();  
			
			java.sql.Date date=new java.sql.Date(millis);  
			Mstcustomer mstcustomers = (Mstcustomer) form;; 
			mstcustomers.setUPDATE_PSN_CD(psn_cd);
			mstcustomers.setUPDATE_YMD(date);
			if(mstcustomerService.updateCustomer(mstcustomers))
			{
				return mapping.findForward("success");
			}
		}
			
		return mapping.findForward("failure");
	}
	
	
	
	

}
