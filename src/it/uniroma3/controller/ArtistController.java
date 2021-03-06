package it.uniroma3.controller;

import java.util.List;

import it.uniroma3.model.Artist;
import it.uniroma3.model.ArtistFacade;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

@ManagedBean
public class ArtistController {

	@ManagedProperty(value="#{param.id}")
	private Long id;
	private String name;
	private String country;
	private List<Artist> artists;
	private Artist artist;

	@EJB
	private ArtistFacade artistFacade;

	public String createArtist(){
		this.artist=artistFacade.createArtist(name, country);
		return "insertionStatus";
	}

	public String listArtists() {
		this.artists=artistFacade.getAllArtist();
		return "artists"; 
	}

	//getters and setters
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public List<Artist> getArtists() {
		return artists;
	}

	public void setArtists(List<Artist> artists) {
		this.artists = artists; 
	}

	public Artist getArtist() {
		return artist; 
	}

	public void setArtist(Artist artist) {
		this.artist = artist; 
	}

	public ArtistFacade getArtistFacade() {
		return artistFacade; 
	}

	public void setArtistFacade(ArtistFacade artistFacade) {
		this.artistFacade = artistFacade;
	}
}


