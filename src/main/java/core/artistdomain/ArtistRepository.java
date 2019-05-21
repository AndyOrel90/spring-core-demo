package core.artistdomain;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import core.Connection;

@Repository
public class ArtistRepository {
	@Autowired @Qualifier("awsConnection")
	private Connection connection;
	private List<Artist> artists;

	public ArtistRepository() {
		artists = new ArrayList<>();
		artists.add(new Artist(1, "Bon Jovi"));
		artists.add(new Artist(2, "T Pain"));
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}
	
	public List<Artist> getAll() {
		connection.connect();
		return artists;
	}
}
