package com.khetra.lms;

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

@Path("leads")
public class LeadResource {
	
	LeadRepository repo =new LeadRepository();
	@GET
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
 public List<Lead> getLeads()
 {
		System.out.println("getLead called ...");
		return repo.getLeads();	
 }
	@GET
	@Path("lead/{id}")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	
	public Lead getLead(@PathParam("id") int id)
	{
		return repo.getLead(id);
	} 
	@POST
	@Path("lead")
	@Consumes({MediaType.APPLICATION_ATOM_XML,MediaType.APPLICATION_JSON})
	public Lead createLead(Lead a1){
		System.out.println(a1);
		repo.create(a1);
		return a1;
	}
	@PUT
	@Path("lead")
	@Consumes({MediaType.APPLICATION_ATOM_XML,MediaType.APPLICATION_JSON})
	public Lead updateLead(Lead a1){
		System.out.println(a1);
		if(repo.getLead(a1.getId()).getId()==0)
		{
			repo.create(a1);
		}
		else{
			repo.update(a1);
		}
		return a1;
	}
	@DELETE
	@Path("lead/{id}")
	public Lead killLead(@PathParam("id") int id){
	 Lead a=repo.getLead(id);
	 if(a.getId()!=0)
		 repo.delete(id);	
	return a;
}
}
