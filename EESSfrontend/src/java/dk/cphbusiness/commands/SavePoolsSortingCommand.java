package dk.cphbusiness.commands;

import com.google.gson.Gson;
import dto.DTOStudent;
import dto.DTOSubject;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import org.jboss.weld.bean.builtin.FacadeInjectionPoint;

/**
 *
 * @author Riboe
 */
public class SavePoolsSortingCommand extends TargetCommand
{

    public SavePoolsSortingCommand(String target)
    {
        super(target);
    }

    @Override
    public String execute(HttpServletRequest request)
    {
        ArrayList<DTOSubject> subjects = new ArrayList<>();
        String[] subjectsNone = request.getParameterValues("subjects_none");
        String[] subjectsA = request.getParameterValues("subjects_a");
        String[] subjectsB = request.getParameterValues("subjects_b");

        Gson g = new Gson();

        if (subjectsNone != null)
        {
            for (String s : subjectsNone)
            {
                DTOSubject subj = g.fromJson(s, DTOSubject.class);
                subj.setPool(null);
                subjects.add(subj);
            }
        }
        if (subjectsA != null)
        {
            for (String s : subjectsA)
            {
                DTOSubject subj = g.fromJson(s, DTOSubject.class);
                subj.setPool("A");
                subjects.add(subj);
            }
        }
        if (subjectsB != null)
        {
            for (String s : subjectsB)
            {
                DTOSubject subj = g.fromJson(s, DTOSubject.class);
                subj.setPool("B");
                subjects.add(subj);
            }
        }
        CommandFactory.getInstance().setSubjects(subjects);
        return super.execute(request); //To change body of generated methods, choose Tools | Templates.
    }
}
