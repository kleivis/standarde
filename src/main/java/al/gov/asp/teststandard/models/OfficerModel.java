package al.gov.asp.teststandard.models;

import java.math.BigInteger;

/**
 *
 * @author Programimi-22
 */
public class OfficerModel {

    Integer id;
    BigInteger idRmis;
    String idStrRmis, structureRmisName, dob;
    String grade, name, surname, officerFunction, fathername;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigInteger getIdRmis() {
        return idRmis;
    }

    public void setIdRmis(BigInteger idRmis) {
        this.idRmis = idRmis;
    }

    public String getIdStrRmis() {
        return idStrRmis;
    }

    public void setIdStrRmis(String idStrRmis) {
        this.idStrRmis = idStrRmis;
    }

    public String getStructureRmisName() {
        return structureRmisName;
    }

    public void setStructureRmisName(String structureRmisName) {
        this.structureRmisName = structureRmisName;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
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

    public String getOfficerFunction() {
        return officerFunction;
    }

    public void setOfficerFunction(String officerFunction) {
        this.officerFunction = officerFunction;
    }

    public String getFathername() {
        return fathername;
    }

    public void setFathername(String fathername) {
        this.fathername = fathername;
    }

}
