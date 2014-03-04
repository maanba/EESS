
package dk.cphbusiness.interfaces;

import dto.DTOStudent;
import dto.DTOSubject;
import java.util.ArrayList;

/**
 *
 * @author Riboe
 */
public interface Factory {

    Command getCommand(String command);
    
    ArrayList<DTOSubject> getSubjects();
    ArrayList<DTOStudent> getStudents();
}