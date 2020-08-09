package bean;

public class User {
	private int id;
	private String account;
	private String password;
	private String email;
	
	
	public User(int id, String account, String password, String email) {
		super();
		this.id = id;
		this.account = account;
		this.password = password;
		this.email = email;
	}
	
	public User() {
		super();
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
