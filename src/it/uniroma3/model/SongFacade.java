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
		Query query = em.createNamedQuery("Artist.findByName");
		query.setParameter("name",artistName);
		Artist artist = (Artist) query.getResultList().get(0);
		
		Song s= new Song(name, year, artist);
		em.persist(s);
		return s;
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


	public void updateSong(Song song) {
        em.merge(song);
	}
	
    private void deleteSong(Song song) {
        em.remove(song);
    }

	public void deleteProduct(Long id) {
        Song song = em.find(Song.class, id);
        deleteSong(song);
	}

	public void createSong(Song s) {
		em.persist(s);
	}

	public List<Artist> getAllArtist() {
		Query query = em.createNamedQuery("Artist.findAll");		
		return query.getResultList();
	}


	public List<Song> getArtistSongs(String nameArtist) {
		Query query = this.em.createNamedQuery("findSongsByArtistName"); 
		query.setParameter("name", nameArtist);
		return query.getResultList();
	}


}