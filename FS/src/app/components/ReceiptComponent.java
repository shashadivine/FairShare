package app.components;

import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.entities.User;
import app.entities.Receipt;
import app.entities.Item;
import app.repositories.ReceiptRepository;

public class ReceiptComponent{
    @Autowired
    ReceiptRepository rRep;

    @PostConstruct
	public void doneInstantiating()
	{System.out.println(rRep);}

    //Functions
    public String createReceipt()
    {
        Receipt a = new Receipt();
        a.setItems();
        a.setUsers();
        rRep.save(a);
        Long pk = a.getPk();
		return pk;
        //return "hi";
    	// should return receiptPk
    }
    
    public String assignPerson(String receiptPk, String itemName, String userName, String quantity)
	{
    	return "hi";
		// should return assignedPerson Confirmation or Failure AND items left to assign 
	}
    
    public String addItem(String receiptPk, String itemName, String quantity)
	{
    	return "hi";
    	// should return addedItem Confirmation or Failure
	}
    
    public String calculateAndSend(String receiptPk)
   	{
    	return "hi";
    	// should return Sent Receipt Confirmation or Failure AND receipt summary
   	}

    //add item
    //assign person
    //calculate cost

    //test 
}