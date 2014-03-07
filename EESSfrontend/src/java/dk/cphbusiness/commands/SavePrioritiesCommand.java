package dk.cphbusiness.commands;

import dk.cphbusiness.interfaces.Factory;
import dto.DTOSubject;
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

        for (int n = 0; n < list.size(); n++) 
        {
            for (int i = 0; i < checked.length; i++) 
            {
                String[] temp = checked[i].split(",");
                if(temp[0] == n)
                {
                    list.get(n).setPool(null);
                }
            }
        }

//        for(int i = 0; i < list.size(); i++)
//        {
//            String subjName = request.getParameter(list.get(i).getId()+"");
//            System.out.println(subjName + " er subjName");
//        }
        return super.execute(request);
    }

}
