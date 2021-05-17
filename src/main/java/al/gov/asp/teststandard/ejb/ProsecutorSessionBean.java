package al.gov.asp.teststandard.ejb;

import al.gov.asp.teststandard.entities.Prosecutor;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Programimi-22
 */
@Stateless
public class ProsecutorSessionBean {

    @PersistenceContext(unitName = "al.gov.asp_testStandard_war_1.0-SNAPSHOTPU")
    EntityManager em;

    public Prosecutor findProsecutorbyId(int id) {
        return em.find(Prosecutor.class, id);
    }
}
