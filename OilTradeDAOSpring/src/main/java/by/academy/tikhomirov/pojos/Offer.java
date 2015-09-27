package by.academy.tikhomirov.pojos;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "`offer`")
public class Offer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "offer_id")
	private Integer offer_id;

	@Column(name = "quantity")
	private Integer quantity;

	@Column(name = "price")
	private Integer price;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "sort_id")
	private Sort sort;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private User user;

	public Offer() {

	}

	public Offer(Integer quantity, Integer price) {
		this.quantity = quantity;
		this.price = price;
	}

	public Offer(Integer quantity, Integer price, Sort sort, User user) {
		this.quantity = quantity;
		this.price = price;
		this.sort = sort;
		this.user = user;
	}

	public Integer getOffer_id() {
		return offer_id;
	}

	public void setOffer_id(Integer offer_id) {
		this.offer_id = offer_id;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Sort getSort() {
		return sort;
	}

	public void setSort(Sort sort) {
		this.sort = sort;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((offer_id == null) ? 0 : offer_id.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((quantity == null) ? 0 : quantity.hashCode());
		result = prime * result + ((sort == null) ? 0 : sort.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Offer other = (Offer) obj;
		if (offer_id == null) {
			if (other.offer_id != null)
				return false;
		} else if (!offer_id.equals(other.offer_id))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (quantity == null) {
			if (other.quantity != null)
				return false;
		} else if (!quantity.equals(other.quantity))
			return false;
		if (sort == null) {
			if (other.sort != null)
				return false;
		} else if (!sort.equals(other.sort))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Offer [offer_id=" + offer_id + ", quantity=" + quantity + ", price=" + price + "]";
	}
}
