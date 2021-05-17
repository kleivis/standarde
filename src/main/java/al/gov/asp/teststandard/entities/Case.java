package al.gov.asp.teststandard.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

/**
 *
 * @author Programimi-22
 */
@Entity
@Table(name = "case", schema = "standardet")

public class Case implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "date_created")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateCreated;
    @Column(name = "case_number")
    private String caseNumber;
    @Size(max = 500)
    @Column(name = "description")
    private String description;
    @Column(name = "status")
    private Integer status;
    @Column(name = "interupt")
    private Integer interupt;
    @Size(max = 500)
    @Column(name = "measure")
    private String measure;
    @Column(name = "measure_date")
    @Temporal(TemporalType.DATE)
    private Date measureDate;
    @Column(name = "commision_initial_date")
    @Temporal(TemporalType.DATE)
    private Date commisionInitialDate;
    @Column(name = "commision_date")
    @Temporal(TemporalType.DATE)
    private Date commisionDate;
    @Column(name = "changed")
    private Integer changed;
    @Column(name = "left_inforce")
    private Integer leftInforce;
    @Column(name = "commision_final_date")
    @Temporal(TemporalType.DATE)
    private Date commisionFinalDate;
    @Size(max = 500)
    @Column(name = "commision_decision")
    private String commisionDecision;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private int id;
    @Column(name = "article")
    private String article;
    @JoinColumn(name = "structure_id", referencedColumnName = "id")
    @ManyToOne
    private IncomeStructure structureId;
    @JoinColumn(name = "officer_id", referencedColumnName = "id")
    @ManyToOne()
    private Officer officerId;
    @JoinColumn(name = "prosecutor_id", referencedColumnName = "id")
    @ManyToOne()
    private Prosecutor prosecutorId;

    public Case() {
    }

    public Case(int id) {
        this.id = id;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getCaseNumber() {
        return caseNumber;
    }

    public void setCaseNumber(String caseNumber) {
        this.caseNumber = caseNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getInterupt() {
        return interupt;
    }

    public void setInterupt(Integer interupt) {
        this.interupt = interupt;
    }

    public String getMeasure() {
        return measure;
    }

    public void setMeasure(String measure) {
        this.measure = measure;
    }

    public Date getMeasureDate() {
        return measureDate;
    }

    public void setMeasureDate(Date measureDate) {
        this.measureDate = measureDate;
    }

    public Date getCommisionInitialDate() {
        return commisionInitialDate;
    }

    public void setCommisionInitialDate(Date commisionInitialDate) {
        this.commisionInitialDate = commisionInitialDate;
    }

    public Date getCommisionDate() {
        return commisionDate;
    }

    public void setCommisionDate(Date commisionDate) {
        this.commisionDate = commisionDate;
    }

    public Integer getChanged() {
        return changed;
    }

    public void setChanged(Integer changed) {
        this.changed = changed;
    }

    public Integer getLeftInforce() {
        return leftInforce;
    }

    public void setLeftInforce(Integer leftInforce) {
        this.leftInforce = leftInforce;
    }

    public Date getCommisionFinalDate() {
        return commisionFinalDate;
    }

    public void setCommisionFinalDate(Date commisionFinalDate) {
        this.commisionFinalDate = commisionFinalDate;
    }

    public String getCommisionDecision() {
        return commisionDecision;
    }

    public void setCommisionDecision(String commisionDecision) {
        this.commisionDecision = commisionDecision;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public IncomeStructure getStructureId() {
        return structureId;
    }

    public void setStructureId(IncomeStructure structureId) {
        this.structureId = structureId;
    }

    public Officer getOfficerId() {
        return officerId;
    }

    public void setOfficerId(Officer officerId) {
        this.officerId = officerId;
    }

    public Prosecutor getProsecutorId() {
        return prosecutorId;
    }

    public void setProsecutorId(Prosecutor prosecutorId) {
        this.prosecutorId = prosecutorId;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Case other = (Case) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "al.gov.asp.teststandard.entities.Case[ id=" + id + " ]";
    }

}
