package dk.cphbusiness.model;

import dto.DTOStudent;
import dto.DTOSubject;
import dto.DTOTeacher;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author danielthomsen1990
 */
public class Assembler
{

    public static DTOStudent StudentObjectToDTOStudent(Student student)
    {
        DTOSubject[] firsts = new DTOSubject[2];
        DTOSubject[] seconds = new DTOSubject[2];
        
        firsts[0] = Assembler.SubjectObjectToDTOSubject(student.getFirstPriorityA());
        firsts[1] = Assembler.SubjectObjectToDTOSubject(student.getFirstPriorityB());
        seconds[0] = Assembler.SubjectObjectToDTOSubject(student.getSecondPriorityA());
        seconds[1] = Assembler.SubjectObjectToDTOSubject(student.getSecondPriorityB());
        
        DTOStudent newDTOStudent = new DTOStudent(student.getIdStudent(),
                student.getStudentName(), firsts, seconds, student.getFinalA().getIdSubject(), student.getFinalB().getIdSubject());
        return newDTOStudent;
    }

    public static DTOSubject SubjectObjectToDTOSubject(Subject subject)
    {
        DTOSubject newDTOSubject
                = new DTOSubject(subject.getIdSubject(),
                        subject.getSubjectName(),
                        subject.getDescription(),
                        subject.getTeacher(),
                        subject.getPool(),
                        subject.getFirstElectiveRound(),
                        subject.getIsFinal());
        return newDTOSubject;
    }

    public static Collection<DTOSubject> CreateSubjects(Collection<Subject> subs)
    {
        Collection<DTOSubject> subjects = new ArrayList<>();
        for (Subject subject : subs)
        {
            subjects.add(SubjectObjectToDTOSubject(subject));
        }
        return subjects;
    }

    public static DTOTeacher TeacherObjectToDTOTeacher(Teacher teacher)
    {
        DTOTeacher newDTOTeacher = new DTOTeacher(teacher.getIdTeacher(),
                        teacher.getTeacherName(),
                        teacher.getIntials());
        return newDTOTeacher;
    }

    public static Student DTOStudentToStudentObject(DTOStudent dtoStudent)
    {
        Student student = new Student();
        student.setIdStudent(dtoStudent.getId());
        student.setStudentName(dtoStudent.getName());
        return student;
    }

    public static Subject DTOSubjectToSubjectObject(DTOSubject dtoSubject)
    {
        Subject subject = new Subject();
               subject.setIdSubject(dtoSubject.getId());
               subject.setSubjectName(dtoSubject.getSubjectName());
               subject.setDescription(dtoSubject.getDescription());
               subject.setTeacher(dtoSubject.getTeacher());
               subject.setPool(dtoSubject.getPool());
               subject.setFirstElectiveRound(dtoSubject.getFirstElectiveRound());
               subject.setIsFinal(dtoSubject.getIsFinal());
       return subject;
    }

    public static Teacher DTOTeacherToTeacherObject(DTOTeacher dtoTeacher)
    {
        Teacher teacher = new Teacher();
               teacher.setIdTeacher(dtoTeacher.getId());
               teacher.setIntials(dtoTeacher.getIntials());
       return teacher;
    }

}
