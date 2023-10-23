package ma.fstt.atelierejbclient;

import java.util.Properties;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class ejbtest {
    public static void main(String[] args) {
        try {
            Properties jndiProperties = new Properties();
            jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
            jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
            jndiProperties.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");
            jndiProperties.put("jboss.naming.client.ejb.context", true);

            Context context = new InitialContext(jndiProperties);

            EtudiantServiceRemote etudiantService = (EtudiantServiceRemote) context.lookup("ejb:/AtelierEJB-1.0-SNAPSHOT/EtudiantServiceBean!ma.fstt.atelierejb.service.EtudiantServiceRemote");

            System.out.println("Connection to EJB is successful!");
        } catch (NamingException e) {
            e.printStackTrace();
            System.err.println("Connection to EJB failed.");
        }
    }
}
