package al.gov.asp.teststandard.beans;

import al.gov.asp.teststandard.entities.User;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Programimi-22
 */
@Named(value = "accessBean")
@RequestScoped
public class AccessBean {

    /**
     * Creates a new instance of AccessBean
     */
    public AccessBean() {
    }

    public boolean hasAccess(int roleId) {
        User user = SessionUtils.getUser();

        if (user.getRole() == roleId) {
            return true;
        } else {
            return false;
        }
    }

}
