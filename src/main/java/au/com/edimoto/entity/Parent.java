package au.com.edimoto.entity;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Parent
 *
 */
@Entity
@Table(name = "parent", catalog = "TEST")
public class Parent implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDENT", unique = true, nullable = false)
	private Integer ident;
	
	@Column(name = "NOMBRE", length = 45)
	private String nombre;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "IDPARENT", referencedColumnName = "IDENT", nullable=false)
	private Set<Child> childs = new HashSet<Child>(0);
	
	private static final long serialVersionUID = 1L;

	public Parent() {
		super();
	}
	
	public Integer getIdent() {
		return this.ident;
	}

	public void setIdent(Integer ident) {
		this.ident = ident;
	}   
	
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}   
	
	public Set<Child> getChilds() {
		return this.childs;
	}

	public void setChilds(Set<Child> childs) {
		this.childs = childs;
	}

	@Override
	public String toString() {
		return "Parent [ident=" + ident + ", nombre=" + nombre + ", childs=" + childs + "]";
	}
   
}
