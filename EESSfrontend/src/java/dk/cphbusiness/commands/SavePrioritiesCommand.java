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
        System.out.println("hej" + request.getParameter("checked"));
        String[] checked = request.getParameter("checked").split(";");
        DTOStudent student = instance.getStudent(200);
        DTOSubject[] Arr1 = new DTOSubject[1];
        DTOSubject[] Arr2 = new DTOSubject[1];
        DTOSubject[] Arr3 = new DTOSubject[1];
        DTOSubject[] Arr4 = new DTOSubject[1];

        System.out.println(checked.length);
        DTOSubject[] firstPriorities = new DTOSubject[2];
        DTOSubject[] secondPriorities = new DTOSubject[2];
        for (int n = 0; n < list.size(); n++)
        {
            String[] check1 = checked[0].split(",");
            if(check1[3].equals("A")){
                if(check1[2].equals(1 + "")){
                    if((list.get(n).getId()+"").equals(check1[1]))
                    {
                        firstPriorities[0] = list.get(n);
                        System.out.println("1. prioritet, pulje A: check1[1], bør blive 5, bliver: " + check1[1]);
                    }
                }
                else if(check1[2].equals(2 + ""))
                {
                    if((list.get(n).getId()+"").equals(check1[1]))
                    {
                        firstPriorities[1] = list.get(n);
                        System.out.println("2. prioritet, pulje A: check1[1], bør blive 5, bliver: " + check1[1]);
                    }
                }
            }
            String[] check2 = checked[1].split(",");
            if(check2[3].equals("A")){
                if(check2[2].equals(1 + "")){
                    if((list.get(n).getId()+"").equals(check2[1]))
                    {
                        firstPriorities[0] = list.get(n);
                        System.out.println("1. prioritet, pulje A: check2[1], bør blive 2, bliver: " + check2[1]);
                    }
                }
                else if(check2[2].equals(2 + ""))
                {
                    if((list.get(n).getId()+"").equals(check2[1]))
                    {
                        firstPriorities[1] = list.get(n);
                        System.out.println("2. prioritet, pulje A: check2[1], bør blive 2, bliver: " + check2[1]);
                    }
                }
            }
            String[] check3 = checked[2].split(",");
            if(check3[3].equals("B")){
                if(check3[2].equals(1 + "")){
                    if((list.get(n).getId()+"").equals(check3[1]))
                    {
                        secondPriorities[0] = list.get(n);
                        System.out.println("1. prioritet, pulje B: check3[1], bør blive 8, bliver: " + check3[1]);
                    }
                }
                else if(check3[2].equals(2 + ""))
                {
                    if((list.get(n).getId()+"").equals(check3[1]))
                    {
                        secondPriorities[1] = list.get(n);
                        System.out.println("2. prioritet, pulje B: check3[1], bør blive 8, bliver: " + check3[1]);
                    }
                }
            }
            String[] check4 = checked[3].split(",");
            if(check4[3].equals("B")){
                if(check4[2].equals(1 + "")){
                    if((list.get(n).getId()+"").equals(check4[1]))
                    {
                        secondPriorities[0] = list.get(n);
                        System.out.println("1. prioritet, pulje B: check4[1], bør blive 6, bliver: " + check4[1]);
                    }
                }
                else if(check4[2].equals(2 + ""))
                {
                    if((list.get(n).getId()+"").equals(check4[1]))
                    {
                        secondPriorities[1] = list.get(n);
                        System.out.println("2. prioritet, pulje B: check4[1], bør blive 6, bliver: " + check4[1]);
                    }
                }
            }            
        }
        // den her skal laves OOOMMM!!!
        student.setFirstPriorities(firstPriorities);
        
        instance.setPriorities(student);
        
        return super.execute(request);
    }

}
