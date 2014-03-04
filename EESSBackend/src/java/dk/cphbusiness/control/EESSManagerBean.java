/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.cphbusiness.control;
import contract.EessInterface;
import dk.cphbusiness.model.Assembler;
import dk.cphbusiness.model.Student;
import dk.cphbusiness.model.Subject;
import dk.cphbusiness.model.SubjectStudent;
import dk.cphbusiness.model.Teacher;
import dto.DTOStudent;
import dto.DTOSubject;
import dto.DTOTeacher;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
/**
 *
 * @author Ejer
 */
@Stateless
public class EESSManagerBean implements EessInterface {
    @PersistenceContext(unitName = "EESSBackendPU")
    private EntityManager em;
    @Override
    public ArrayList<DTOStudent> getStudents() 
    {
        Query query = em.createNamedQuery("Student.findAll");
        ArrayList<Student> students = (ArrayList<Student>) query.getResultList();
        ArrayList<DTOStudent> dtoStudents = new ArrayList<>();
        ArrayList<Subject> arraySubjects = new ArrayList<>();
        
        for (int i = 0; i < students.size(); i++)
        {
            for(int n = 0; n < students.get(i).getSubjectStudentCollection().size(); n++)
            {
                ArrayList<SubjectStudent> tempArray = (ArrayList<SubjectStudent>) students.get(i).getSubjectStudentCollection();
                for (int o = 0; o < tempArray.size(); o++)
                {
                    arraySubjects.add(tempArray.get(o).getSubject());
                }
                for (int j = 0; j < tempArray.size(); j++)
                {
                dtoStudents.add(Assembler.StudentObjectToDTOStudent(students.get(i), arraySubjects));
                }
           }
        }
        // ER IKKE TESTET!!!!
        return dtoStudents;
    }
    @Override
    public DTOStudent getStudent(int id) 
    {
        Query query = em.createNamedQuery("Student.findByIdStudent");
        query.setParameter("id_student", id);
        Student student = (Student) query.getSingleResult();
        ArrayList<SubjectStudent> subjects = (ArrayList<SubjectStudent>) student.getSubjectStudentCollection();
        ArrayList<Subject> arrSubjects = new ArrayList<>();
        for (int i = 0; i < subjects.size(); i++){
            arrSubjects.add(subjects.get(i).getSubject());
        }
        DTOStudent dtoStudent = Assembler.StudentObjectToDTOStudent(student, arrSubjects);
        // ER IKKE TESTET!!!!!!!
        return dtoStudent;
    }
    @Override
    public ArrayList<DTOTeacher> getTeachers() 
    {
        Query query = em.createNamedQuery("Teacher.findAll");
        ArrayList<Teacher> teachers = (ArrayList<Teacher>) query.getResultList();
        ArrayList<DTOTeacher> dtoTeachers = new ArrayList<>();
        for (int i = 0; i < teachers.size(); i++){
            dtoTeachers.add(Assembler.TeacherObjectToDTOTeacher(teachers.get(i)));
        }
        // ER IKKE TESTET!!!!!!!!
        return dtoTeachers;
    }
    @Override
    public DTOTeacher getTeacher(int id, String name) 
    {
        Query query = em.createNamedQuery("Teacher.findByIdTeacher");
        query.setParameter("id_teacher", id);
        Teacher teacher = (Teacher) query.getSingleResult();
        // ER IKKE TESTET!!!!!!!
        return Assembler.TeacherObjectToDTOTeacher(teacher);
    }
    @Override
    public ArrayList<DTOSubject> getSubjects() 
    {
        Query query = em.createNamedQuery("Subject.findAll");
        Collection subject = query.getResultList();
        Collection<DTOSubject> subjects = Assembler.CreateSubjects(subject);
        ArrayList<DTOSubject> subs = new ArrayList();
        for (DTOSubject ret : subjects) {
            subs.add(ret);
        }
        // ER IKKE TESTET!!!!
        return subs;
    }
    @Override
    public DTOSubject getSubject(int id) 
    {
        Query query = em.createNamedQuery("Subject.findByIdSubject");
        query.setParameter("id_subject", id);
        Subject subject = (Subject) query.getSingleResult();
        DTOSubject dtoSubject = Assembler.SubjectObjectToDTOSubject(subject);
        // ER IKKE TESTET!!!!
        return dtoSubject;
    }
    @Override
    public void setPool(int id, String pool) 
    {
        
    }
    @Override
    public void setSubjectStudent(int studentId, int subjectId, String pool, int priority) 
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public void setSubjectTeacher(int teacherId, int subjectId) 
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public boolean validateLogin(String username, String password) 
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public void persist(Object object) 
    {
        em.persist(object);
    }
}