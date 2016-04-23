package au.com.edimoto.ejb;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import au.com.edimoto.entity.Parent;
import au.com.edimoto.entity.Role;
import au.com.edimoto.entity.Test;
import au.com.edimoto.entity.User;
import au.com.edimoto.entity.UserRole;
import au.com.edimoto.entity.UserRoleKey;

@Stateless
public class AdministrationBean {
	
	@PersistenceContext
	EntityManager em;
	
	private static final Logger logger = Logger.getLogger("au.com.edimoto.ejb.AdministrationBean");
	
	public List<User> getUsers() {
        return (List<User>)em.createNamedQuery("User.listAllUsers").getResultList();
	}
	
	public User getUser(String sso){
       return em.find(User.class, sso);
	}
	
	public void createUser(User user){
		try {
			logger.log(Level.INFO, "Created user {0}-{1}", new Object[]{user.getsSO(), user.getEmail()});
			em.persist(user);
			logger.log(Level.INFO, "Persisted user {0}-{1}", new Object[]{user.getsSO(), user.getEmail()});
		}catch(Exception ex){
			throw new EJBException(ex.getMessage());
		}
	}
	
	public void createRol(Role role){
		try {
			logger.log(Level.INFO, "Created role {0}-{1}", new Object[]{role.getName(), role.getDescription()});
			em.persist(role);
			logger.log(Level.INFO, "Persisted role {0}-{1}", new Object[]{role.getName(), role.getDescription()});
		}catch(Exception ex){
			throw new EJBException(ex.getMessage());
		}
	}
	
	public void addRoleToUser(UserRole userRole){
		try {
			logger.log(Level.INFO, "Added role {0} to user {1}", new Object[]{userRole.getRoleName(), userRole.getsSO()});
			em.persist(userRole);
			logger.log(Level.INFO, "Persisted role {0} to user {1}", new Object[]{userRole.getRoleName(), userRole.getsSO()});
		}catch(Exception ex){
			throw new EJBException(ex.getMessage());
		}
	}
	
	public void addTestToUser(Test test){
		/*try {
			logger.log(Level.INFO, "Added test {0} to user {1}", new Object[]{test.getUserSSO(), test.getDescription()});
			em.persist(test);
			logger.log(Level.INFO, "Persisted test {0} to user {1}", new Object[]{test.getUserSSO(), test.getDescription()});
		}catch(Exception ex){
			throw new EJBException(ex.getMessage());
		}*/
	}
	
	public Parent testRelations(Integer idParent){
		return em.find(Parent.class, idParent);
	}

	public UserRole getUserRole(String string) {
		UserRoleKey pk = new UserRoleKey("edicson", "DBA");
		return em.find(UserRole.class, pk);
	}

	public Role getRole(String roleName) {
		return em.find(Role.class, roleName);
	}
}
