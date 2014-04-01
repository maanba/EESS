/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author danielthomsen1990
 */
public class DTOTeacher implements Serializable
{

    private static final long serialVersionUID = 1L;

    private int id;
    private String name;
    private String intials;
    private ArrayList subject;

    public DTOTeacher()
    {
    }

    public DTOTeacher(int id, String name, String intials)
    {
        this.id = id;
        this.name = name;
        this.intials = intials;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getIntials()
    {
        return intials;
    }

    public void setIntials(String initials)
    {
        this.intials = initials;
    }
}
