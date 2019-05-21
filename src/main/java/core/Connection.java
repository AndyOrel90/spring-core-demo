package core;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component @Qualifier("awsConnection")
public class Connection {
	@Value("AWS")
	private String url;
	@Value("admin")
	private String username;
	@Value("admin")
	private String password;

	public Connection() {
	}

	public Connection(String url, String username, String password) {
		super();
		this.url = url;
		this.username = username;
		this.password = password;
	}

	public void connect() {
		System.out.println("You connected to " + url);
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
