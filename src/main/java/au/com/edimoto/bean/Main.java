package au.com.edimoto.bean;

import java.io.IOException;
import java.security.Principal;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named
@RequestScoped
public class Main {
	
	private Principal principal;
	private boolean userAuthenticated;
	
	public void logout(){
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
	    try {
			FacesContext.getCurrentInstance().getExternalContext().redirect(FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Principal getPrincipal() {
		principal = FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal();
		return principal;
	}

	public void setPrincipal(Principal principal) {
		this.principal = principal;
	}

	public boolean isUserAuthenticated() {
		userAuthenticated = FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal() != null ? true : false;
		return userAuthenticated;
	}

	public void setUserAuthenticated(boolean userAuthenticated) {
		this.userAuthenticated = userAuthenticated;
	}
	
}
