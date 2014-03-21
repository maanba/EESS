package dk.cphbusiness.commands;

import dk.cphbusiness.interfaces.Factory;
import dto.DTOStudent;
import dto.DTOSubject;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

public class SavePrioritiesCommand extends TargetCommand {

    public SavePrioritiesCommand(String target) {
        super(target);
    }

    @Override
    public String execute(HttpServletRequest request) {
        // skal gøres at den gemmer pool, fra second election og en slags null værdi i pool fra first election
        Factory instance = CommandFactory.getInstance();
        List<DTOSubject> list = instance.getSubjects();
        String[] checked = request.getParameter("checked").split(";");
        DTOStudent student = instance.getStudent(200);
        DTOSubject[] firstPriorities = new DTOSubject[2];
        DTOSubject[] secondPriorities = new DTOSubject[2];

        for (int i = 0; i < checked.length; i++)
        {
            System.out.println(checked[i]);
        }
        for (int n = 0; n < list.size(); n++)
        {
            String[] check1 = checked[0].split(",");
                if(check1[2].equals(1 + "")){
                    if((list.get(n).getId()+"").equals(check1[1]))
                    {
                        firstPriorities[0] = list.get(n);
                    }
                }
                else if(check1[2].equals(2 + ""))
                {
                    if((list.get(n).getId()+"").equals(check1[1]))
                    {
                        secondPriorities[0] = list.get(n);
                    }
                }
            
            String[] check2 = checked[1].split(",");
                if(check2[2].equals(1 + "")){
                    if((list.get(n).getId()+"").equals(check2[1]))
                    {
                        firstPriorities[0] = list.get(n);
                    }
                }
                else if(check2[2].equals(2 + ""))
                {
                    if((list.get(n).getId()+"").equals(check2[1]))
                    {
                        secondPriorities[0] = list.get(n);
                    }
                }
            
            String[] check3 = checked[2].split(",");
                if(check3[2].equals(1 + "")){
                    if((list.get(n).getId()+"").equals(check3[1]))
                    {
                        firstPriorities[1] = list.get(n);
                    }
                }
                else if(check3[2].equals(2 + ""))
                {
                    if((list.get(n).getId()+"").equals(check3[1]))
                    {
                        secondPriorities[1] = list.get(n);
                    }
                }
            
            String[] check4 = checked[3].split(",");
                if(check4[2].equals(1 + "")){
                    if((list.get(n).getId()+"").equals(check4[1]))
                    {
                        firstPriorities[1] = list.get(n);
                    }
                }
                else if(check4[2].equals(2 + ""))
                {
                    if((list.get(n).getId()+"").equals(check4[1]))
                    {
                        secondPriorities[1] = list.get(n);
                    }
                }
            
        }
        student.setFirstPriorities(firstPriorities);
        student.setSecondPriorities(secondPriorities);
        
        instance.setPriorities(student);
        
        return super.execute(request);
    }

}
