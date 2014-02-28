
package dk.cphbusiness.commands;

import dk.cphbusiness.interfaces.Command;
import dk.cphbusiness.interfaces.Factory;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Riboe
 */
public class CommandFactory implements Factory {

    private static Factory instance;
    private Map<String, Command> commands = new HashMap();
    
    private CommandFactory() {
        commands.put("main", new TargetCommand("/index.html"));
    }
    
    public static Factory getInstance(){
        if(instance == null){
            instance = new CommandFactory();
        }
        return instance;
    }
    
    @Override
    public Command getCommand(String command) {
        return commands.get(command);
    }
}