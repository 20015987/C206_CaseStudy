
public class Account {
	
	public String name;
	public String role;
	public String email;
	public String password;
	public String status;
	public Account(String name, String role, String email, String password, String status) {

		this.name = name;
		this.role = role;
		this.email = email;
		this.password = password;
		this.status = status;
	}
	public String getName() {
		return name;
	}
	public String getRole() {
		return role;
	}
	public String getEmail() {
		return email;
	}
	public String getPassword() {
		return password;
	}
	public String getStatus() {
		return status;
	}
}