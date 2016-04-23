package au.com.edimoto.entity;

import java.io.Serializable;

public class UserRoleKey implements Serializable {

	private static final long serialVersionUID = 6093200962672550523L;

	private String sSO;
	private String roleName;

	public UserRoleKey(){}
	
	public UserRoleKey(String sSO, String roleName){
		this.sSO = sSO;
		this.roleName = roleName;
	}

	public String getsSO() {
		return sSO;
	}

	public void setsSO(String sSO) {
		this.sSO = sSO;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((roleName == null) ? 0 : roleName.hashCode());
		result = prime * result + ((sSO == null) ? 0 : sSO.hashCode());
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
		UserRoleKey other = (UserRoleKey) obj;
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
		return true;
	}

		
}
