package app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import app.entities.Item;

@Repository
public interface ItemRepository 
				extends JpaRepository<Item, Long>
{

}
