package com.khetra.buyer;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("buyers")
public class BuyerResource {
	
	BuyerRepository repo =new BuyerRepository();
	@GET
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
 public List<Buyer> getBuyers()
 {
		System.out.println("getBuyer called ...");
		return repo.getBuyers();	
 }
	@GET
	@Path("buyer/{U_ID}")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	
	public Buyer getBuyer(@PathParam("U_ID") int U_ID)
	{
		return repo.getBuyer(U_ID);
	} 
	@POST
	@Path("buyer")
	@Consumes({MediaType.APPLICATION_ATOM_XML,MediaType.APPLICATION_JSON})
	public Buyer createBuyer(Buyer a1){
		System.out.println(a1);
		repo.create(a1);
		return a1;
	}
	@PUT
	@Path("buyer")
	@Consumes({MediaType.APPLICATION_ATOM_XML,MediaType.APPLICATION_JSON})
	public Buyer updateBuyer(Buyer a1){
		System.out.println(a1);
		if(repo.getBuyer(a1.getU_ID()).getU_ID()==0)
		{
			repo.create(a1);
		}
		else{
			repo.update(a1);
		}
		return a1;
	}
	@DELETE
	@Path("buyer/{U_ID}")
	public Buyer killBuyer(@PathParam("U_ID") int U_ID){
		Buyer a=repo.getBuyer(U_ID);
	 if(a.getU_ID()!=0)
		 repo.delete(U_ID);	
	return a;
}
}
