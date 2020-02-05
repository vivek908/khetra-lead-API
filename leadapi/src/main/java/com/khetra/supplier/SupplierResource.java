package com.khetra.supplier;

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

@Path("suppliers")
public class SupplierResource {
	
	SupplierRepository repo =new SupplierRepository();
	@GET
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
 public List<Supplier> getSuppliers()
 {
		System.out.println("getSupplier called ...");
		return repo.getSuppliers();	
 }
	@GET
	@Path("supplier/{U_ID}")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	
	public Supplier getSupplier(@PathParam("U_ID") int U_ID)
	{
		return repo.getSupplier(U_ID);
	} 
	@POST
	@Path("supplier")
	@Consumes({MediaType.APPLICATION_ATOM_XML,MediaType.APPLICATION_JSON})
	public Supplier createSupplier(Supplier a1){
		System.out.println(a1);
		repo.create(a1);
		return a1;
	}
	@PUT
	@Path("supplier")
	@Consumes({MediaType.APPLICATION_ATOM_XML,MediaType.APPLICATION_JSON})
	public Supplier updateSupplier(Supplier a1){
		System.out.println(a1);
		if(repo.getSupplier(a1.getU_ID()).getU_ID()==0)
		{
			repo.create(a1);
		}
		else{
			repo.update(a1);
		}
		return a1;
	}
	@DELETE
	@Path("supplier/{U_ID}")
	public Supplier killSupplier(@PathParam("U_ID") int U_ID){
		Supplier a=repo.getSupplier(U_ID);
	 if(a.getU_ID()!=0)
		 repo.delete(U_ID);	
	return a;
}
}
