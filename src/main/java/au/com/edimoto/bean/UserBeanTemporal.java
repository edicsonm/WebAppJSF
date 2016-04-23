package au.com.edimoto.bean;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.validation.Valid;

import au.com.edimoto.entity.User;

@Named("UserBeanTemporal")
@RequestScoped
public class UserBeanTemporal implements Serializable {
	
	private static final long serialVersionUID = 3260389716994390213L;
	private static final Logger logger = Logger.getLogger(UserBeanTemporal.class.toString());
	private String password;
	private  String confPassword;
	
	public String update(User user){
		logger.log(Level.INFO, "Parametro recibido: {0} ", user.getFirstName());
		return "update";
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfPassword() {
		return confPassword;
	}

	public void setConfPassword(String confPassword) {
		this.confPassword = confPassword;
	}
}
