package demo.pattern.structural.flyweightpattern;

public class Connection {
	
	private int no;

	private String uri;
	
	private String username;
	
	private String password;

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Connection(int no, String uri, String username, String password) {
		this.no = no;
		this.uri = uri;
		this.username = username;
		this.password = password;
	}
	
}
