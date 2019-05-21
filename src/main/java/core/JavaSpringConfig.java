package core;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import core.artistdomain.ArtistRepository;

//@Configuration
public class JavaSpringConfig {
	@Bean(name="localConnection")
	public Connection getLocalConnection() {
		return new Connection("localhost", "admin", "admin");
	}
	
	@Bean(name="localArtistRepository")
	public ArtistRepository getlocalArtistRepository(@Qualifier("localConnection") Connection conn) {
		//Connection conn = new Connection("localhost", "admin", "admin");
		ArtistRepository local = new ArtistRepository();
		local.setConnection(conn);
		return local;
	}
}
