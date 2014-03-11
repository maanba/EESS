
package dk.cphbusiness.commands;

import com.google.gson.Gson;
import dto.DTOStudent;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Riboe
 */
public class SavePoolsSortingCommand extends TargetCommand {

    public SavePoolsSortingCommand(String target) {
        super(target);
    }

    @Override
    public String execute(HttpServletRequest request) {
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        String[] students = request.getParameterValues("student");
        Gson g = new Gson();
        
        for (String s : students) {
            DTOStudent stud = g.fromJson(s, DTOStudent.class);
            System.out.println(stud.getName());
        }
        
        return super.execute(request); //To change body of generated methods, choose Tools | Templates.
    }
}