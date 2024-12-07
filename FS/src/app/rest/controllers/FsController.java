package app.rest.controllers;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.components.UserComponent;
import app.components.UserInitializer;
import okhttp3.ResponseBody;
import retrofit2.Response;
import app.components.MotdComponent;
import app.components.RetrofitTesterComponent;
import app.components.TwilioComponent;

@Component
@Path("/fsController")
public class FsController
{
	// add components here
	@Autowired
	CreateReceipt cR; //change depending on matt's receipt component name
	
	@Autowired
	AddItem aI;
	
	@Autowired
	AssignPerson aP;
	
	@Autowired
	CalculateCost cC;
	
	Logger logger = LoggerFactory.getLogger(FsController.class);
	
	// ENTER ITEM ON RECEIPT (one at a time)
	@GET
	@Path("/addItemToReceipt")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public String addItemToReceipt(@QueryParam("itemName") String itemName, @QueryParam("quantity") String quantity) throws Exception
	{
		return aI.addItem(itemName, quantity);
		// returns addedItem Confirmation or Failure
	}
	
	// ASSIGN PERSON
	@GET
	@Path("/assignPersonToItem")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public String assignPersonToItem(@QueryParam("itemName") String itemName, @QueryParam("user") String user, @QueryParam("quantity") String quantity) throws Exception
	{
		return aP.assignPerson(itemName, user);
		// returns assignedPerson Confirmation or Failure AND items left to assign
	}
	
	// CALCULATE AND SEND RECEIPTS
	@GET
	@Path("/assignPersonToItem")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public String assignPersonToItem(@QueryParam("itemName") String itemName, @QueryParam("user") String user, @QueryParam("quantity") String quantity) throws Exception
	{
		return aP.assignPerson(itemName, user);
		// returns assignedPerson Confirmation or Failure AND items left to assign
	}
	
}