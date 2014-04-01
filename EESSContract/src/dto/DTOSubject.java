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
public class DTOSubject implements Serializable
{

    private static final long serialVersionUID = 1L;
    private int id;
    private String subjectName;
    private String description;
    private String teacher;
    private String pool;
    private String firstElectiveRound;
    private String isFinal;

    public DTOSubject()
    {
    }

    public DTOSubject(int id, String subjectName, String description, String teacher, String pool, String firstElectiveRound, String isFinal)
    {
        this.id = id;
        this.subjectName = subjectName;
        this.description = description;
        this.teacher = teacher;
        this.pool = pool;
        this.firstElectiveRound = firstElectiveRound;
        this.isFinal = isFinal;
    }

    public String getIsFinal()
    {
        return isFinal;
    }

    public void setIsFinal(String isFinal)
    {
        this.isFinal = isFinal;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getSubjectName()
    {
        return subjectName;
    }

    public void setSubjectName(String subjectName)
    {
        this.subjectName = subjectName;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getTeacher()
    {
        return teacher;
    }

    public void setTeacher(String teacher)
    {
        this.teacher = teacher;
    }

    public String getPool()
    {
        return pool;
    }

    public void setPool(String pool)
    {
        this.pool = pool;
    }

    public String getFirstElectiveRound()
    {
        return firstElectiveRound;
    }

    public void setFirstElectiveRound(String firstElectiveRound)
    {
        this.firstElectiveRound = firstElectiveRound;
    }

}
