package hello.user;

import org.springframework.stereotype.Component;


@Component
public class User {

	private String id;
	private String name;
	private String email;
	private String pw;
	private String type;

	public User() {
		
	}
	
	public User(String id, String name, String email, String pw, String type) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.pw = pw;
		this.type = type;
	}
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
