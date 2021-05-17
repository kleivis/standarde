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
@Table(name = "prosecutor", schema = "standardet")

public class Prosecutor implements Serializable {

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
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private int id;
    @OneToMany(mappedBy = "prosecutorId", fetch = FetchType.LAZY)
    private Collection<Case> caseCollection;

    public Prosecutor() {
    }

    public Prosecutor(int id) {
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
        int hash = 5;
        hash = 59 * hash + this.id;
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
        final Prosecutor other = (Prosecutor) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "al.gov.asp.teststandard.entities.Prosecutor[ id=" + id + " ]";
    }

}
