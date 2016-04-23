package au.com.edimoto.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@SuppressWarnings("unused")
@Entity
@NamedQuery(name = "User.listAllUsers", query = "Select U from User U order by U.sSO")
@Table(name="ADMIN_USER", catalog="WildflySecurity")
public class User implements Serializable {

	private static final long serialVersionUID = 1632841393131967767L;
	
	@Id
	@Column(name = "SSO", unique = true, nullable = false)
	private String sSO;
	
	@NotNull
	@Column(name="PASSWORD",length = 45)
	private String password;
	
	@NotNull
	@Column(name="FIRST_NAME",length = 45)
	private String firstName;
	
	@NotNull
	@Column(name="LAST_NAME",length = 45)
	private String lastName;
	
	@NotNull
	@Column(name="EMAIL",length = 45)
	private String email;
	
	//@NotNull()
	@Column(name="STATE",length = 45)
	private String state;
	
	/*Relacion unidireccional*/
	/*@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="sSOUser",referencedColumnName="sSO")*/
	
	/*Relacion Bidireccional*/
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	protected Set<UserRole> userRoles = new HashSet<UserRole>();
	
	
	/*Relacion Unidireccional*/
	/*@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "sSOParent", referencedColumnName = "sSO")
	private Set<Test> tests  = new HashSet<Test>(0);*/
	
	public User(){}
	
	public User(String sSO, String password, String firstName, String lastName, String email){
		this.sSO = sSO;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public String getsSO() {
		return sSO;
	}

	public void setsSO(String sSO) {
		this.sSO = sSO;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((sSO == null) ? 0 : sSO.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
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
		
		User other = (User) obj;
		if (sSO == null) {
			if (other.sSO != null)
				return false;
		} else if (!sSO.equalsIgnoreCase(other.sSO))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [sSO=" + sSO + ", password=" + password + ", firstName=" + firstName + ", lastName="
				+ lastName + ", email=" + email + ", state=" + state + "]";
	}

	/*public Set<Test> getTests() {
		return tests;
	}

	public void setTests(Set<Test> tests) {
		this.tests = tests;
	}*/

	public Set<UserRole> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(Set<UserRole> userRoles) {
		this.userRoles = userRoles;
	}

}
