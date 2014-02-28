
package dk.cphbusiness.interfaces;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Riboe
 */
public interface Command {

    String execute(HttpServletRequest request);
}