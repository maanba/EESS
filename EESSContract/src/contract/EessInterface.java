/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package contract;

import dto.DTOStudent;
import dto.DTOSubject;
import dto.DTOTeacher;
import java.util.ArrayList;

/**
 *
 * @author danielthomsen1990
 */
public interface EessInterface 
{
    public ArrayList<DTOStudent> getStudents();
    
    public DTOStudent getStudent(int id);
    
    public ArrayList<DTOTeacher> getTeachers();
    
    public DTOTeacher getTeacher(int id, String name);
    
    public ArrayList<DTOSubject> getSubjects();
    
    public DTOSubject getSubject(int id);
    
    public void setPool(int id, String pool);
    
    public void setSubjectStudent (int studentId, int subjectId, String pool, int priority);
    
    public void setSubjectTeacher (int teacherId, int subjectId);
    
    public boolean validateLogin (String username, String password);
}
