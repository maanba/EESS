package dk.cphbusiness.commands;

import contract.EessInterface;
import dk.cphbusiness.control.EESSManagerBeanRemote;
import dk.cphbusiness.interfaces.Command;
import dk.cphbusiness.interfaces.Factory;
import dto.DTOStudent;
import dto.DTOSubject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author Riboe
 */
public class CommandFactory implements Factory {

    private static Factory instance;
    private Map<String, Command> commands = new HashMap();
    private EessInterface managerBean = lookupManagerBeanRemote();

    private CommandFactory() {
        commands.put("main", new TargetCommand("/main.jsp"));
        commands.put("manage_pools", new ViewPoolsPageCommand("/adm_pools.jsp"));
        commands.put("savePriorities", new SavePrioritiesCommand(("/main.jsp")));
        commands.put("toFirstElectionPage", new ToFirstElectionPageCommand(("/first_election.jsp")));
        commands.put("toSecondElectionPage", new ToSecondElectionPageCommand(("/Second_election.jsp")));
    }

    public static Factory getInstance() {
        if (instance == null) {
            instance = new CommandFactory();
        }
        return instance;
    }

    @Override
    public Command getCommand(String command) {
        return commands.get(command);
    }
    
    @Override
    public ArrayList<DTOStudent> getStudents(){
        return managerBean.getStudents();
    }
    
    @Override
    public ArrayList<DTOSubject> getSubjects(){
        return managerBean.getSubjects();
    }

    private EessInterface lookupManagerBeanRemote() {
        try {
            Context c = new InitialContext();
            return (EessInterface) c.lookup("java:global/EESSBackend/EESSManagerBean!contract.EessInterface");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
}
