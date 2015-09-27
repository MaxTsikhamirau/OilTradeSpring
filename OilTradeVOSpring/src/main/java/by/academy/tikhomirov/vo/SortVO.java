package by.academy.tikhomirov.vo;

import java.io.Serializable;


public class SortVO implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer sort_id;
	private String sort_name;
//	private Set<OrderVO> ordersVO;
//	private Set<UserVO> usersVO;
	public SortVO(Integer sort_id, String sort_name) {
		super();
		this.sort_id = sort_id;
		this.sort_name = sort_name;
	}
	public SortVO() {
		
	}
	/**
	 * @return the sort_id
	 */
	public Integer getSort_id() {
		return sort_id;
	}
	/**
	 * @param sort_id the sort_id to set
	 */
	public void setSort_id(Integer sort_id) {
		this.sort_id = sort_id;
	}
	/**
	 * @return the sort_name
	 */
	public String getSort_name() {
		return sort_name;
	}
	/**
	 * @param sort_name the sort_name to set
	 */
	public void setSort_name(String sort_name) {
		this.sort_name = sort_name;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((sort_id == null) ? 0 : sort_id.hashCode());
		result = prime * result + ((sort_name == null) ? 0 : sort_name.hashCode());
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
		SortVO other = (SortVO) obj;
		if (sort_id == null) {
			if (other.sort_id != null)
				return false;
		} else if (!sort_id.equals(other.sort_id))
			return false;
		if (sort_name == null) {
			if (other.sort_name != null)
				return false;
		} else if (!sort_name.equals(other.sort_name))
			return false;
		return true;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SortVO [sort_id=" + sort_id + ", sort_name=" + sort_name + "]";
	}
	
	
	

}
