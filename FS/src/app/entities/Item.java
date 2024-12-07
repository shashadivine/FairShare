package app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;

@Entity
public class Item
{
	@ManyToOne
    @JoinColumn(name = "receipt_id")
    private Receipt receipt;
	
	@ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private Long pk;
	
	@Column
	@NotNull
	private String itemName;
	
	@Column
	@NotNull
	private String description;
	
	@Column
	@NotNull
	@Range(min = 0)
	private Double price;

	public Long getPk() {
		return pk;
	}

	public void setPk(Long pk) {
		this.pk = pk;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Item [pk=" + pk + ", itemName=" + itemName + ", description=" + description + ", price=" + price + "]";
	}
}
