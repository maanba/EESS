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
public class DTOStudent implements Serializable
{
    private static final long serialVersionUID = 1L;
    private int id;
    private String name;
    private DTOSubject[] firstPriorities;
    private DTOSubject[] secondPriorities;
    
    public DTOStudent()
    {
    }
    
    public DTOStudent(int id, String name) 
    {
        this.id = id;
        this.name = name;
        firstPriorities = null;
        secondPriorities = null;
    }

    public DTOStudent(int id, String name, DTOSubject[] firstPriorities, DTOSubject[] secondPriorities) {
        this.id = id;
        this.name = name;
        this.firstPriorities = firstPriorities;
        this.secondPriorities = secondPriorities;
    }

    public DTOSubject[] getFirstPriorities() {
        return firstPriorities;
    }

    public DTOSubject[] getSecondPriorities() {
        return secondPriorities;
    }

    public void setFirstPriorities(DTOSubject[] firstPriorities) {
        this.firstPriorities = firstPriorities;
    }

    public void setSecondPriorities(DTOSubject[] secondPriorities) {
        this.secondPriorities = secondPriorities;
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
