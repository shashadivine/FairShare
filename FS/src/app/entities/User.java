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

import org.hibernate.validator.constraints.Range;

@Entity
public class User
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private Long pk;
	
	@Column
	private String userName;
	
	@Column
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Item> itemsOwed = new HashSet<>();
	
	@Column
	@Range(min = 0)
	private Double costOwed;

	public Long getPk() {
		return pk;
	}

	public void setPk(Long pk) {
		this.pk = pk;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Set<Item> getItemsOwed() {
		return itemsOwed;
	}

	public void setItemsOwed(Set<Item> itemsOwed) {
		this.itemsOwed = itemsOwed;
	}
	
	// should be a function that adds only one item to the set
	// this is different compared to "setItems" which just overwrites the existing set and adds a new set of items
	public void addItem(Item item) {
		itemsOwed.add(item);
	}

	public Double getCostOwed() {
		return costOwed;
	}

	public void setCostOwed(Double costOwed) {
		this.costOwed = costOwed;
	}

	@Override
	public String toString() {
		return "User [pk=" + pk + ", userName=" + userName + ", itemsOwed=" + itemsOwed + ", costOwed=" + costOwed
				+ "]";
	}
}
