/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dk.cphbusiness.control;

import javax.ejb.Remote;

/**
 *
 * @author Ejer
 */
@Remote
public interface EESSManagerBeanRemote {

    void businessMethod();
    
}
