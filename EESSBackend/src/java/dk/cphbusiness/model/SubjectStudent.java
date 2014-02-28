/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dk.cphbusiness.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ejer
 */
@Entity
@Table(name = "SUBJECT_STUDENT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SubjectStudent.findAll", query = "SELECT s FROM SubjectStudent s"),
    @NamedQuery(name = "SubjectStudent.findByStudentId", query = "SELECT s FROM SubjectStudent s WHERE s.subjectStudentPK.studentId = :studentId"),
    @NamedQuery(name = "SubjectStudent.findBySubjectId", query = "SELECT s FROM SubjectStudent s WHERE s.subjectStudentPK.subjectId = :subjectId"),
    @NamedQuery(name = "SubjectStudent.findByPool", query = "SELECT s FROM SubjectStudent s WHERE s.pool = :pool"),
    @NamedQuery(name = "SubjectStudent.findByPriority", query = "SELECT s FROM SubjectStudent s WHERE s.priority = :priority")})
public class SubjectStudent implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SubjectStudentPK subjectStudentPK;
    @Size(max = 1)
    @Column(name = "POOL")
    private String pool;
    @Column(name = "PRIORITY")
    private Integer priority;
    @JoinColumn(name = "SUBJECT_ID", referencedColumnName = "ID_SUBJECT", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Subject subject;
    @JoinColumn(name = "STUDENT_ID", referencedColumnName = "ID_STUDENT", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Student student;

    public SubjectStudent() {
    }

    public SubjectStudent(SubjectStudentPK subjectStudentPK) {
        this.subjectStudentPK = subjectStudentPK;
    }

    public SubjectStudent(int studentId, int subjectId) {
        this.subjectStudentPK = new SubjectStudentPK(studentId, subjectId);
    }

    public SubjectStudentPK getSubjectStudentPK() {
        return subjectStudentPK;
    }

    public void setSubjectStudentPK(SubjectStudentPK subjectStudentPK) {
        this.subjectStudentPK = subjectStudentPK;
    }

    public String getPool() {
        return pool;
    }

    public void setPool(String pool) {
        this.pool = pool;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (subjectStudentPK != null ? subjectStudentPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SubjectStudent)) {
            return false;
        }
        SubjectStudent other = (SubjectStudent) object;
        if ((this.subjectStudentPK == null && other.subjectStudentPK != null) || (this.subjectStudentPK != null && !this.subjectStudentPK.equals(other.subjectStudentPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dk.cphbusiness.model.SubjectStudent[ subjectStudentPK=" + subjectStudentPK + " ]";
    }
    
}
