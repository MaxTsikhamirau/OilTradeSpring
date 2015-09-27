package by.academy.tikhomirov.vo;

import java.io.Serializable;

public class OfferVO implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer offer_id;
	private Integer quantity;
	private Integer price;
	private SortVO sortVO;
	private UserVO userVO;
	public OfferVO(Integer offer_id, Integer quantity, Integer price) {
		super();
		this.offer_id = offer_id;
		this.quantity = quantity;
		this.price = price;
	}
	public OfferVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @return the offer_id
	 */
	public Integer getOffer_id() {
		return offer_id;
	}
	/**
	 * @param offer_id the offer_id to set
	 */
	public void setOffer_id(Integer offer_id) {
		this.offer_id = offer_id;
	}
	/**
	 * @return the quantity
	 */
	public Integer getQuantity() {
		return quantity;
	}
	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	/**
	 * @return the price
	 */
	public Integer getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(Integer price) {
		this.price = price;
	}
	/**
	 * @return the sortVO
	 */
	public SortVO getSortVO() {
		return sortVO;
	}
	/**
	 * @param sortVO the sortVO to set
	 */
	public void setSortVO(SortVO sortVO) {
		this.sortVO = sortVO;
	}
	/**
	 * @return the userVO
	 */
	public UserVO getUserVO() {
		return userVO;
	}
	/**
	 * @param userVO the userVO to set
	 */
	public void setUserVO(UserVO userVO) {
		this.userVO = userVO;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((offer_id == null) ? 0 : offer_id.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((quantity == null) ? 0 : quantity.hashCode());
		result = prime * result + ((sortVO == null) ? 0 : sortVO.hashCode());
		result = prime * result + ((userVO == null) ? 0 : userVO.hashCode());
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OfferVO other = (OfferVO) obj;
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
		if (sortVO == null) {
			if (other.sortVO != null)
				return false;
		} else if (!sortVO.equals(other.sortVO))
			return false;
		if (userVO == null) {
			if (other.userVO != null)
				return false;
		} else if (!userVO.equals(other.userVO))
			return false;
		return true;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "OfferVO [offer_id=" + offer_id + ", quantity=" + quantity + ", price=" + price + ", sortVO=" + sortVO
				+ ", userVO=" + userVO + "]";
	}

	

}
