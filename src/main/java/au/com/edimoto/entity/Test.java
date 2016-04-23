package au.com.edimoto.entity;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Test
 *
 */
@Entity
public class Test implements Serializable {

	private static final long serialVersionUID = 1L; 
	
	@Id
	private Integer idTest;
	
	@Column
	private String description;
	
	@Column
	private String sSOParent; 

	public Test() {
		super();
	}

	public Integer getIdTest() {
		return idTest;
	}

	public void setIdTest(Integer idTest) {
		this.idTest = idTest;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getsSOParent() {
		return sSOParent;
	}

	public void setsSOParent(String sSOParent) {
		this.sSOParent = sSOParent;
	}
	
   
}
