package al.gov.asp.teststandard.ejb;

import al.gov.asp.teststandard.entities.User;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Programimi-22
 */
@Stateless
public class UserSessionBean {

    @PersistenceContext(unitName = "al.gov.asp_testStandard_war_1.0-SNAPSHOTPU")
    EntityManager em;

    public User findPerdorues(String user) {

        try {
            Query q = em.createQuery("From User u where u.username=:u")
                    .setParameter("u", user);
            return (User) q.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

}
