package web.formbean;

import java.util.HashMap;
import java.util.Map;

public class RegisterFormBean {
	private String account;
	private String password;
	private String confirmPwd;
	private String email;
	
	private Map<String,String> errors = new HashMap<String,String>();
	public Map<String,String> getErrors(){
		return errors;
	}
	public void setErrors(Map<String,String> errors) {
		this.errors = errors;
	}
	
	public boolean validate() {
		boolean isOK = true;
		
		if(this.account==null || this.account.trim().equals("")) {
			isOK = false;
			errors.put("account", "用户不能为空！");
		}else {
			if(!this.account.matches("[a-zA-Z]{3,8}")) {
				isOK = false;
				errors.put("account", "用户名必须是3-8位的字母！");
			}
		}
		
		if(this.password==null || this.password.trim().equals("")) {
			isOK = false;
			errors.put("password", "密码不能为空！");
		}else {
			if(!this.password.matches("\\d{3,8}")) {
				isOK = false;
				errors.put("password", "密码必须是3-8位的数字！");
			}
		}
		
		if(this.confirmPwd != null) {
			if(!this.confirmPwd.equals(this.password)) {
				isOK = false;
				errors.put("confirmPwd", "两次密码不一致！");
			}
		}
		
		if (this.email != null && !this.email.trim().equals("")) {
			 if(!this.email.matches("\\w+@\\w+(\\.\\w+)+")){
				 isOK = false;
				 errors.put("email", "邮箱不是一个合法邮箱！");
			 }
		}
		return isOK;
	}
	public String getaccount() {
		return account;
	}
	public void setaccount(String account) {
		this.account = account;
	}
	public String getpassword() {
		return password;
	}
	public void setpassword(String password) {
		this.password = password;
	}
	public String getConfirmPwd() {
		return confirmPwd;
	}
	public void setConfirmPwd(String confirmPwd) {
		this.confirmPwd = confirmPwd;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
