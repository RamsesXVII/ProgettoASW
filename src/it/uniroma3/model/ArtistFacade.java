package it.uniroma3.model;


import javax.ejb.Stateless;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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

	public Artist getArtist(Long id) {
		Artist a= em.find(Artist.class, id);
		HttpSession session=getSession();
		session.setAttribute("searchedArtist", a);
		return a;
	}

	public Artist getArtistByName(String name) {
		Query query = this.em.createNamedQuery("Artist.findByName");
		query.setParameter("name", name);
		List<Artist> listArtist = query.getResultList();
		if(listArtist.size()!=0){
			return listArtist.get(0);
		}
		return null;
	}


	public List<Artist> getAllArtist() {
		Query query= em.createNamedQuery("Artist.findAll");
		List<Artist> artists = query.getResultList();
		return artists;
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

	public static HttpSession getSession(){
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest)context.getExternalContext().getRequest();
		HttpSession httpSession = request.getSession(false);
		return httpSession;
	}
}
