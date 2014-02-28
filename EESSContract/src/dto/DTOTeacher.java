/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dto;

import java.io.Serializable;

/**
 *
 * @author danielthomsen1990
 */
public class DTOTeacher implements Serializable
{
    private static final long serialVersionUID = 1L;
    
    private int id;
    private String name;
    
    public DTOTeacher()
    {
    }
    
    public DTOTeacher (int id, String name)
    {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}