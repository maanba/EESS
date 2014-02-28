/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dk.cphbusiness.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
 * @author Ejer
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
    @NamedQuery(name = "Subject.findByFirstElectiveRound", query = "SELECT s FROM Subject s WHERE s.firstElectiveRound = :firstElectiveRound")})
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
    @JoinTable(name = "SUBJECT_TEACHER", joinColumns = {
        @JoinColumn(name = "SUBJECT_ID", referencedColumnName = "ID_SUBJECT")}, inverseJoinColumns = {
        @JoinColumn(name = "TEACHER_ID", referencedColumnName = "ID_TEACHER")})
    @ManyToMany
    private Collection<Teacher> teacherCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "subject")
    private Collection<SubjectStudent> subjectStudentCollection;

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

    @XmlTransient
    public Collection<Teacher> getTeacherCollection() {
        return teacherCollection;
    }

    public void setTeacherCollection(Collection<Teacher> teacherCollection) {
        this.teacherCollection = teacherCollection;
    }

    @XmlTransient
    public Collection<SubjectStudent> getSubjectStudentCollection() {
        return subjectStudentCollection;
    }

    public void setSubjectStudentCollection(Collection<SubjectStudent> subjectStudentCollection) {
        this.subjectStudentCollection = subjectStudentCollection;
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
