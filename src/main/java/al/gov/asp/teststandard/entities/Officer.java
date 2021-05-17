package al.gov.asp.teststandard.entities;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author Programimi-22
 */
@Entity
@Table(name = "officer", schema = "standardet")

public class Officer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "rmis_id")
    private BigInteger rmisId;
    @Size(max = 2147483647)
    @Column(name = "rank")
    private String rank;
    @Size(max = 2147483647)
    @Column(name = "name")
    private String name;
    @Size(max = 2147483647)
    @Column(name = "surname")
    private String surname;
    @Size(max = 2147483647)
    @Column(name = "father_name")
    private String fatherName;
    @Size(max = 2147483647)
    @Column(name = "organization")
    private String organization;
    @Size(max = 2147483647)
    @Column(name = "function")
    private String function;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private int id;
    @OneToMany(mappedBy = "officerId", fetch = FetchType.LAZY)
    private Collection<Case> caseCollection;

    public Officer() {
    }

    public Officer(int id) {
        this.id = id;
    }

    public BigInteger getRmisId() {
        return rmisId;
    }

    public void setRmisId(BigInteger rmisId) {
        this.rmisId = rmisId;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Collection<Case> getCaseCollection() {
        return caseCollection;
    }

    public void setCaseCollection(Collection<Case> caseCollection) {
        this.caseCollection = caseCollection;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 73 * hash + this.id;
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
        final Officer other = (Officer) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "al.gov.asp.teststandard.entities.Officer[ id=" + id + " ]";
    }
    
}
