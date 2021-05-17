package al.gov.asp.teststandard.ejb;

import al.gov.asp.teststandard.entities.IncomeStructure;
import al.gov.asp.teststandard.entities.Officer;
import al.gov.asp.teststandard.entities.Prosecutor;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Programimi-22
 */
@Stateless
public class HelperEjb {

    @PersistenceContext(unitName = "al.gov.asp_testStandard_war_1.0-SNAPSHOTPU")
    EntityManager em;

    public IncomeStructure findStructureById(int id) {
        return em.find(IncomeStructure.class, id);
    }

    public List<IncomeStructure> loadStructure() {
        return em.createQuery("From IncomeStructure i order by i.structure asc").getResultList();
    }

    public Officer findOfficerById(int id) {
        return em.find(Officer.class, id);
    }

    public List<Officer> loadOfficer() {
        return em.createQuery("From Officer o").getResultList();
    }

    public Prosecutor findProsecutorById(int id) {
        return em.find(Prosecutor.class, id);
    }

    public List<Prosecutor> loadProsecutor() {
        return em.createQuery("From Prosecutor p").getResultList();
    }

}
