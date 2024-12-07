package app.entities;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity
public class Receipt
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	@NotNull
	private Long pk;
	
	@Column
	@OneToMany(mappedBy = "receipt", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Item> items = new HashSet<>();
	
	@Column
	@OneToMany(mappedBy = "receipt", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<User> users = new HashSet<>();

	public Long getPk() {
		return pk;
	}

	public void setPk(Long pk) {
		this.pk = pk;
	}

	public Set<Item> getItems() {
		return items;
	}

	public void setItems(Set<Item> items) {
		this.items = items;
	}
	
	// should be a function that adds only one item to the set
	// this is different compared to "setItems" which just overwrites the existing set and adds a new set of items
	public void addItem(Set<Item> item) {
		this.items = item; // will edit later
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}
	
	// should be a function that adds only one user to the set
	// this is different compared to "setUsers" which just overwrites the existing set and adds a new set of users
		public void addUser(Set<User> user) {
			this.users = user; // will edit later
		}

	@Override
	public String toString() {
		return "Receipt [pk=" + pk + ", items=" + items + ", users=" + users + "]";
	}
}
