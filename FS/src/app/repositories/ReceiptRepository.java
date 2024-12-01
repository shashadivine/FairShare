package app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import app.entities.Receipt;

@Repository
public interface ReceiptRepository 
				extends JpaRepository<Receipt, Long>
{

}
