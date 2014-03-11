package dk.cphbusiness.commands;

import com.sun.xml.bind.util.ListImpl;
import dk.cphbusiness.interfaces.Factory;
import dto.DTOSubject;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

public class ToFirstElectionPageCommand extends TargetCommand
{

    public ToFirstElectionPageCommand(String target)
    {
        super(target);
    }

    @Override
    public String execute(HttpServletRequest request)
    {
        Factory instance = CommandFactory.getInstance();
        List<DTOSubject> list = instance.getSubjects();

        request.setAttribute("subjects",list);
        request.setAttribute("subamount", list.size());
        return super.execute(request);
    }
}
