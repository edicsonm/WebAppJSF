package au.com.edimoto.bean;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedProperty;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Named;

import au.com.edimoto.ejb.AdministrationBean;
import au.com.edimoto.entity.User;

@Named("userBean")
@RequestScoped
public class UserBean {
	
	private static final Logger logger = Logger.getLogger(UserBean.class.toString());
	
	@EJB
	private AdministrationBean administrationBean;
	
	
	/*@ManagedProperty("#{bundle}")
	private ResourceBundle bundle;*/
	
	private List<User> listUsers = new ArrayList<User>();
	
	private String sSO;
	private String firstName;
	
	/*@PersistenceContext
    private EntityManager em;*/
	
	
	/*@Transactional
	public void listar(){
		Users user = em.find(Users.class, "edicson");
		System.out.println("user.toString(): " + user.toString());
		System.out.println("user.getUserRoles(): " + user.getUserRoles());
		System.out.println("Listando el usuario ...");
	}*/
	
	public String navigate(){
		logger.log(Level.INFO, "sSO: {0} and firstName: {1}", new String[]{this.getsSO(),this.getFirstName()});
		return "successful";
	}
	
	public String update(User user){
		logger.log(Level.INFO, "Parametro recibido: {0} ", user.getFirstName());
		return "update";
	}
	
	public void chooseUser(ActionEvent event) {
		String current = event.getComponent().getId();
		FacesContext context = FacesContext.getCurrentInstance();
		logger.log(Level.INFO, "current: {0} ", new String[]{current});
		/*String bookId = books.get(current);
		context.getExternalContext().getSessionMap().put("bookId", bookId);*/
	}
	
	public void validateUserName(FacesContext context, UIComponent toValidate, Object value){
		logger.log(Level.INFO, "Ejeuctando validaciones del formulario");
		/*System.out.println(toValidate.getId());
		((UIInput) toValidate).setValid(false);
	    ResourceBundle bundle = context.getApplication().evaluateExpressionGet(context, "#{bundle}", ResourceBundle.class);
		FacesMessage message = new FacesMessage(MessageFormat.format(bundle.getString("error.noNull"), new Object []{toValidate.getAttributes().get("label")}));
		context.addMessage(toValidate.getClientId(context), message);
		return;*/
	}
	
	public List<User> getUsers() {
		return administrationBean.getUsers();
	}

	public void setListUsers(List<User> listUsers) {
		this.listUsers = listUsers;
	}

	public List<User> getListUsers() {
		listUsers = administrationBean.getUsers();
		return listUsers;
	}

	public String getsSO() {
		return sSO;
	}

	public void setsSO(String sSO) {
		this.sSO = sSO;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

}
