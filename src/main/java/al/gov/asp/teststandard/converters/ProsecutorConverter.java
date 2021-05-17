package al.gov.asp.teststandard.converters;

import al.gov.asp.teststandard.ejb.HelperEjb;
import al.gov.asp.teststandard.entities.Prosecutor;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Named;

/**
 *
 * @author Programimi-22
 */
@Named(value = "prosecutorConverter")
@RequestScoped
public class ProsecutorConverter implements Converter {

    @EJB
    HelperEjb helperEjb;

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        if (value != null && value.trim().length() > 0) {
            try {
                int id = Integer.parseInt(value);

                return helperEjb.findProsecutorById(id);

            } catch (NumberFormatException e) {
                return null;
            }
        } else {
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object object) {
        if (object != null) {
            return String.valueOf(((Prosecutor) object).getId());
        } else {
            return null;
        }
    }

}
