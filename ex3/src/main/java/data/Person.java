/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Peter
 */
@Entity
@Table(name = "person")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Person.findAll", query = "SELECT p FROM Person p")
    , @NamedQuery(name = "Person.findById", query = "SELECT p FROM Person p WHERE p.id = :id")
    , @NamedQuery(name = "Person.findByDtype", query = "SELECT p FROM Person p WHERE p.dtype = :dtype")
    , @NamedQuery(name = "Person.findByAge", query = "SELECT p FROM Person p WHERE p.age = :age")
    , @NamedQuery(name = "Person.findByBirthdate", query = "SELECT p FROM Person p WHERE p.birthdate = :birthdate")
    , @NamedQuery(name = "Person.findByFirstname", query = "SELECT p FROM Person p WHERE p.firstname = :firstname")
    , @NamedQuery(name = "Person.findByIsmarried", query = "SELECT p FROM Person p WHERE p.ismarried = :ismarried")
    , @NamedQuery(name = "Person.findByLastname", query = "SELECT p FROM Person p WHERE p.lastname = :lastname")
    , @NamedQuery(name = "Person.findByMatdate", query = "SELECT p FROM Person p WHERE p.matdate = :matdate")
    , @NamedQuery(name = "Person.findByMatnr", query = "SELECT p FROM Person p WHERE p.matnr = :matnr")
    , @NamedQuery(name = "Person.findBySosecnr", query = "SELECT p FROM Person p WHERE p.sosecnr = :sosecnr")
    , @NamedQuery(name = "Person.findByTaxclass", query = "SELECT p FROM Person p WHERE p.taxclass = :taxclass")
    , @NamedQuery(name = "Person.findByWage", query = "SELECT p FROM Person p WHERE p.wage = :wage")})
public class Person implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Size(max = 31)
    @Column(name = "DTYPE")
    private String dtype;
    @Column(name = "AGE")
    private Integer age;
    @Column(name = "BIRTHDATE")
    @Temporal(TemporalType.DATE)
    private Date birthdate;
    @Size(max = 255)
    @Column(name = "FIRSTNAME")
    private String firstname;
    @Column(name = "ISMARRIED")
    private Boolean ismarried;
    @Size(max = 255)
    @Column(name = "LASTNAME")
    private String lastname;
    @Column(name = "MATDATE")
    @Temporal(TemporalType.DATE)
    private Date matdate;
    @Column(name = "MATNR")
    private Integer matnr;
    @Column(name = "SOSECNR")
    private Integer sosecnr;
    @Size(max = 255)
    @Column(name = "TAXCLASS")
    private String taxclass;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "WAGE")
    private Float wage;
    @JoinTable(name = "supervisions", joinColumns = {
        @JoinColumn(name = "SUPERVISEE_ID", referencedColumnName = "ID")}, inverseJoinColumns = {
        @JoinColumn(name = "SUPERVISOR_ID", referencedColumnName = "ID")})
    @ManyToMany
    private Collection<Person> personCollection;
    @ManyToMany(mappedBy = "personCollection")
    private Collection<Person> personCollection1;
    @OneToMany(mappedBy = "supervisorId")
    private Collection<Person> personCollection2;
    @JoinColumn(name = "SUPERVISOR_ID", referencedColumnName = "ID")
    @ManyToOne
    private Person supervisorId;

    public Person() {
    }

    public Person(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDtype() {
        return dtype;
    }

    public void setDtype(String dtype) {
        this.dtype = dtype;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public Boolean getIsmarried() {
        return ismarried;
    }

    public void setIsmarried(Boolean ismarried) {
        this.ismarried = ismarried;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Date getMatdate() {
        return matdate;
    }

    public void setMatdate(Date matdate) {
        this.matdate = matdate;
    }

    public Integer getMatnr() {
        return matnr;
    }

    public void setMatnr(Integer matnr) {
        this.matnr = matnr;
    }

    public Integer getSosecnr() {
        return sosecnr;
    }

    public void setSosecnr(Integer sosecnr) {
        this.sosecnr = sosecnr;
    }

    public String getTaxclass() {
        return taxclass;
    }

    public void setTaxclass(String taxclass) {
        this.taxclass = taxclass;
    }

    public Float getWage() {
        return wage;
    }

    public void setWage(Float wage) {
        this.wage = wage;
    }

    @XmlTransient
    public Collection<Person> getPersonCollection() {
        return personCollection;
    }

    public void setPersonCollection(Collection<Person> personCollection) {
        this.personCollection = personCollection;
    }

    @XmlTransient
    public Collection<Person> getPersonCollection1() {
        return personCollection1;
    }

    public void setPersonCollection1(Collection<Person> personCollection1) {
        this.personCollection1 = personCollection1;
    }

    @XmlTransient
    public Collection<Person> getPersonCollection2() {
        return personCollection2;
    }

    public void setPersonCollection2(Collection<Person> personCollection2) {
        this.personCollection2 = personCollection2;
    }

    public Person getSupervisorId() {
        return supervisorId;
    }

    public void setSupervisorId(Person supervisorId) {
        this.supervisorId = supervisorId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Person)) {
            return false;
        }
        Person other = (Person) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "data.Person[ id=" + id + " ]";
    }
    
}
