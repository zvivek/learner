package com.vivek.RestAPI;

import java.util.Arrays;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("customers")
public class CustomerResources {
	
	CustomerRepoistry repo=new CustomerRepoistry();
	@GET
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public List<Customer> getCustomer(){
		
	/*Customer c1=new Customer();
	c1.setCustomerId(1);
	c1.setName("Vivek Singh");
	Customer c2=new Customer(); 
	c2.setCustomerId(1);
	c2.setName("Singh");
	List<Customer> cust=Arrays.asList(c1,c2); 
	return cust;*/
		return repo.getCustomers();

}
	
	@GET
	@Path("customer/{CustomerId}")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Customer getCust(@PathParam("CustomerId") int CustomerId){
		
		return repo.getCustomer(CustomerId);

}
	@POST
	@Path("customer")
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Customer cretaeCustomer(Customer c1){
		System.out.println(c1);
		repo.create(c1);
		return c1;
	}
}
