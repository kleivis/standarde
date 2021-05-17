package al.gov.asp.teststandard.converters;

import al.gov.asp.teststandard.ejb.HelperEjb;
import al.gov.asp.teststandard.entities.IncomeStructure;
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
@Named(value = "structureConverter")
@RequestScoped
public class StructureConverter implements Converter {

    @EJB
    HelperEjb helperEjb;

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        if (value != null && value.trim().length() > 0) {
            try {
                // int id = Integer.parseInt(value);
                Integer id = Integer.valueOf(value);
                return helperEjb.findStructureById(id);

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
            return String.valueOf(((IncomeStructure) object).getId());
        } else {
            return null;
        }
    }

}
