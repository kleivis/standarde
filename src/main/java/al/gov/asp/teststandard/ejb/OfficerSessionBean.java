package al.gov.asp.teststandard.ejb;

import al.gov.asp.teststandard.entities.Officer;
import java.math.BigInteger;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Programimi-22
 */
@Stateless
public class OfficerSessionBean {

    @PersistenceContext(unitName = "al.gov.asp_testStandard_war_1.0-SNAPSHOTPU")
    EntityManager em;

    public Officer findOfficerbyId(int id) {
        return em.find(Officer.class, id);
    }

    public List<Officer> findOfficerbyRmis(BigInteger nr) {
        return em.createQuery("From Officer o where o.rmisId=:nr").setParameter("nr", nr).getResultList();
    }
}
