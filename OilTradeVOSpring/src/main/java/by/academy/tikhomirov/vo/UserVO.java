package by.academy.tikhomirov.vo;

import java.io.Serializable;
import java.util.Set;

public class UserVO implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer user_id;
	private String user_name;
	private String login;
	private String password;
	private String city;
	private String country;
	private String telephone;
	private Set<RoleVO> rolesVO;
	
	
	
	public UserVO() {
		
	}


	public UserVO(String user_name, String login, String password, String city, String country, String telephone) {
		this.user_name = user_name;
		this.login = login;
		this.password = password;
		this.city = city;
		this.country = country;
		this.telephone = telephone;
	}


	public String getUser_name() {
		return user_name;
	}

	
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	
	
	public Integer getUser_id() {
		return user_id;
	}

	
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	
	public String getLogin() {
		return login;
	}

	
	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	
	public void setPassword(String password) {
		this.password = password;
	}

	
	public String getCity() {
		return city;
	}

	
	public void setCity(String city) {
		this.city = city;
	}

	
	public String getCountry() {
		return country;
	}

	
	public void setCountry(String country) {
		this.country = country;
	}

	
	public String getTelephone() {
		return telephone;
	}

	
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	
	public Set<RoleVO> getRolesVO() {
		return rolesVO;
	}

	
	public void setRolesVO(Set<RoleVO> rolesVO) {
		this.rolesVO = rolesVO;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((rolesVO == null) ? 0 : rolesVO.hashCode());
		result = prime * result + ((telephone == null) ? 0 : telephone.hashCode());
		result = prime * result + ((user_id == null) ? 0 : user_id.hashCode());
		result = prime * result + ((user_name == null) ? 0 : user_name.hashCode());
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
		UserVO other = (UserVO) obj;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (rolesVO == null) {
			if (other.rolesVO != null)
				return false;
		} else if (!rolesVO.equals(other.rolesVO))
			return false;
		if (telephone == null) {
			if (other.telephone != null)
				return false;
		} else if (!telephone.equals(other.telephone))
			return false;
		if (user_id == null) {
			if (other.user_id != null)
				return false;
		} else if (!user_id.equals(other.user_id))
			return false;
		if (user_name == null) {
			if (other.user_name != null)
				return false;
		} else if (!user_name.equals(other.user_name))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "UserVO [user_id=" + user_id + ", user_name=" + user_name + ", login=" + login + ", password=" + password
				+ ", city=" + city + ", country=" + country + ", telephone=" + telephone + ", rolesVO=" + rolesVO + "]";
	}

	

	
	
	

	

}
