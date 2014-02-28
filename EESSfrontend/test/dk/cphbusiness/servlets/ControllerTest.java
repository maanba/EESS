package dk.cphbusiness.servlets;

import dk.cphbusiness.interfaces.Command;
import dk.cphbusiness.interfaces.Factory;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.jmock.Expectations;
import org.jmock.Sequence;
import org.jmock.auto.Auto;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Rule;

/**
 *
 * @author Riboe
 */
public class ControllerTest {

    @Rule
    public JUnitRuleMockery context = new JUnitRuleMockery();

    @Auto
    Sequence sequence;

    private Controller controller;
    
    public ControllerTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        controller = new Controller();

    }

    @After
    public void tearDown() {
        controller = null;
    }

    @Test
    public void testForwarding() throws ServletException, IOException {
        // set up
        final HttpServletRequest request = context.mock(HttpServletRequest.class);
        final HttpServletResponse response = context.mock(HttpServletResponse.class);

        // expectations
        context.checking(new Expectations() {
            {
                oneOf(request).getParameter("command");
                will(returnValue(null));
                inSequence(sequence);
                oneOf(request).getRequestDispatcher("/index.html").forward(request, response);
            }
        });

        // execute
        controller.service(request, response);
    }

//    @Test
//    public void testCommandFactory() throws IOException, ServletException {
//        final Factory factory = context.mock(Factory.class);
//        final Command command = context.mock(Command.class);
//        final HttpServletRequest request = context.mock(HttpServletRequest.class);
//        final HttpServletResponse response = context.mock(HttpServletResponse.class);
//
//        context.checking(new Expectations() {
//            {
//                oneOf(factory).getCommand("main");
//                will(returnValue(command));
//                inSequence(sequence);
//                oneOf(command).execute(request);
//                will(returnValue("/index.html"));
//            }
//        });
//
//        controller.service(request, response); 
//    }
}
