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
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "TEACHER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Teacher.findAll", query = "SELECT t FROM Teacher t"),
    @NamedQuery(name = "Teacher.findByIdTeacher", query = "SELECT t FROM Teacher t WHERE t.idTeacher = :idTeacher"),
    @NamedQuery(name = "Teacher.findByTeacherName", query = "SELECT t FROM Teacher t WHERE t.teacherName = :teacherName"),
    @NamedQuery(name = "Teacher.findByIntials", query = "SELECT t FROM Teacher t WHERE t.intials = :intials")})
public class Teacher implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_TEACHER")
    private Integer idTeacher;
    @Size(max = 30)
    @Column(name = "TEACHER_NAME")
    private String teacherName;
    @Size(max = 3)
    @Column(name = "INTIALS")
    private String intials;
    @ManyToMany(mappedBy = "teacherCollection")
    private Collection<Subject> subjectCollection;

    public Teacher() {
    }

    public Teacher(Integer idTeacher) {
        this.idTeacher = idTeacher;
    }

    public Integer getIdTeacher() {
        return idTeacher;
    }

    public void setIdTeacher(Integer idTeacher) {
        this.idTeacher = idTeacher;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getIntials() {
        return intials;
    }

    public void setIntials(String intials) {
        this.intials = intials;
    }

    @XmlTransient
    public Collection<Subject> getSubjectCollection() {
        return subjectCollection;
    }

    public void setSubjectCollection(Collection<Subject> subjectCollection) {
        this.subjectCollection = subjectCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTeacher != null ? idTeacher.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Teacher)) {
            return false;
        }
        Teacher other = (Teacher) object;
        if ((this.idTeacher == null && other.idTeacher != null) || (this.idTeacher != null && !this.idTeacher.equals(other.idTeacher))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dk.cphbusiness.model.Teacher[ idTeacher=" + idTeacher + " ]";
    }
    
}
