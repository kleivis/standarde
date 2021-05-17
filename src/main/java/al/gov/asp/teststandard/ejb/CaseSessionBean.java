package al.gov.asp.teststandard.ejb;

import al.gov.asp.teststandard.entities.Case;
import al.gov.asp.teststandard.entities.IncomeStructure;
import al.gov.asp.teststandard.entities.Officer;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Programimi-22
 */
@Stateless
public class CaseSessionBean {

    @PersistenceContext(unitName = "al.gov.asp_testStandard_war_1.0-SNAPSHOTPU")
    EntityManager em;

    public void createTask(Case c, Officer o, IncomeStructure is) {
        em.persist(o);
        c.setOfficerId(o);
        c.setStructureId(is);
        em.persist(c);
    }

    public void createTask1(Case c, Officer o, IncomeStructure is) {
        c.setOfficerId(o);
        c.setStructureId(is);
        em.persist(c);
    }

    public void updateCase(Case c, Officer o, IncomeStructure is) {
        c.setOfficerId(o);
        c.setStructureId(is);
        em.merge(c);
    }

    public List<Case> loadCases() {
        return em.createQuery("from Case c").getResultList();
    }

}
