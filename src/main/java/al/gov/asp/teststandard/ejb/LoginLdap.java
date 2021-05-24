package al.gov.asp.teststandard.ejb;

import java.util.Hashtable;
import javax.ejb.Stateless;
import javax.naming.AuthenticationException;
import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;

/**
 *
 * @author Programimi-22
 */
@Stateless
public class LoginLdap {

    public static boolean authenticateLdap(String username, String password) throws Exception {

        // Setup environment for authenticating
        Hashtable<String, String> environment = new Hashtable<String, String>();
        environment.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        environment.put(Context.PROVIDER_URL, "ldap://192.168.1.2:389");
        environment.put(Context.SECURITY_AUTHENTICATION, "simple");
        environment.put(Context.SECURITY_PRINCIPAL, username + "@gov.al");
        environment.put(Context.SECURITY_CREDENTIALS, password);

        try {
            DirContext authContext = new InitialDirContext(environment);
            // user is authenticated
            return true;
        } catch (AuthenticationException ex) {
            // Authentication failed
        } catch (NamingException ex) {
            ex.printStackTrace();
        }
        return false;
    }

}
