package it.uniroma3.controller;

import java.util.List;

import it.uniroma3.model.Artist;
import it.uniroma3.model.ArtistFacade;
import it.uniroma3.model.SongFacade;
import it.uniroma3.model.Song;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

@ManagedBean
public class SongController {

	@ManagedProperty(value="#{param.nameArtist}")
	private String nameArtist;
	private Long id;
	private String name;
	private String year;
	private Song song;
	private List<Song> songs;
	private List<Artist> artists;

	@EJB
	private SongFacade songFacade;
	@EJB
	private ArtistFacade artistFacade;

	public String createSong() {
		this.song = songFacade.createSong(nameArtist, name, year);
		return "insertionStatus"; 
	}

	public String listSongs() {
		this.songs = songFacade.getAllSong();
		return "songs"; 
	}
	
	public String listArtistSongs(){
		this.songs=songFacade.getArtistSongs(nameArtist);
		return "songs";
	}
	
	public String selectArtist(){
		return "songInsertion";
	}
	
	public String listArtists() {
		this.artists=artistFacade.getAllArtist();
		return "newSong"; 
	}

	//getters and setters

	public Long getId() {
		return id;
	}

	public List<Artist> getArtists() {
		return artists;
	}

	public void setArtists(List<Artist> artists) {
		this.artists = artists;
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

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getNameArtist() {
		return nameArtist;
	}

	public void setNameArtist(String nameArtist) {
		this.nameArtist = nameArtist;
	}

	public Song getSong() {
		return song;
	}

	public void setSong(Song song) {
		this.song = song;
	}

	public List<Song> getSongs() {
		return songs;
	}

	public void setSongs(List<Song> songs) {
		this.songs = songs;
	}

	public SongFacade getSongFacade() {
		return songFacade;
	}

	public void setSongFacade(SongFacade songFacade) {
		this.songFacade = songFacade;
	}

	public ArtistFacade getArtistFacade() {
		return artistFacade;
	}

	public void setArtistFacade(ArtistFacade artistFacade) {
		this.artistFacade = artistFacade;
	}
	
}



