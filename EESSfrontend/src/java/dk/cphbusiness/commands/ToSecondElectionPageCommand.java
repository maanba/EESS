/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.cphbusiness.commands;

import dk.cphbusiness.interfaces.Factory;
import dto.DTOSubject;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Ejer
 */
public class ToSecondElectionPageCommand extends TargetCommand
{

    public ToSecondElectionPageCommand(String target)
    {
        super(target);
    }

    @Override
    public String execute(HttpServletRequest request)
    {
        Factory instance = CommandFactory.getInstance();
        List<DTOSubject> list = instance.getSubjects();
        List<DTOSubject> poolA = new ArrayList<>();
        List<DTOSubject> poolB = new ArrayList<>();
        for (DTOSubject sub : list)
        {
            if (sub.getPool() != null)
            {
                switch (sub.getPool())
                {
                    case "A":
                        poolA.add(sub);
                        break;
                    case "B":
                        poolB.add(sub);
                        break;
                }
            }
        }
        request.setAttribute("poolA", poolA);
        request.setAttribute("poolB", poolB);
        request.setAttribute("poolaamount", poolA.size());
        request.setAttribute("poolbamount", poolB.size());
        return super.execute(request);
    }
}
