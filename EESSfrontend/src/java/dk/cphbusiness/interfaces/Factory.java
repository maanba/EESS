
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
    DTOStudent getStudent(int id);
    void setPriorities(DTOStudent student);
    void setSubjects(ArrayList<DTOSubject> subjects);
}