
package dk.cphbusiness.interfaces;

/**
 *
 * @author Riboe
 */
public interface Factory {

    Command getCommand(String command);
}