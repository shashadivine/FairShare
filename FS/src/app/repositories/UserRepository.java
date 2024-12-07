package app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.entities.Item;
import app.entities.User;

@Repository
public interface UserRepository 
				extends JpaRepository<User, Long>
{

	List<User> findByUserName(String userName);
	}
	

