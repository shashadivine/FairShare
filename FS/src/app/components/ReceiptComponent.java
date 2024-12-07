package app.components;

import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;

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
    	// find the item object with their itemName
    	List<Item> selectedItem = iRep.findByName(itemName);
    	Item item = selectedItem.get(0);
    	
    	// find receipt object with their receiptPk
    	List<Receipt> selectedReceipt = rRep.findByPk(receiptPk);
    	Receipt receipt = selectedReceipt.get(0);
    	
    	
    	// get set of items from receipt
    	Set<Item> itemsFromReceipt = receipt.getItems();
    	
    	
    	User u = null;
    	// Check if item given match with items in receipt
    	if (itemsFromReceipt.contains(item)) {
    		
    		// Create user and add item to their itemsOwed
    		u.setUserName(userName);
    		
    		// add Item details in the receipt
        	int quanInt = Integer.parseInt(quantity);
        	
        	// adds item multiple times depending on the quantity
        	for (int i = 0; i < quanInt; i++) {
        		u.addItem(item);
        	}
        	u = uRep.save(u);
    	}
    	int itemsOwedByUser = u.getItemsOwed().size();
    	
    	if (itemsOwedByUser >= 1) {
    		return "Successfully added and assigned user items owed";
    	}
    	
    	else {
    		return "Items not successfully added";
    	}
	}
    
    public String calculateAndSend(String receiptPk)
   	{
		//commenting so nothing breaks due to VScode dependencies.
    	// find receipt object with their receiptPk
    	List<Receipt> selectedReceipt = rRep.findByPk(receiptPk);
    	Receipt receipt = selectedReceipt.get(0);
    	
    	//a = rRep.findByPk(receiptPk)
    	//b = a.getUsers() 
    	//for each user in b, calculate how much each owes then print their cost
    	
    	 return userCosts;
		//a = rRep.findByPk(receiptPk)
		//b = a.getUsers() 
		//for each user in b, calculate how much each owes then print their cost
		//for (User i : b) {
		//c=i.getItemsOwed()
		//double cost=0.0
		//for (Item j : c){
		//d=j.getPrice()
		//cost=cost+d}
		//System.out.println("Name: "+ i.name + "; Amount owed:" + cost)
		//}
    	return "hi";
    	// should return Sent Receipt Confirmation or Failure AND receipt summary
   	}

    //add item
    //assign person
    //calculate cost

    //test 
}