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
public class DTOStudent implements Serializable
{
    private static final long serialVersionUID = 1L;
    private int id;
    private String name;
    private ArrayList<DTOSubject> subjects;
    
    public DTOStudent()
    {
    }
    
    public DTOStudent(int id, String name) 
    {
        this.id = id;
        this.name = name;
    }
    
    public void addSubject (DTOSubject subject)
    {
        subjects.add(subject);
    }

    public int getId() {
        return id;
    }

    public ArrayList<DTOSubject> getSubjects() {
        return subjects;
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
