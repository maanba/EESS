/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dk.cphbusiness.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Ejer
 */
@Embeddable
public class SubjectStudentPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "STUDENT_ID")
    private int studentId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SUBJECT_ID")
    private int subjectId;

    public SubjectStudentPK() {
    }

    public SubjectStudentPK(int studentId, int subjectId) {
        this.studentId = studentId;
        this.subjectId = subjectId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) studentId;
        hash += (int) subjectId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SubjectStudentPK)) {
            return false;
        }
        SubjectStudentPK other = (SubjectStudentPK) object;
        if (this.studentId != other.studentId) {
            return false;
        }
        if (this.subjectId != other.subjectId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dk.cphbusiness.model.SubjectStudentPK[ studentId=" + studentId + ", subjectId=" + subjectId + " ]";
    }
    
}
