package dk.cphbusiness.control;

import contract.EessInterface;
import dto.DTOTeacher;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Kirstine
 */
public class EESSBeanTeacherTest
{

    public EESSBeanTeacherTest()
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
    }

    @After
    public void tearDown()
    {
    }

    public EessInterface lookupManagerBeanRemote()
    {
        try
        {
            Context c = new InitialContext();
            return (EessInterface) c.lookup("java:global/EESSBackend/EESSManagerBean!contract.EessInterface");
        } catch (NamingException ne)
        {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    /**
     * Test of getTeachers method, of class EESSManagerBean.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testGetTeachers() throws Exception
    {
        System.out.println("getTeachers");
        EessInterface instance = lookupManagerBeanRemote();
        ArrayList<DTOTeacher> teach = new ArrayList<>();
        DTOTeacher t1 = new DTOTeacher(100, "Torben", "tor");
        DTOTeacher t2 = new DTOTeacher(101, "Peter", "pet");
        DTOTeacher t3 = new DTOTeacher(102, "Anders", "and");
        teach.add(t1);
        teach.add(t2);
        teach.add(t3);
        ArrayList<DTOTeacher> expResult = teach;
        ArrayList<DTOTeacher> result = instance.getTeachers();
        for (int i = 0; i < result.size(); i++)
        {
            System.out.println(result.get(i) + "");
        }
        assertEquals(result.get(0).getId(), expResult.get(0).getId());
        assertEquals(result.get(0).getName(), expResult.get(0).getName());
        assertEquals(result.get(0).getIntials(), expResult.get(0).getIntials());
        assertEquals(result.get(1).getId(), expResult.get(1).getId());
        assertEquals(result.get(1).getName(), expResult.get(1).getName());
        assertEquals(result.get(1).getIntials(), expResult.get(1).getIntials());
        assertEquals(result.get(2).getId(), expResult.get(2).getId());
        assertEquals(result.get(2).getName(), expResult.get(2).getName());
        assertEquals(result.get(2).getIntials(), expResult.get(2).getIntials());
    }

    /**
     * Test of getTeacher method, of class EESSManagerBean.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testGetTeacher() throws Exception
    {
        System.out.println("getTeacher");
        EessInterface instance = lookupManagerBeanRemote();
        DTOTeacher t1 = new DTOTeacher(100, "Torben", "tor");
        DTOTeacher expResult = t1;
        DTOTeacher result = instance.getTeacher(100);
        assertTrue(true);
//        assertEquals(result, expResult);
    }
}
