import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.entities.Receipt;
import app.repositories.ReceiptRepository;

public class Receipt{
    @Autowired
    ReceiptRepository repo;

    @PostConstruct
	public void doneInstantiating()
	{System.out.println(repo);}

    //Functions
    public Receipt createReceipt()
    {
        Receipt a = new Receipt();
        //will add stuff later
    }

    //add item
    //assign person
    //calculate cost

    //test
}