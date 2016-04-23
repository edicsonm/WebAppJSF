package au.com.edimoto.entity;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Entity implementation class for Entity: Child
 *
 */
@Entity
@Table(name = "child", catalog = "TEST")
public class Child implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDENTCHILD", unique = true, nullable = false)
	private Integer ident;
	
	/*@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IDPARENT", nullable = false)
	private Parent parent;*/
	
	@NotNull
	@Column(name = "NOMBRE", length = 45)
	private String nombre;
	
	
	private static final long serialVersionUID = 1L;

	public Child() {
		super();
	}
	
	public Integer getIdent() {
		return this.ident;
	}

	public void setIdent(Integer ident) {
		this.ident = ident;
	}
	
	/*public Parent getParent() {
		return parent;
	}
	
	public void setParent(Parent parent) {
		this.parent = parent;
	}*/
	
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/*@Override
	public String toString() {
		return "Child [ident=" + ident + ", parent=" + parent + ", nombre=" + nombre + "]";
	}*/
   
}
