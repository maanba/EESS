/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.cphbusiness.commands;

import com.google.gson.Gson;
import dk.cphbusiness.interfaces.Factory;
import dto.DTOStudent;
import dto.DTOSubject;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.servlet.SessionTrackingMode.URL;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Janne
 */
public class CreateFileCommand extends TargetCommand {

    public CreateFileCommand(String target) {
        super(target);
    }
    
    @Override
    public String execute(HttpServletRequest request) {
        Factory instance = CommandFactory.getInstance();
        List<DTOSubject> subjectList = instance.getSubjects();
        List<DTOStudent> studentList = instance.getStudents();
        
        DTOSubject subjectA = null;
        DTOSubject subjectB = null;
        DTOSubject subjectC = null;
        DTOSubject subjectD = null;
        
        ArrayList<DTOStudent> studentsSubjectA = new ArrayList<>();
        ArrayList<DTOStudent> studentsSubjectB = new ArrayList<>();
        ArrayList<DTOStudent> studentsSubjectC = new ArrayList<>();
        ArrayList<DTOStudent> studentsSubjectD = new ArrayList<>();
        
        for (int i = 0; i < subjectList.size(); i++) {
            if (subjectList.get(i).getIsFinal().equals("Y") && subjectA == null){
                subjectA = subjectList.get(i);
            }
            else if (subjectList.get(i).getIsFinal().equals("Y") && subjectB == null){
                subjectB = subjectList.get(i);
            }
            else if (subjectList.get(i).getIsFinal().equals("Y") && subjectC == null){
                subjectC = subjectList.get(i);
            }
            else if (subjectList.get(i).getIsFinal().equals("Y") && subjectD == null){
                subjectD = subjectList.get(i);
            }
        }
        for (int i = 0; i < studentList.size(); i++) {
            if (subjectA.getId() == studentList.get(i).getFinalA() || subjectA.getId() == studentList.get(i).getFinalB()){
                studentsSubjectA.add(studentList.get(i));
                System.out.println("1");
            }
            if (subjectB.getId() == studentList.get(i).getFinalA() || subjectB.getId() == studentList.get(i).getFinalB()){
                studentsSubjectB.add(studentList.get(i));
                System.out.println("2");
            }
            if (subjectC.getId() == studentList.get(i).getFinalA() || subjectC.getId() == studentList.get(i).getFinalB()){
                studentsSubjectC.add(studentList.get(i));
                System.out.println("3");
            }
            if (subjectD.getId() == studentList.get(i).getFinalA() || subjectD.getId() == studentList.get(i).getFinalB()){
                studentsSubjectD.add(studentList.get(i));
                System.out.println("4");
            }
        }
        
        String studentAString = "";
        String studentBString = "";
        String studentCString = "";
        String studentDString = "";
        for (int i = 0; i < studentsSubjectA.size(); i++){
            studentAString = studentAString.concat(studentsSubjectA.get(i).getName());
            if (i != studentsSubjectA.size()-1){
                studentAString = studentAString.concat(", ");
            }
        }
        for (int i = 0; i < studentsSubjectB.size(); i++){
            studentBString = studentBString.concat(studentsSubjectB.get(i).getName());
            if (i != studentsSubjectB.size()-1){
                studentBString = studentBString.concat(", ");
            }
        }
        for (int i = 0; i < studentsSubjectC.size(); i++){
            studentCString = studentCString.concat(studentsSubjectC.get(i).getName());
            if (i != studentsSubjectC.size()-1){
                studentCString = studentCString.concat(", ");
            }
        }
        for (int i = 0; i < studentsSubjectD.size(); i++){
            studentDString = studentDString.concat(studentsSubjectD.get(i).getName());
            if (i != studentsSubjectD.size()-1){
                studentDString = studentDString.concat(", ");
            }
        }
        
        Gson g = new Gson();
        
        String jsonA = g.toJson(subjectA);
        String jsonB = g.toJson(subjectB);
        String jsonC = g.toJson(subjectC);
        String jsonD = g.toJson(subjectD);
   
        request.setAttribute("subjectA", jsonA);
        request.setAttribute("subjectB", jsonB);
        request.setAttribute("subjectC", jsonC);
        request.setAttribute("subjectD", jsonD);
        request.setAttribute("studentsSubjectA",studentAString);
        request.setAttribute("studentsSubjectB",studentBString);
        request.setAttribute("studentsSubjectC",studentCString);
        request.setAttribute("studentsSubjectD",studentDString);
        
        StringBuilder sb = new StringBuilder();
        
        sb.append(subjectA.getSubjectName() + "\n");
        sb.append(subjectA.getTeacher() + "\n");
        sb.append(studentAString + "\n");
        sb.append("\n");
        sb.append(subjectB.getSubjectName() + "\n");
        sb.append(subjectB.getTeacher() + "\n");
        sb.append(studentBString + "\n");
        sb.append("\n");
        sb.append(subjectC.getSubjectName() + "\n");
        sb.append(subjectC.getTeacher() + "\n");
        sb.append(studentCString + "\n");
        sb.append("\n");
        sb.append(subjectD.getSubjectName() + "\n");
        sb.append(subjectD.getTeacher() + "\n");
        sb.append(studentDString + "\n");
        sb.append("\n");
        
        File f = new File(System.getProperty("user.home")+"/Documents/NetBeansProjects/EESS/EESSfrontend/web");
        
        f.mkdirs();
        f = new File(f.getAbsolutePath() + "/electivesubjects.dat");
        try (OutputStream os = Files.newOutputStream(f.toPath(), StandardOpenOption.CREATE);) {
            os.write(sb.toString().getBytes());
        } catch (IOException ex) {
            Logger.getLogger(CreateFileCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(f.getAbsolutePath());
        return super.execute(request);
    }
    
}
