/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import dto.DTOStudent;
import dto.DTOTeacher;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ejer
 */
public class ManagerTest 
{
    ArrayList<DTOStudent> students;
    DTOStudent student;
    ArrayList<DTOTeacher> teachers;
    public ManagerTest() 
    {
    }
    
    @BeforeClass
    public static void setUpClass() 
    {
    }
    
    @AfterClass
    public static void tearDownClass() 
    {
    }
    
    @Before
    public void setUp() 
    {
        students = new ArrayList<>();
        student = new DTOStudent();
    }
    
    @After
    public void tearDown() 
    {
    }
    
    @Test
    public ArrayList<DTOStudent> getStudents()
    {
        assertNotNull(students);
        assertTrue(students.size() == 3);
        return students;
    }
    
    @Test
    public DTOStudent getStudent()
    {
        assertNotNull(student);
        assertNotNull(student.getName());
        assertNotNull(student.getId());
        return student;
    }
    
    @Test
    public ArrayList<DTOTeacher> getTeachers()
    {
        assertNotNull(teachers);
        assertTrue(teachers.size() == 3);
        return teachers;
    }
}
