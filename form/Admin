package com.example.javawebtutor.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class Admin extends ActionForm{

	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private String sex;
	private String pass;
	private String warning = "";
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public void addWarning(String warning) {
		this.warning ="<B><FONT COLOR=RED>" +
		warning + "!</FONT></B><BR>";
	}
	public String getWarning() {
		return warning;
	}
	public void setWarning(String warning) {
		this.warning = warning;
	}
	@Override
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
		ActionErrors actionErrors = new ActionErrors();
		if(getName()==null||getName().length()==0)
		{
			actionErrors.add("admin.name.required",new ActionMessage("error.admin.name.required"));
		}
		
		
		if(getPass()==null||getPass().length()==0)
		{
			actionErrors.add("admin.pass.required",new ActionMessage("error.admin.pass.required"));
		}
		if(getSex()==null||getSex().length()==0)
		{
			actionErrors.add("admin.sex.required",new ActionMessage("error.admin.sex.required"));
		}
		return actionErrors;
	}
	
}
