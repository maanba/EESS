package dk.cphbusiness.commands;

import dk.cphbusiness.interfaces.Factory;
import dto.DTOStudent;
import dto.DTOSubject;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

public class SavePrioritiesCommand extends TargetCommand {

    public SavePrioritiesCommand(String target) {
        super(target);
    }

    @Override
    public String execute(HttpServletRequest request) {
        Factory instance = CommandFactory.getInstance();
        List<DTOSubject> list = instance.getSubjects();
        String[] checked = request.getParameter("checked").split(";");
        DTOStudent student = instance.getStudent(1);

        DTOSubject[] firstPriorities = new DTOSubject[2];
        DTOSubject[] secondPriorities = new DTOSubject[2];
        for (int n = 0; n < list.size(); n++) {
            for (int i = 0; i < checked.length; i++) {
                String[] temp = checked[i].split(",");
                if (temp[0].equals(n + "")) {
                    System.out.println(temp[1]);
                    if (temp[1].equals(1 + "")) {
                        System.out.println("HER1");
                        if (firstPriorities[0] == null) {
                            System.out.println("kom herind1");
                            firstPriorities[0] = list.get(n);
                        } else {
                            System.out.println("kom herind2");
                            firstPriorities[1] = list.get(n);
                        }
                    }
                    if (temp[1].equals(2 + "")) {
                        System.out.println("HER2");
                        if (secondPriorities[0] == null) {
                            System.out.println("svans2");
                            secondPriorities[0] = list.get(n);
                        } else {
                            System.out.println("svans3");
                            secondPriorities[1] = list.get(n);
                        }
                    }
                }
            }
        }
        for (int i = 0;i<secondPriorities.length;i++){
            System.out.println(secondPriorities[i].toString());
        }
        for (int i = 0;i<secondPriorities.length;i++){
            System.out.println(firstPriorities[i].toString());
        }
        
        student.setFirstPriorities(firstPriorities);
        student.setSecondPriorities(secondPriorities);

        instance.setPriorities(student);

//        for(int i = 0; i < list.size(); i++)
//        {
//            String subjName = request.getParameter(list.get(i).getId()+"");
//            System.out.println(subjName + " er subjName");
//        }
        return super.execute(request);
    }

}
