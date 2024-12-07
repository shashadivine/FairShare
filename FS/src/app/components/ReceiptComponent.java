package app.components;

import java.util.List;

import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.entities.User;
import app.entities.Receipt;
import app.entities.Item;
import app.repositories.UserRepository;
import app.repositories.ReceiptRepository;
import app.repositories.ItemRepository;

public class ReceiptComponent{
    
	@Autowired
    UserRepository uRep;
	
	@Autowired
    ReceiptRepository rRep;
	
	@Autowired
    ItemRepository iRep;

    @PostConstruct
	public void doneInstantiating()
	{System.out.println(rRep);}

    //Functions
    public String createReceipt()
    {
        Receipt a = new Receipt();
        a.setItems(null);
        a.setUsers(null);
        rRep.save(a);
        Long pk = a.getPk();
		return pk.toString();
        //return "hi";
    	// should return receiptPk
    }
    
    public String addItem(String receiptPk, String itemName, String quantity)
	{
    	// find the item object with their itemName
    	List<Item> selectedItem = iRep.findByName(itemName);
    	Item item = selectedItem.get(0);
    	
    	// find receipt object with their receiptPk
    	List<Receipt> selectedReceipt = rRep.findByPk(receiptPk);
    	Receipt receipt = selectedReceipt.get(0);
    	int itemsBeforeCode = receipt.getItems().size();
    	
    	// add Item details in the receipt
    	int quanInt = Integer.parseInt(quantity);
    	// adds item multiple times depending on the quantity
    	for (int i = 0; i < quanInt; i++) {
    		receipt.addItem(item);
        	rRep.save(receipt);
    	}
    	int itemsAfterCode = receipt.getItems().size();
    	
    	if (itemsAfterCode - itemsBeforeCode == quanInt) {
    		return "Items added successfully";
    	}
    	
    	else if (itemsAfterCode > itemsBeforeCode) {
    		return "Some items added successfully";
    	}
    	
    	else {
    		return "Items did not successfully add";
    	}
    	// should return addedItem Confirmation or Failure
	}
    
    public String assignPerson(String receiptPk, String itemName, String userName, String quantity)
	{
    	return "hi";
		// should return assignedPerson Confirmation or Failure AND items left to assign 
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