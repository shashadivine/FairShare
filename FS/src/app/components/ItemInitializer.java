package app.components;

import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.entities.Item;
import app.repositories.ItemRepository;

@Component
public class ItemInitializer {

	@Autowired
	private ItemRepository iRep;
	
	@PostConstruct
	public void init() throws IOException
	{
		if (iRep.count()==0)
		{
			Item a = new Item();
			a.setItemName("French Fries");
			a.setDescription("Fresh and Salty");
			a.setPrice(50.0);
			a = iRep.save(a);
			
			Item b = new Item();
			b.setItemName("Cheeseburger");
			b.setDescription("Yummy and Just Right");
			b.setPrice(65.0);
			b = iRep.save(b);
			
			Item c = new Item();
			c.setItemName("Chicken Nuggets");
			c.setDescription("Crispy and Tender");
			c.setPrice(80.0);
			c = iRep.save(c);

			Item d = new Item();
			d.setItemName("Chocolate Milkshake");
			d.setDescription("Creamy and Sweet");
			d.setPrice(60.0);
			d = iRep.save(d);

			Item e = new Item();
			e.setItemName("Veggie Wrap");
			e.setDescription("Fresh and Healthy");
			e.setPrice(70.0);
			e = iRep.save(e);

			Item f = new Item();
			f.setItemName("Grilled Cheese Sandwich");
			f.setDescription("Warm and Gooey");
			f.setPrice(55.0);
			f = iRep.save(f);

			Item g = new Item();
			g.setItemName("Caesar Salad");
			g.setDescription("Crisp and Savory");
			g.setPrice(90.0);
			g = iRep.save(g);

			Item h = new Item();
			h.setItemName("Spaghetti Bolognese");
			h.setDescription("Rich and Flavorful");
			h.setPrice(120.0);
			h = iRep.save(h);

			Item i = new Item();
			i.setItemName("Apple Pie");
			i.setDescription("Sweet and Tart");
			i.setPrice(40.0);
			i = iRep.save(i);

			Item j = new Item();
			j.setItemName("Chicken Wings");
			j.setDescription("Spicy and Juicy");
			j.setPrice(100.0);
			j = iRep.save(j);

		}
		else
		{
			List<Item> list = iRep.findAll();
			System.out.println(list);
		}
	}
}