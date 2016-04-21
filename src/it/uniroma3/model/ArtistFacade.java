package it.uniroma3.model;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import java.util.List;

@Stateless
public class ArtistFacade {

	@PersistenceContext(unitName = "music-unit")
	private EntityManager em;

	public Artist createArtist(String name, String country){
		Artist a = new Artist(name, country);
		em.persist(a);
		return a;
	}

	public List<Artist> getAllArtist() {
		Query query = em.createNamedQuery("Artist.findAll");		
		return query.getResultList();
	}

	public void updateArtist(Artist a) {
		em.merge(a);
	}

	private void deleteArtist(Artist a) {
		em.remove(a);
	}

	public void deleteArtist(Long id) {
		Artist a = em.find(Artist.class, id);
		this.deleteArtist(a);
	}

}
