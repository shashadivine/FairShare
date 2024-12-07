package app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.entities.Item;
import app.entities.Receipt;

@Repository
public interface ReceiptRepository 
				extends JpaRepository<Receipt, Long>
{
	List<Receipt> findByPk(String pk);
}
