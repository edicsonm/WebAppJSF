package au.com.edimoto.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity(name="Users")
public class Users implements Serializable {

	private static final long serialVersionUID = 5759948451762114452L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String username;

	@NotNull
	private String passwod;
	
	@ElementCollection
	@OneToMany(cascade=javax.persistence.CascadeType.ALL, mappedBy = "username")
	protected Set<UserRoles> userRoles = new HashSet<UserRoles>();

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPasswod() {
		return passwod;
	}

	public void setPasswod(String passwod) {
		this.passwod = passwod;
	}

	public Set<UserRoles> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(Set<UserRoles> userRoles) {
		this.userRoles = userRoles;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((username == null) ? 0 : username.hashCode());
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
		Users other = (Users) obj;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", passwod=" + passwod + "]";
	}

}
