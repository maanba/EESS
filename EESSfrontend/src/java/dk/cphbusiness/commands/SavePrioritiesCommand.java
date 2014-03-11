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
        DTOStudent student = instance.getStudent(200);

        DTOSubject[] firstPriorities = new DTOSubject[2];
        DTOSubject[] secondPriorities = new DTOSubject[2];
        for (int n = 0; n < list.size(); n++) {
            for (int i = 0; i < checked.length; i++) {
                String[] temp = checked[i].split(",");
                if (temp[0].equals(n + "")) {
                    System.out.println(temp[1]);
                    if (temp[1].equals(1 + "")) {
                        if (firstPriorities[0] == null) {
                            firstPriorities[0] = list.get(n);
                        } else {
                            firstPriorities[1] = list.get(n);
                        }
                    }
                    if (temp[1].equals(2 + "")) {
                        if (secondPriorities[0] == null) {
                            secondPriorities[0] = list.get(n);
                        } else {
                            secondPriorities[1] = list.get(n);
                        }
                    }
                }
            }
        }
        for (int i = 0;i<firstPriorities.length;i++){
            if (firstPriorities[i].getTeacher() == null){
                firstPriorities[i].setTeacher("No teachers");
            }
            if (firstPriorities[i].getFirstElectiveRound() == null){
                // SKAL GIVETVIS ÆNDRES
                firstPriorities[i].setFirstElectiveRound("Y");
            }
            if (firstPriorities[i].getPool() == null){
                // SKAL GIVETVIS ÆNDRES
                firstPriorities[i].setPool("A");
            }
            System.out.println(firstPriorities[i].getId());
            System.out.println(firstPriorities[i].getDescription());
            System.out.println(firstPriorities[i].getSubjectName());
            System.out.println(firstPriorities[i].getTeacher());
            System.out.println(firstPriorities[i].getFirstElectiveRound());
            System.out.println(firstPriorities[i].getPool());
        }
        for (int i = 0;i<secondPriorities.length;i++){
            if (secondPriorities[i].getPool() == null){
                secondPriorities[i].setPool("A");
            }
            System.out.println(secondPriorities[i].getId());
            System.out.println(secondPriorities[i].getDescription());
            System.out.println(secondPriorities[i].getSubjectName());
            System.out.println(secondPriorities[i].getTeacher());
            System.out.println(secondPriorities[i].getFirstElectiveRound());
            System.out.println(secondPriorities[i].getPool());
        }
        System.out.println(student.toString());
        
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
