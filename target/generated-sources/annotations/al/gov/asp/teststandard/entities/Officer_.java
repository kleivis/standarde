package al.gov.asp.teststandard.entities;

import al.gov.asp.teststandard.entities.Case;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-10-21T15:35:07")
@StaticMetamodel(Officer.class)
public class Officer_ { 

    public static volatile SingularAttribute<Officer, String> fatherName;
    public static volatile SingularAttribute<Officer, String> surname;
    public static volatile SingularAttribute<Officer, String> organization;
    public static volatile SingularAttribute<Officer, String> function;
    public static volatile CollectionAttribute<Officer, Case> caseCollection;
    public static volatile SingularAttribute<Officer, String> name;
    public static volatile SingularAttribute<Officer, BigInteger> rmisId;
    public static volatile SingularAttribute<Officer, String> rank;
    public static volatile SingularAttribute<Officer, Integer> id;

}