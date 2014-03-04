/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.cphbusiness.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "STUDENT")
@XmlRootElement
@NamedQueries(
{
    @NamedQuery(name = "Student.findAll", query = "SELECT s FROM Student s"),
    @NamedQuery(name = "Student.findByIdStudent", query = "SELECT s FROM Student s WHERE s.idStudent = :idStudent"),
    @NamedQuery(name = "Student.findByStudentName", query = "SELECT s FROM Student s WHERE s.studentName = :studentName")
})
public class Student implements Serializable
{

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_STUDENT")
    private Integer idStudent;
    @Size(max = 30)
    @Column(name = "STUDENT_NAME")
    private String studentName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "student")
    private Collection<SubjectStudent> subjectStudentCollection;

    public Student()
    {
    }

    public Student(Integer idStudent)
    {
        this.idStudent = idStudent;
    }

    public Integer getIdStudent()
    {
        return idStudent;
    }

    public void setIdStudent(Integer idStudent)
    {
        this.idStudent = idStudent;
    }

    public String getStudentName()
    {
        return studentName;
    }

    public void setStudentName(String studentName)
    {
        this.studentName = studentName;
    }

    @XmlTransient
    public Collection<SubjectStudent> getSubjectStudentCollection()
    {
        return subjectStudentCollection;
    }

    public void setSubjectStudentCollection(Collection<SubjectStudent> subjectStudentCollection)
    {
        this.subjectStudentCollection = subjectStudentCollection;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (idStudent != null ? idStudent.hashCode() : 0);
        return hash;
    }

    public void makeSubjectStudent(ArrayList<Subject> subjects)
    {
        Collection<SubjectStudent> subjectstudent = new ArrayList<>();
        for (Subject sub : subjects)
        {
            SubjectStudent SS = new SubjectStudent(idStudent, sub.getIdSubject());
            subjectstudent.add(SS);
        }
        setSubjectStudentCollection(subjectstudent);
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Student))
        {
            return false;
        }
        Student other = (Student) object;
        if ((this.idStudent == null && other.idStudent != null) || (this.idStudent != null && !this.idStudent.equals(other.idStudent)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "dk.cphbusiness.model.Student[ idStudent=" + idStudent + " ]";
    }

}
