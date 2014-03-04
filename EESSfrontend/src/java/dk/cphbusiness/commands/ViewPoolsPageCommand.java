package dk.cphbusiness.commands;

import dk.cphbusiness.interfaces.Factory;
import dto.DTOStudent;
import dto.DTOSubject;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Riboe
 */
public class ViewPoolsPageCommand extends TargetCommand
{

    public ViewPoolsPageCommand(String target)
    {
        super(target);
    }

    @Override
    public String execute(HttpServletRequest request)
    {
        Factory instance = CommandFactory.getInstance();
        List<DTOSubject> list = instance.getSubjects();
        List listnone = new ArrayList();
        List lista = new ArrayList();
        List listb = new ArrayList();

        for (DTOSubject subject : list)
        {
            if ("A".equals(subject.getPool()))
            {
                lista.add(subject.getSubjectName() + " - " + subject.getTeacher() + " - " + subject.getFirstElectiveRound());
            } else if ("B".equals(subject.getPool()))
            {
                listb.add(subject.getSubjectName() + " - " + subject.getTeacher() + " - " + subject.getFirstElectiveRound());
            } else
            {
                listnone.add(subject.getSubjectName() + " - " + subject.getTeacher() + " - " + subject.getFirstElectiveRound());
            }
        }
        request.setAttribute("subjects_none", listnone);
        request.setAttribute("subjects_a", lista);
        request.setAttribute("subjects_b", listb);
        
        
        ArrayList<DTOStudent> students = instance.getStudents();
        request.setAttribute("student_list", students);
        
        

        return super.execute(request);
    }

}
