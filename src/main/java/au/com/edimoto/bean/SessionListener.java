package au.com.edimoto.bean;

import javax.management.MBeanServer;
import javax.management.MBeanServerFactory;
import javax.management.ObjectName;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionListener implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent httpSessionEvent) {
		/*Principal principal = (Principal) httpSessionEvent.getSession() .getAttribute("principal");*/
		/*System.out.println("sessionCreated dice: "+principal.getName());*/
		System.out.println("sessionDestroyed dice: Abriendo session");
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
		/*Principal principal = (Principal) httpSessionEvent.getSession().getAttribute("principal");
		System.out.println("sessionDestroyed dice: Cerrando session");
		clearCache("edicson");*/
		/*System.out.println("sessionDestroyed dice: "+principal.getName());*/
	}
	
	public void clearCache(String username){
		try {
		    ObjectName jaasMgr = new ObjectName("jboss.as:subsystem=security,security-domain=BasicSecureDomain" );
		    Object[] params = {username};
		    String[] signature = {"java.lang.String"};
		    MBeanServer server = (MBeanServer) MBeanServerFactory.findMBeanServer(null).get(0);
		    server.invoke(jaasMgr, "flushCache", params, signature);
		    System.out.println("Termina de limpiar la cache ... ");
		} catch (Exception ex) {
		    System.out.println(ex.getMessage());
		}}

}
