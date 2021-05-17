package al.gov.asp.teststandard.beans;

import al.gov.asp.teststandard.ejb.CaseSessionBean;
import al.gov.asp.teststandard.ejb.OfficerSessionBean;
import al.gov.asp.teststandard.ejb.ProsecutorSessionBean;
import al.gov.asp.teststandard.entities.Case;
import al.gov.asp.teststandard.entities.Officer;
import al.gov.asp.teststandard.entities.Prosecutor;
import al.gov.asp.teststandard.entities.User;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Programimi-22
 */
@Named(value = "raportJSFManagedBean")
@RequestScoped
public class RaportJSFManagedBean {

    @EJB
    CaseSessionBean caseEjb;

    @EJB
    OfficerSessionBean officerEjb;

    @EJB
    ProsecutorSessionBean prosecutorEjb;

    User user;

    List<Case> cases;

    public RaportJSFManagedBean() {
        user = SessionUtils.getUser();
    }

    public List<Case> getCases() {
        return cases;
    }

    public void setCases(List<Case> cases) {
        this.cases = cases;
    }

    @PostConstruct
    public void load() {
        init();
    }

    private void init() {
        cases = caseEjb.loadCases();
    }

    public String formatDate(Date d) {
        if (d != null) {
            DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
            return df.format(d);
        }
        return "";
    }

    public String formatProsecutor(int id) {
        Prosecutor p = prosecutorEjb.findProsecutorbyId(id);
        String grada = p.getRank();
        String emri = p.getName();
        String mbiemri = p.getSurname();
        return grada + " " + emri + " " + mbiemri;
    }

    public String formatOfficer(int id) {
        Officer o = officerEjb.findOfficerbyId(id);
        String grada = o.getRank();
        String emri = o.getName();
        String mbiemri = o.getSurname();
        return grada + " " + emri + " " + mbiemri;
    }

}
