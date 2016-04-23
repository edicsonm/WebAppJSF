package au.com.edimoto.ejb;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import au.com.edimoto.entity.Parent;
import au.com.edimoto.entity.Role;
import au.com.edimoto.entity.Test;
import au.com.edimoto.entity.User;
import au.com.edimoto.entity.UserRole;

@SuppressWarnings("unused")
@Startup
@Singleton
public class ConfigBean {
	
	@EJB
	private AdministrationBean administrationBean;
	
	private static final Logger logger = Logger.getLogger("au.com.edimoto.ejb.ConfigBean");
	
//	@PostConstruct
	public void createData() {
		
		/*administrationBean.createUser(new User("edicson", "56yqqD0Rrw0waFEsbNWlOKl1EB00A6y61ZQ+ZOBAUoE=","Edicson","Morales", "edicsonm@gmail.com"));
		administrationBean.createRol(new Role("ADMIN","Administration Role"));
		administrationBean.addRoleToUser(new UserRole("edicson","ADMIN"));*/
		
		logger.log(Level.INFO, "Number of users {0} ", administrationBean.getUsers().size());
		//user = administrationBean.getUser("edicson");
//		logger.log(Level.INFO, "Roles 2 user  {0} ", user.getUserRoles());
		
//		administrationBean.addTestToUser(new Test("edicson","Test1"));
//		administrationBean.addTestToUser(new Test("edicson","Test2"));
		User userEdicson = administrationBean.getUser("edicson");
		logger.log(Level.INFO, "User listed {0} ", userEdicson.toString());
		logger.log(Level.INFO, "XXXXXXXXXXXXXXXXXXXXXXXXXX Roles  user  {0} ", userEdicson.getUserRoles().size());
		
		User userhamilton = administrationBean.getUser("hamilton");
		logger.log(Level.INFO, "User listed {0} ", userhamilton.toString());
		logger.log(Level.INFO, "XXXXXXXXXXXXXXXXXXXXXXXXXX Roles  user  {0} ", userhamilton.getUserRoles().size());
		
		UserRole userRoleAdmin = administrationBean.getUserRole("ADMIN");
		logger.log(Level.INFO, "XXXXXXXXXXXXXXXXXXXXXXXXXX UserRole  UserRole  {0} ", userRoleAdmin.getUser().getEmail());
		
		
		Role role = administrationBean.getRole("DBA");
		logger.log(Level.INFO, "XXXXXXXXXXXXXXXXXXXXXXXXXX Roles  UserRole  {0} ", role.getUserRoles().size());
//		Parent parent = administrationBean.testRelations(1);
//		logger.log(Level.INFO, "YYYYYYYYYYYYYYYYYYYYYYYYYY Parent listed {0} ", parent.toString());
//		logger.log(Level.INFO, "ZZZZZZZZZZZZZZZZZZZZZZZZZZ Parent listed {0} ", parent.getChilds().size());
	}
	
}
