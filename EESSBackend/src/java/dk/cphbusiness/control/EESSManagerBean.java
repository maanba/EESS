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
    public ArrayList<DTOStudent> getStudents() {
        Query query = em.createNamedQuery("Student.findAll");
        Collection students = new ArrayList<>();
        students = query.getResultList();
        //SKAL ÆNDRES TIL FX: assambler.createDTOStudents(students);
        return null;
    }

    @Override
    public DTOStudent getStudent(int id) {
        Query query = em.createNamedQuery("Student.findByIdStudent");
        query.setParameter("id_student", id);
        Student student = (Student) query.getSingleResult();
        //SKAL ÆNDRES TIL FX: assambler.createDTOStudent(student);
        return null;
    }

    @Override
    public ArrayList<DTOTeacher> getTeachers() {
        Query query = em.createNamedQuery("Teacher.findAll");
        Collection teachers = new ArrayList<>();
        teachers = query.getResultList();
        //SKAL ÆNDRES TIL FX: assambler.createDTOTeachers(teachers);
        return null;
    }

    @Override
    public DTOTeacher getTeacher(int id, String name) {
        Query query = em.createNamedQuery("Teachet.findByIdTeacer");
        query.setParameter("id_student", id);
        Student student = (Student) query.getSingleResult();
        //SKAL ÆNDRES TIL FX: assambler.createDTOStudent(student);
        return null;
    }

    @Override
    public ArrayList<DTOSubject> getSubjects() {
        Query query = em.createNamedQuery("Subject.findAll");
        Collection subject = query.getResultList();
        Collection<DTOSubject> subjects = Assembler.CreateSubjects(subject);
        ArrayList<DTOSubject> subs = new ArrayList();
        for (DTOSubject ret : subjects) {
            subs.add(ret);
        }
        return subs;
    }

    @Override
    public DTOSubject getSubject(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setPool(int id, String pool) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setSubjectStudent(int studentId, int subjectId, String pool, int priority) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setSubjectTeacher(int teacherId, int subjectId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean validateLogin(String username, String password) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void persist(Object object) {
        em.persist(object);
    }
}
