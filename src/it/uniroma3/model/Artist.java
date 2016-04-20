package it.uniroma3.model;

import java.util.List;
import javax.persistence.*;

@Entity
@NamedQueries({
	@NamedQuery(name="Artist.findAll", query="SELECT a FROM Artist a"),
    @NamedQuery(name="Artist.findByName",
                query="SELECT a FROM Artist a WHERE a.name= :name")
}) 
public class Artist {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;
	@Column(nullable=false)
	private String name;
	@Column(nullable=false)
	private String country;
//	@OneToOne(cascade={CascadeType.PERSIST,CascadeType.REMOVE},fetch=FetchType.LAZY) se non voglio caricare indirizzi
//	@OneToMany(mappedBy="customer",fetch=FetchType.EAGER)
	@OneToMany(mappedBy="artist")
	private List<Song> song;
	
	public Artist(){
	}
	
	public Artist(String name, String country) {
		this.name=name;
		this.country = country;
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

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public List<Song> getSong() {
		return song;
	}

	public void setSong(List<Song> song) {
		this.song = song;
	}
	
	
	public String toString(){
		   final StringBuilder sb = new StringBuilder();
	        sb.append("Artist"); 
	        sb.append("{id=").append(id); 
	        sb.append(", name='").append(this.name); 
	        sb.append(", country='").append(this.country);  
	        sb.append("}\n");
	        return sb.toString();
	}

}
