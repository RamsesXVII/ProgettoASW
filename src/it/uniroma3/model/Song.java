package it.uniroma3.model;


import javax.persistence.*;

@Entity
@Table(name="songs")
@NamedQueries({
	@NamedQuery(name= "Song.findAll", query="SELECT s FROM Song s"),
	@NamedQuery(name= "Song.findById", query="SELECT s FROM Song s WHERE s.id=:id"),
	@NamedQuery(name= "findSongsByArtistId", query="SELECT s FROM Song s Where s.artist.id= :id"),
})

public class Song {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Column(nullable=false)
	private String name;
	@Column(nullable=false)
	private String year;
	@ManyToOne
	private Artist artist;

	public Song(){
		
	}

	public Song(String name, String year, Artist artist) {
		this.name=name;
		this.year=year;
		this.artist=artist;
	}

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

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public Artist getArtist() {
		return artist;
	}

	public void setArtist(Artist artist) {
		this.artist = artist;
	}

	@Override
	public String toString(){
		   final StringBuilder sb = new StringBuilder();
	        sb.append("Song"); 
	        sb.append("{id=").append(id);
	        sb.append(", artist='").append(this.artist.getName()); 
	        sb.append("}\n");
	        return sb.toString();
	}
	
}
