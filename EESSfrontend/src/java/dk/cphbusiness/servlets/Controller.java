
package dk.cphbusiness.servlets;

import dk.cphbusiness.commands.CommandFactory;
import dk.cphbusiness.interfaces.Command;
import dk.cphbusiness.interfaces.Factory;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Riboe
 */
@WebServlet(urlPatterns = {"/Controller"})
public class Controller extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = "/index.html";
        String commandString = request.getParameter("command");
        commandString = "main";
        Factory f = CommandFactory.getInstance();
        Command command = f.getCommand(commandString);
        path = command.execute(request);
        request.getRequestDispatcher(path).forward(request, response);
    }
}