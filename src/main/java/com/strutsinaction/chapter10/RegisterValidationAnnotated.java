package com.strutsinaction.chapter10;


import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.EmailValidator;
import com.opensymphony.xwork2.validator.annotations.ExpressionValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.StringLengthFieldValidator;
import com.opensymphony.xwork2.validator.annotations.ValidatorType;
import com.strutsinaction.domain.Portfolio;
import com.strutsinaction.domain.User;

/*
 * This version of Register uses the Validation Framework, instead of the 
 * Validateable interfaces validate() method. In particular, this one uses the 
 * Java annotations method of specifying the validation meta-data.
 * 
 */

/*
 * This annotation marks the class as having validation annotations.
 */


public class RegisterValidationAnnotated extends ActionSupport implements SessionAware {

	@ExpressionValidator(expression = "username != password", message = "Username and password can't be the same.")
	public String execute(){
		
		/*
		 * Create and move the data onto our application domain object, user.
		 */
		User user = new User();
		user.setPassword( getPassword() );
		Portfolio newPort = new Portfolio();
		newPort.setName( getPortfolioName() );
//		user.getPortfolios().add( newPort );
		user.setUsername( getUsername() );
		
		/* Login the newly created user */
//		getPortfolioService().persistUser( user );
//		session.put( Struts2PortfolioConstants.USER, user );
//		
		
		return SUCCESS;
	}
	
	
	/* JavaBeans Properties to Receive Request Parameters */
	
	private String username;
	private String password;
	private String portfolioName;
	private boolean receiveJunkMail;
	private String email;
	
	@RequiredStringValidator(type = ValidatorType.FIELD, message="Email is required.")
	@EmailValidator(type = ValidatorType.FIELD, key="email.invalid", message="Email no good.")
	public void setEmail(String email) {
		this.email = email;
	}
  	public String getEmail() {
		return email;
	}

	@RequiredStringValidator(type = ValidatorType.FIELD, message = "Portfolio name is required.")
	public String getPortfolioName() {
		return portfolioName;
	}
	public void setPortfolioName(String portfolioName) {
		this.portfolioName = portfolioName;
	}
	
	@StringLengthFieldValidator(type = ValidatorType.FIELD, minLength="5" , maxLength = "8",  message = "Password must be between ${minLength} and ${maxLength} characters.")
    @RequiredStringValidator(type = ValidatorType.FIELD, message = "Password is required.")
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	@RequiredStringValidator(type = ValidatorType.FIELD, message = "Username is required.")
	@StringLengthFieldValidator(type = ValidatorType.FIELD, minLength="5" , maxLength = "8",  message = "Username must be between ${minLength} and ${maxLength} characters.")
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	public boolean isReceiveJunkMail() {
		return receiveJunkMail;
	}
	public void setReceiveJunkMail(boolean receiveJunkMail) {
		this.receiveJunkMail = receiveJunkMail;
	}
//
//	private PortfolioServiceInterface portfolioService;
//	
//	public PortfolioServiceInterface getPortfolioService( ) 	{
//		
//		return portfolioService;
//		
//	}
//	
//	public void setPortfolioService( PortfolioServiceInterface portService){
//		portfolioService = portService;
//	}
//	
	
	private Map session;
	
	public void setSession(Map session) {
		
		this.session = session;
	}
	
	

}
