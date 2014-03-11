/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dk.cphbusiness.commands;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Ejer
 */
public class SaveSecondElectionCommand extends TargetCommand
{

    public SaveSecondElectionCommand(String target)
    {
        super(target);
    }
    
    @Override
    public String execute(HttpServletRequest request)
    {
        return null;
    }
}
