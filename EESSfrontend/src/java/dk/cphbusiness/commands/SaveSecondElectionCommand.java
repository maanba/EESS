/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.cphbusiness.commands;

import dk.cphbusiness.interfaces.Factory;
import dto.DTOStudent;
import dto.DTOSubject;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Ejer
 */
public class SaveSecondElectionCommand extends TargetCommand
{

    public SaveSecondElectionCommand(String target)
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

        for (int n = 0; n < list.size(); n++)
        {
            String[] check1 = checked[0].split(",");
            if (check1[3].equals("A"))
            {
                if (check1[2].equals(1 + ""))
                {
                    if ((list.get(n).getId() + "").equals(check1[1]))
                    {
                        firstPriorities[0] = list.get(n);
                    }
                } else if (check1[2].equals(2 + ""))
                {
                    if ((list.get(n).getId() + "").equals(check1[1]))
                    {
                        secondPriorities[0] = list.get(n);
                    }
                }
            }

            String[] check2 = checked[1].split(",");
            if (check2[3].equals("A"))
            {
                if (check2[2].equals(1 + ""))
                {
                    if ((list.get(n).getId() + "").equals(check2[1]))
                    {
                        firstPriorities[0] = list.get(n);
                    }
                } else if (check2[2].equals(2 + ""))
                {
                    if ((list.get(n).getId() + "").equals(check2[1]))
                    {
                        secondPriorities[0] = list.get(n);
                    }
                }
            }

            String[] check3 = checked[2].split(",");
            if (check3[3].equals("B"))
            {
                if (check3[2].equals(1 + ""))
                {
                    if ((list.get(n).getId() + "").equals(check3[1]))
                    {
                        firstPriorities[1] = list.get(n);
                    }
                } else if (check3[2].equals(2 + ""))
                {
                    if ((list.get(n).getId() + "").equals(check3[1]))
                    {
                        secondPriorities[1] = list.get(n);
                    }
                }
            }

            String[] check4 = checked[3].split(",");
            if (check4[3].equals("B"))
            {
                if (check4[2].equals(1 + ""))
                {
                    if ((list.get(n).getId() + "").equals(check4[1]))
                    {
                        firstPriorities[1] = list.get(n);
                    }
                } else if (check4[2].equals(2 + ""))
                {
                    if ((list.get(n).getId() + "").equals(check4[1]))
                    {
                        secondPriorities[1] = list.get(n);
                    }
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
