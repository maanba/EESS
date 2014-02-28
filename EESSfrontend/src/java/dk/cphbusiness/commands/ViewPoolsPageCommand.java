
package dk.cphbusiness.commands;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Riboe
 */
public class ViewPoolsPageCommand extends TargetCommand {

    public ViewPoolsPageCommand(String target) {
        super(target);
    }

    @Override
    public String execute(HttpServletRequest request) {
        List list = new ArrayList();
        
        list.add("Game Dev - TOB - 12 - 5");
        list.add("C# - TOR - 13 - 7");
        list.add("Android - PELO - 20 - 3");
        list.add("System Development - TOB - 8 - 10");
        
        request.setAttribute("subjects_none", list);
        
        return super.execute(request);
    }
    
    
}
