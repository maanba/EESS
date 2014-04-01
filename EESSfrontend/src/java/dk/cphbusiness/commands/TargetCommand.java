package dk.cphbusiness.commands;

import dk.cphbusiness.interfaces.Command;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Riboe
 */
public class TargetCommand implements Command
{

    private String target;

    public TargetCommand(String target)
    {
        this.target = target;
    }

    @Override
    public String execute(HttpServletRequest request)
    {
        return target;
    }
}
