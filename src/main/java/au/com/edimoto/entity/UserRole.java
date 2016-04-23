package au.com.edimoto.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: UserRole
 *
 */
@Entity
@IdClass(value = UserRoleKey.class)
@Table(name = "ADMIN_USER_ROLE", catalog = "WildflySecurity", 
		uniqueConstraints = {@UniqueConstraint(columnNames = {"SSO","ROLE"})}
		)
public class UserRole implements Serializable {

	@Id
	@Column(name="SSO", unique= false)
	private String sSO;

	@Id
	@Column(name="ROLE",unique= false)
	private String roleName;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SSO", nullable = true, insertable=false, updatable=false)
	private User user;
	
	/*@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "sSO", nullable = true, insertable=false, updatable=false)
	private Role role;*/
	
	private static final long serialVersionUID = 1L;

	public UserRole() {}

	public UserRole(String sSO, String roleName) {
		this.sSO = sSO;
		this.roleName = roleName;
	}

	public String getsSO() {
		return sSO;
	}

	public void setsSO(String sSO) {
		this.sSO = sSO;
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
		result = prime * result + ((roleName == null) ? 0 : roleName.hashCode());
		result = prime * result + ((sSO == null) ? 0 : sSO.hashCode());
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
		UserRole other = (UserRole) obj;
		if (roleName == null) {
			if (other.roleName != null)
				return false;
		} else if (!roleName.equals(other.roleName))
			return false;
		if (sSO == null) {
			if (other.sSO != null)
				return false;
		} else if (!sSO.equals(other.sSO))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	

}
