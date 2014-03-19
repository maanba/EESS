/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dk.cphbusiness.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Janne
 */
@Entity
@Table(name = "SUBJECT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Subject.findAll", query = "SELECT s FROM Subject s"),
    @NamedQuery(name = "Subject.findByIdSubject", query = "SELECT s FROM Subject s WHERE s.idSubject = :idSubject"),
    @NamedQuery(name = "Subject.findBySubjectName", query = "SELECT s FROM Subject s WHERE s.subjectName = :subjectName"),
    @NamedQuery(name = "Subject.findByDescription", query = "SELECT s FROM Subject s WHERE s.description = :description"),
    @NamedQuery(name = "Subject.findByTeacher", query = "SELECT s FROM Subject s WHERE s.teacher = :teacher"),
    @NamedQuery(name = "Subject.findByPool", query = "SELECT s FROM Subject s WHERE s.pool = :pool"),
    @NamedQuery(name = "Subject.findByFirstElectiveRound", query = "SELECT s FROM Subject s WHERE s.firstElectiveRound = :firstElectiveRound"),
    @NamedQuery(name = "Subject.findByIsFinal", query = "SELECT s FROM Subject s WHERE s.isFinal = :isFinal")})
public class Subject implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_SUBJECT")
    private Integer idSubject;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "SUBJECT_NAME")
    private String subjectName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "DESCRIPTION")
    private String description;
    @Size(max = 30)
    @Column(name = "TEACHER")
    private String teacher;
    @Size(max = 1)
    @Column(name = "POOL")
    private String pool;
    @Size(max = 1)
    @Column(name = "FIRST_ELECTIVE_ROUND")
    private String firstElectiveRound;
    @Size(max = 1)
    @Column(name = "IS_FINAL")
    private String isFinal;
    @JoinTable(name = "SUBJECT_TEACHER", joinColumns = {
        @JoinColumn(name = "SUBJECT_ID", referencedColumnName = "ID_SUBJECT")}, inverseJoinColumns = {
        @JoinColumn(name = "TEACHER_ID", referencedColumnName = "ID_TEACHER")})
    @ManyToMany
    private Collection<Teacher> teacherCollection;
    @OneToMany(mappedBy = "finalB")
    private Collection<Student> studentCollection;
    @OneToMany(mappedBy = "finalA")
    private Collection<Student> studentCollection1;
    @OneToMany(mappedBy = "secondPriorityB")
    private Collection<Student> studentCollection2;
    @OneToMany(mappedBy = "secondPriorityA")
    private Collection<Student> studentCollection3;
    @OneToMany(mappedBy = "firstPriorityB")
    private Collection<Student> studentCollection4;
    @OneToMany(mappedBy = "firstPriorityA")
    private Collection<Student> studentCollection5;

    public Subject() {
    }

    public Subject(Integer idSubject) {
        this.idSubject = idSubject;
    }

    public Subject(Integer idSubject, String subjectName, String description) {
        this.idSubject = idSubject;
        this.subjectName = subjectName;
        this.description = description;
    }

    public Integer getIdSubject() {
        return idSubject;
    }

    public void setIdSubject(Integer idSubject) {
        this.idSubject = idSubject;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getPool() {
        return pool;
    }

    public void setPool(String pool) {
        this.pool = pool;
    }

    public String getFirstElectiveRound() {
        return firstElectiveRound;
    }

    public void setFirstElectiveRound(String firstElectiveRound) {
        this.firstElectiveRound = firstElectiveRound;
    }

    public String getIsFinal() {
        return isFinal;
    }

    public void setIsFinal(String isFinal) {
        this.isFinal = isFinal;
    }

    @XmlTransient
    public Collection<Teacher> getTeacherCollection() {
        return teacherCollection;
    }

    public void setTeacherCollection(Collection<Teacher> teacherCollection) {
        this.teacherCollection = teacherCollection;
    }

    @XmlTransient
    public Collection<Student> getStudentCollection() {
        return studentCollection;
    }

    public void setStudentCollection(Collection<Student> studentCollection) {
        this.studentCollection = studentCollection;
    }

    @XmlTransient
    public Collection<Student> getStudentCollection1() {
        return studentCollection1;
    }

    public void setStudentCollection1(Collection<Student> studentCollection1) {
        this.studentCollection1 = studentCollection1;
    }

    @XmlTransient
    public Collection<Student> getStudentCollection2() {
        return studentCollection2;
    }

    public void setStudentCollection2(Collection<Student> studentCollection2) {
        this.studentCollection2 = studentCollection2;
    }

    @XmlTransient
    public Collection<Student> getStudentCollection3() {
        return studentCollection3;
    }

    public void setStudentCollection3(Collection<Student> studentCollection3) {
        this.studentCollection3 = studentCollection3;
    }

    @XmlTransient
    public Collection<Student> getStudentCollection4() {
        return studentCollection4;
    }

    public void setStudentCollection4(Collection<Student> studentCollection4) {
        this.studentCollection4 = studentCollection4;
    }

    @XmlTransient
    public Collection<Student> getStudentCollection5() {
        return studentCollection5;
    }

    public void setStudentCollection5(Collection<Student> studentCollection5) {
        this.studentCollection5 = studentCollection5;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSubject != null ? idSubject.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Subject)) {
            return false;
        }
        Subject other = (Subject) object;
        if ((this.idSubject == null && other.idSubject != null) || (this.idSubject != null && !this.idSubject.equals(other.idSubject))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dk.cphbusiness.model.Subject[ idSubject=" + idSubject + " ]";
    }
    
}
