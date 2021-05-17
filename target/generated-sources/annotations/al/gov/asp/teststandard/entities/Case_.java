package al.gov.asp.teststandard.entities;

import al.gov.asp.teststandard.entities.IncomeStructure;
import al.gov.asp.teststandard.entities.Officer;
import al.gov.asp.teststandard.entities.Prosecutor;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-10-21T15:35:07")
@StaticMetamodel(Case.class)
public class Case_ { 

    public static volatile SingularAttribute<Case, Integer> interupt;
    public static volatile SingularAttribute<Case, Prosecutor> prosecutorId;
    public static volatile SingularAttribute<Case, String> description;
    public static volatile SingularAttribute<Case, IncomeStructure> structureId;
    public static volatile SingularAttribute<Case, Date> commisionFinalDate;
    public static volatile SingularAttribute<Case, Date> measureDate;
    public static volatile SingularAttribute<Case, Date> commisionInitialDate;
    public static volatile SingularAttribute<Case, String> article;
    public static volatile SingularAttribute<Case, Integer> leftInforce;
    public static volatile SingularAttribute<Case, Date> dateCreated;
    public static volatile SingularAttribute<Case, String> measure;
    public static volatile SingularAttribute<Case, String> caseNumber;
    public static volatile SingularAttribute<Case, Date> commisionDate;
    public static volatile SingularAttribute<Case, String> commisionDecision;
    public static volatile SingularAttribute<Case, Integer> id;
    public static volatile SingularAttribute<Case, Officer> officerId;
    public static volatile SingularAttribute<Case, Integer> status;
    public static volatile SingularAttribute<Case, Integer> changed;

}