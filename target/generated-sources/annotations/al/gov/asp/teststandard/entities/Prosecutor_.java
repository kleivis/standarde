package al.gov.asp.teststandard.entities;

import al.gov.asp.teststandard.entities.Case;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-10-21T15:35:07")
@StaticMetamodel(Prosecutor.class)
public class Prosecutor_ { 

    public static volatile SingularAttribute<Prosecutor, String> surname;
    public static volatile CollectionAttribute<Prosecutor, Case> caseCollection;
    public static volatile SingularAttribute<Prosecutor, String> name;
    public static volatile SingularAttribute<Prosecutor, BigInteger> rmisId;
    public static volatile SingularAttribute<Prosecutor, String> rank;
    public static volatile SingularAttribute<Prosecutor, Integer> id;

}