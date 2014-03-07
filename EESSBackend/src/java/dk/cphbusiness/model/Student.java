
package dk.cphbusiness.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Riboe
 */
@Entity
@Table(name = "STUDENT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Student.findAll", query = "SELECT s FROM Student s"),
    @NamedQuery(name = "Student.findByIdStudent", query = "SELECT s FROM Student s WHERE s.idStudent = :idStudent"),
    @NamedQuery(name = "Student.findByStudentName", query = "SELECT s FROM Student s WHERE s.studentName = :studentName")})
public class Student implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_STUDENT")
    private Integer idStudent;
    @Size(max = 30)
    @Column(name = "STUDENT_NAME")
    private String studentName;
    @JoinColumn(name = "FIRST_PRIORITY_A", referencedColumnName = "ID_SUBJECT")
    @ManyToOne
    private Subject firstPriorityA;
    @JoinColumn(name = "FIRST_PRIORITY_B", referencedColumnName = "ID_SUBJECT")
    @ManyToOne
    private Subject firstPriorityB;
    @JoinColumn(name = "SECOND_PRIORITY_A", referencedColumnName = "ID_SUBJECT")
    @ManyToOne
    private Subject secondPriorityA;
    @JoinColumn(name = "SECOND_PRIORITY_B", referencedColumnName = "ID_SUBJECT")
    @ManyToOne
    private Subject secondPriorityB;

    public Student() {
    }

    public Student(Integer idStudent) {
        this.idStudent = idStudent;
    }

    public Integer getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(Integer idStudent) {
        this.idStudent = idStudent;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Subject getFirstPriorityA() {
        return firstPriorityA;
    }

    public void setFirstPriorityA(Subject firstPriorityA) {
        this.firstPriorityA = firstPriorityA;
    }

    public Subject getFirstPriorityB() {
        return firstPriorityB;
    }

    public void setFirstPriorityB(Subject firstPriorityB) {
        this.firstPriorityB = firstPriorityB;
    }

    public Subject getSecondPriorityA() {
        return secondPriorityA;
    }

    public void setSecondPriorityA(Subject secondPriorityA) {
        this.secondPriorityA = secondPriorityA;
    }

    public Subject getSecondPriorityB() {
        return secondPriorityB;
    }

    public void setSecondPriorityB(Subject secondPriorityB) {
        this.secondPriorityB = secondPriorityB;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idStudent != null ? idStudent.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Student)) {
            return false;
        }
        Student other = (Student) object;
        if ((this.idStudent == null && other.idStudent != null) || (this.idStudent != null && !this.idStudent.equals(other.idStudent))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dk.cphbusiness.model.Student[ idStudent=" + idStudent + " ]";
    }

}
