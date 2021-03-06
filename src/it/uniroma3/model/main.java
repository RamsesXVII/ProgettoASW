package it.uniroma3.model;

import java.util.*;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaQuery;
public class main {
	
	public static void main(String[] args) {
//		CustomerFacade cf = new CustomerFacade();
//		cf.createCustomer("paolo", "rossi", "paolo.rossi@yahoo.it", "password", "11/11/1992", "streeet", "citta", "stato", "zipcode", "country");
		EntityManagerFactory emf= Persistence.createEntityManagerFactory("music-unit");
		EntityManager em= emf.createEntityManager();
		EntityTransaction tx=em.getTransaction();
		tx.begin(); 
	//	ArtistFacade af= new ArtistFacade();
	//	af.createArtist("Queen", "UK");
	//	Query query = em.createNamedQuery("Artist.findByName");
	//	query.setParameter("name", "PinkFloyd");
	//	List<Artist> listArtist = query.getResultList();
		Query query = em.createNamedQuery("Artist.findByName");
		query.setParameter("name","PinkFloyd");
		Artist artist = (Artist) query.getResultList().get(0);
		Song s= new Song("ciao", "1960", artist);
		em.persist(s);
	//	List<Artist> listArtist = query.getResultList();
	//	Artist a=null;
	/*	Song s= null;
		if(listArtist.size()!=0){
			 a= listArtist.get(0);
			 s= new Song("Money", "1986", a);
			em.persist(s);
		} *(
		
		
		/*		Customer c=em.find(Customer.class, new Long(51));
		Order o= new Order();
		o.setCreationTime(new Date());
		o.setDataSpedizione(new Date());
		o.setCustomer(c);
		o.setStato("nonspedito");
		OrderLine ol= new OrderLine();
		ol.setProduct(em.find(Product.class, new Long(201)));
		ol.setQuantity(new Integer(2));
		ol.setUnitPrice(new Float(2));
		OrderLine oll= new OrderLine();
		oll.setProduct(em.find(Product.class, new Long(301)));
		oll.setQuantity(new Integer(3));
		oll.setUnitPrice(new Float(13));
		List<OrderLine>list= new LinkedList<OrderLine>();
		list.add(ol);
		list.add(oll);
		o.setOrderLines(list);
		em.persist(o);*/
		
//		Order c=em.find(Order.class, new Long(651));
//		em.remove(c);
//////		Query query=em.createNamedQuery("trovaOrdini");
//////		List<Order>l=query.getResultList();
		
//		em.find(Product.class, new Long(101)).setQuantity(new Integer(100));
//		em.find(Product.class, new Long(151)).setQuantity(new Integer(100));
//		em.find(Product.class, new Long(201)).setQuantity(new Integer(100));


		tx.commit();
		em.close();
		emf.close();
//		for(Order o:l)
//			System.out.println(o.getStato());
			
//			ProductFacade pf=new ProductFacade();
//			pf.createProduct(new Product("penna", "una Penna", new Float(2), "p1"));
//			pf.createProduct(new Product("cd", "un cd", new Float(3), "c1"));
//			pf.createProduct(new Product("astuccio", "un astuccio", new Float(13), "a1"));

		//	OrderFacade of= new OrderFacade();
		//	System.out.println(of.getOrderLines(new Long(201)).size());

//		OrderFacade of= new OrderFacade();
//		of.validateOrder(new Long(251));
	//	ProductFacade pf= new ProductFacade();
	//	System.out.println(pf.retriveAllProducts().size());
	//	OrderFacade of= new OrderFacade();
	//	System.out.println(of.retriveAllNoSentOrders());
		/*
		 * <!-- <?xml version="1.0" encoding="UTF-8"?>
<persistence version="2.0"
	xmlns="http://java.sun.com/xml/ns/persistence" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://java.sun.com/xml/ns/persistence http://java.sun.com/xml/ns/persistence/persistence_2_0.xsd">
	<persistence-unit name="music-unit"
		transaction-type="JTA">
		<provider>org.apache.openjpa.persistence.PersistenceProviderImpl</provider>
		<jta-data-source>PostgreSQL Database</jta-data-source>
		<!-- <non-jta-data-source>PostgreSQL Database</non-jta-data-source> -->
	<!--	<class>it.uniroma3.model.Artist</class>
		<class>it.uniroma3.model.Song</class>
		<properties>
			<property name="openjpa.jdbc.SynchronizeMappings" value="buildSchema(ForeignKeys=true)" />
		</properties>
	</persistence-unit>
</persistence> -->

		 */
	}
}
