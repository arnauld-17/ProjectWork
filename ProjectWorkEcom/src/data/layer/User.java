package data.layer;

import java.io.Serializable;

public class User implements Serializable{
	

	private static final long serialVersionUID = 1354678L;
	private String username;
	private String password;

	public String getUsername() {
		return username;
	}
	public void setUsername(String userName) {
		this.username = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String Password) {
		this.password = Password;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
}
