package dk.cphbusiness.commands;

import dk.cphbusiness.interfaces.Factory;
import dto.DTOStudent;
import dto.DTOSubject;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

public class SavePrioritiesCommand extends TargetCommand
{

    public SavePrioritiesCommand(String target)
    {
        super(target);
    }

    @Override
    public String execute(HttpServletRequest request)
    {
        Factory instance = CommandFactory.getInstance();
        List<DTOSubject> list = instance.getSubjects();
        String[] checked = request.getParameter("checked").split(";");
        DTOStudent student = instance.getStudent(200);
        DTOSubject[] firstPriorities = new DTOSubject[2];
        DTOSubject[] secondPriorities = new DTOSubject[2];

        String[] pairs = request.getParameter("checked").split(";");
        for (String pair : pairs)
        {
            String[] pairSplit = pair.split(",");
            int priority = Integer.parseInt(pairSplit[2]);
            int id = Integer.parseInt(pairSplit[1]);
            DTOSubject[] subs;
            if (priority == 1)
            {
                subs = firstPriorities;
            } else
            {
                subs = secondPriorities;
            }
            for (DTOSubject subject : list)
            {
                if (subject.getId() == id && subs[0] == null)
                {
                    subs[0] = subject;
                } else if (subject.getId() == id)
                {
                    subs[1] = subject;
                }
            }
        }
        student.setFirstPriorities(firstPriorities);
        student.setSecondPriorities(secondPriorities);

        instance.setPriorities(student);

        request.setAttribute("status", "Your selections have been saved.");

        return super.execute(request);
    }
}
