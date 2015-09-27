package by.academy.tikhomirov.vo;

import java.io.Serializable;

public class RoleVO implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer role_id;
	private String role_name;
	public RoleVO( String role_name) {
			this.role_name = role_name;
	}
	public RoleVO() {
		
	}
	
	public Integer getRole_id() {
		return role_id;
	}
	
	public void setRole_id(Integer role_id) {
		this.role_id = role_id;
	}
	
	public String getRole_name() {
		return role_name;
	}
	
	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((role_id == null) ? 0 : role_id.hashCode());
		result = prime * result + ((role_name == null) ? 0 : role_name.hashCode());
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
		RoleVO other = (RoleVO) obj;
		if (role_id == null) {
			if (other.role_id != null)
				return false;
		} else if (!role_id.equals(other.role_id))
			return false;
		if (role_name == null) {
			if (other.role_name != null)
				return false;
		} else if (!role_name.equals(other.role_name))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "RoleVO [role_name=" + role_name + "]";
	}
	
	

}
