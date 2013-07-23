package com.aws.global.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import com.aws.global.common.base.BaseActionSupport;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
@Namespace("/")
@Action(value="index", results={
	@Result(name=ActionSupport.SUCCESS, location="pages/index.jsp"),
})
public class IndexAction extends BaseActionSupport {

	//Home Page of the System
	public String execute() {
		// TODO : ADD IMPLEMENTATION HERE
		System.out.println("Home Page");
		return ActionSupport.SUCCESS;
	}
}
