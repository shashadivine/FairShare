package app.rest.controllers;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



import okhttp3.ResponseBody;
import retrofit2.Response;
import app.components.ReceiptComponent;
@Component
@Path("/fsController")
public class FsController
{
	// add components here
	ReceiptComponent re;
	
	Logger logger = LoggerFactory.getLogger(FsController.class);
	
	// Create Receipt
	@GET
	@Path("/createReceipt")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public String createReceipt() throws Exception
	{
		return re.createReceipt();
		// returns receiptPk
	}
	
	// ENTER ITEM ON RECEIPT (one at a time)
	@GET
	@Path("/addItemToReceipt")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public String addItemToReceipt(@QueryParam("receiptPk") String receiptPk, @QueryParam("itemName") String itemName, @QueryParam("quantity") String quantity) throws Exception
	{
		return re.addItem(receiptPk, itemName, quantity);
		// returns addedItem Confirmation or Failure
	}
	
	// ASSIGN PERSON
	@GET
	@Path("/assignPersonToItem")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public String assignPersonToItem(@QueryParam("receiptPk") String receiptPk, @QueryParam("itemName") String itemName, @QueryParam("user") String user, @QueryParam("quantity") String quantity) throws Exception
	{
		return re.assignPerson(receiptPk, itemName, user, quantity);
		// returns assignedPerson Confirmation or Failure AND items left to assign
	}
	
	// CALCULATE AND SEND RECEIPTS
	@GET
	@Path("/sendReceipts")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public String sendReceipts(@QueryParam("receiptPk") String receiptPk) throws Exception
	{
		return re.calculateAndSend(receiptPk);
		// returns Sent Receipt Confirmation or Failure AND receipt summary
	}
	
}