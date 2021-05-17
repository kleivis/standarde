package al.gov.asp.teststandard.beans;

import al.gov.asp.teststandard.ejb.LoginLdap;
import al.gov.asp.teststandard.ejb.UserSessionBean;
import al.gov.asp.teststandard.entities.User;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Programimi-22
 */
@Named(value = "loginBean")
@SessionScoped
public class LoginBean implements Serializable {

    private static final long serialVersionUID = 1094801825228386363L;

    @EJB
    UserSessionBean usersSessionBean;
    @EJB
    LoginLdap loginLdap;
    String username;
    String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String loginLdap() throws Exception {
        User valid = usersSessionBean.findPerdorues(username);

        if (valid != null) {

            boolean isLogin = loginLdap.authenticateLdap(username, password);
            if (isLogin == true) {

                HttpSession session = SessionUtils.getSession();
                session.setAttribute("user", valid);

                if (valid.getRole() == 1) {
                    return "raport.xhtml?faces-redirect=true";
                } else if (valid.getRole() == 0) {
                    return "case.xhtml?faces-redirect=true";
                }

            } else {
                FacesContext.getCurrentInstance().addMessage(
                        null,
                        new FacesMessage(FacesMessage.SEVERITY_WARN,
                                "Gabim! Fjalëkalimi i pavlefshëm!!!",
                                "Futni Fjalëkalimin e saktë"));
                return "index.xhtml";
            }

        } else {
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                            "Gabim!",
                            "Përdoruesi është i pa saktë ose nuk keni të drejta."));
        }
        return "index.xhtml";
    }

    public String logout() {
        HttpSession session = SessionUtils.getSession();
        session.invalidate();
        return "index.xhtml?faces-redirect=true";
    }

}
