package al.gov.asp.teststandard.beans;

import al.gov.asp.teststandard.ejb.CaseSessionBean;
import al.gov.asp.teststandard.ejb.HelperEjb;
import al.gov.asp.teststandard.ejb.OfficerSessionBean;
import al.gov.asp.teststandard.ejb.ProsecutorSessionBean;
import al.gov.asp.teststandard.entities.Case;
import al.gov.asp.teststandard.entities.IncomeStructure;
import al.gov.asp.teststandard.entities.Officer;
import al.gov.asp.teststandard.entities.Prosecutor;
import al.gov.asp.teststandard.entities.User;
import al.gov.asp.teststandard.models.OfficerModel;
import al.gov.asp.teststandard.rest.OfficerService;
import java.io.Serializable;
import java.math.BigInteger;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Programimi-22
 */
@Named(value = "caseJSFManagedBean")
@SessionScoped
public class CaseJSFManagedBean implements Serializable {

    @EJB
    CaseSessionBean caseEjb;
    @EJB
    ProsecutorSessionBean prosecutorEjb;
    @EJB
    OfficerSessionBean officerEjb;
    @EJB
    HelperEjb helperEjb;

    List<Case> cases;
    List<IncomeStructure> structures;
    List<Officer> officers;
    List<Officer> officerTemp;
    List<Prosecutor> prosecutors;
    List<OfficerModel> oficersModel;

    Case c;
    Case selectedCase;
    User user;
    OfficerModel selectedOfficer;
    Officer officer;
    IncomeStructure incomeStructure;

    String officerName, officerSurname;

    public CaseJSFManagedBean() {
        user = SessionUtils.getUser();
    }

    public Case getC() {
        return c;
    }

    public void setC(Case c) {
        this.c = c;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<IncomeStructure> getStructures() {
        return structures;
    }

    public void setStructures(List<IncomeStructure> structures) {
        this.structures = structures;
    }

    public List<Officer> getOfficers() {
        return officers;
    }

    public void setOfficers(List<Officer> officers) {
        this.officers = officers;
    }

    public List<Prosecutor> getProsecutors() {
        return prosecutors;
    }

    public void setProsecutors(List<Prosecutor> prosecutors) {
        this.prosecutors = prosecutors;
    }

    public List<Case> getCases() {
        return cases;
    }

    public void setCases(List<Case> cases) {
        this.cases = cases;
    }

    public String getOfficerName() {
        return officerName;
    }

    public void setOfficerName(String officerName) {
        this.officerName = officerName;
    }

    public String getOfficerSurname() {
        return officerSurname;
    }

    public void setOfficerSurname(String officerSurname) {
        this.officerSurname = officerSurname;
    }

    public List<OfficerModel> getOficersModel() {
        return oficersModel;
    }

    public void setOficersModel(List<OfficerModel> oficersModel) {
        this.oficersModel = oficersModel;
    }

    public OfficerModel getSelectedOfficer() {
        return selectedOfficer;
    }

    public void setSelectedOfficer(OfficerModel selectedOfficer) {
        this.selectedOfficer = selectedOfficer;
    }

    public Officer getOfficer() {
        return officer;
    }

    public void setOfficer(Officer officer) {
        this.officer = officer;
    }

    public IncomeStructure getIncomeStructure() {
        return incomeStructure;
    }

    public void setIncomeStructure(IncomeStructure incomeStructure) {
        this.incomeStructure = incomeStructure;
    }

    public Case getSelectedCase() {
        return selectedCase;
    }

    public void setSelectedCase(Case selectedCase) {
        this.selectedCase = selectedCase;
    }

    @PostConstruct
    public void load() {
        init();
    }

    private void init() {
        clearOfModelForm();
        oficersModel = new ArrayList<>();
        c = new Case();
        selectedCase = new Case();
        cases = caseEjb.loadCases();
        this.structures = helperEjb.loadStructure();
        officers = helperEjb.loadOfficer();
        prosecutors = helperEjb.loadProsecutor();
        officer = new Officer();
        officerTemp = new ArrayList<>();
        incomeStructure = new IncomeStructure();
    }

    public void searchRmis() {
        OfficerService os = new OfficerService();
        oficersModel = os.getOficerss(officerName, officerSurname);
    }

    public void clearOfModelForm() {
        officerName = null;
        officerSurname = null;
        oficersModel = new ArrayList<>();
        selectedOfficer = new OfficerModel();
    }

    public void onRowSelect() {
        officer.setRmisId(selectedOfficer.getIdRmis());
        officer.setName(selectedOfficer.getName());
        officer.setSurname(selectedOfficer.getSurname());
        officer.setRank(selectedOfficer.getGrade());
        officer.setFunction(selectedOfficer.getOfficerFunction());
    }

    public void createCase() {
        try {
            controlOfficer(officer.getRmisId());

            if (officerTemp.isEmpty()) {
                caseEjb.createTask(c, officer, incomeStructure);
            } else {
                Officer o = officerTemp.get(0);
                caseEjb.createTask1(c, o, incomeStructure);
            }

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Çështja u krijua"));
            init();
        } catch (Exception e) {
            e.printStackTrace();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Gabm", "Çështja nuk u krijua"));
        }
    }

    public void updateCase() {
        try {
            caseEjb.updateCase(c, officer, incomeStructure);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Çështja u modifikua"));
            init();
        } catch (Exception e) {
            e.printStackTrace();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Gabm", "Çështja nuk u modifikua"));
        }
    }

    public void onCaseSelect() {
        c = selectedCase;
        officer = officerEjb.findOfficerbyId(c.getOfficerId().getId());
        incomeStructure = c.getStructureId();
    }

    private List<Officer> controlOfficer(BigInteger nr) {
        officerTemp = officerEjb.findOfficerbyRmis(nr);
        return officerTemp;
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
