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
		ArtistFacade af= new ArtistFacade();
		Artist artist=af.getArtistByName(artistName);
		Song s= new Song(name, year, artist);
	
		em.persist(s);
		return s;
	}
	
	public Song getOrder(Long id) {
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

	
	public List<Song> getSongsByArtistId(Long id){
		Query query = this.em.createNamedQuery("findSongsByArtistId");  //se è interrogazione molto rilevante per il dominio  usata spesso
		query.setParameter("id", new Long(id));
		return query.getResultList();
	}


}