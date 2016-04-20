package it.uniroma3.controller;

import java.util.List;

import it.uniroma3.model.Artist;
import it.uniroma3.model.ArtistFacade;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.servlet.http.*;


@ManagedBean
public class ArtistController {

	@ManagedProperty(value="#{param.id}")
	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	private List<Artist> artists;
	private Artist artist;

	@EJB
	private ArtistFacade artistFacade;

	public String createArtist(){
		this.artist=artistFacade.createCustomer(firstName, lastName, email);
		return "customer";
	}

	public String listCustomers() {
		this.customers = customerFacade.getAllCustomer();
		return "customers"; 
	}

	public String findCustomer() {
		this.customer = customerFacade.getCustomer(id);
		return "customerDetails";
	}

	public static HttpSession getSession(){
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest)context.getExternalContext().getRequest();
		HttpSession httpSession = request.getSession(false);
		return httpSession;
	}

	public String findCustomer(Long id) {
		customerFacade.getCustomer(id);
		return "customer";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	public CustomerFacade getCustomerFacade() {
		return customerFacade;
	}

	public void setCustomerFacade(CustomerFacade customerFacade) {
		this.customerFacade = customerFacade;
	}
	
	public String log(){
		return "login";
	}

}


