package it.uniroma3.model;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import java.util.List;

@Stateless
public class SongFacade {
	
    @PersistenceContext(unitName = "music-unit")
    private EntityManager em;
    
	public Song createSong(String artistName,String name, String year) {
		Artist artist=null;
		Song song=null;
		
		Query query = em.createNamedQuery("Artist.findByName");
		query.setParameter("name",artistName);
		List<Artist> results=query.getResultList();
		
		if(!results.isEmpty()){
			artist = results.get(0);	
			song= new Song(name, year, artist);
			em.persist(song);
			return song; }
		
		return null;
	}
	
	public Song getSong(Long id) {
	    Song song = em.find(Song.class, id);
		return song;
	}
	
	public List<Song> getAllSong() {
		Query query= em.createNamedQuery("Song.findAll");
		List<Song> songs = query.getResultList();
		return songs;
	}

	public List<Song> getArtistSongs(String nameArtist) {
		Query query = this.em.createNamedQuery("findSongsByArtistName"); 
		query.setParameter("name", nameArtist);
		return query.getResultList();
	}
}