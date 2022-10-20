package com.generation.service;

import com.generation.model.Course;
import com.generation.model.Student;

import java.util.HashMap;
import java.util.Map;

public class StudentService
{
    private final Map<String, Student> students = new HashMap<>();

    public void subscribeStudent( Student student )
    {
        students.put( student.getId(), student );
    }

    public Student findStudent( String studentId )
    {
        if ( students.containsKey( studentId ) )
        {
            return students.get( studentId );
        }
        return null;
    }

    public boolean isSubscribed( String studentId )
    {
        return students.containsKey(studentId);
        
    }

    public void showSummary()
    {
        for(Map.Entry<String, Student> entry:students.entrySet()) {
        System.out.println("StudentId: " + entry.getKey());
        System.out.println("Student: " + entry.getValue());
        }
    }

    public void enrollToCourse( String studentId, Course course )
    {
        if ( students.containsKey( studentId ) )
        {
            students.get( studentId ).enrollToCourse( course );
        }
    }

	public void gradeStudent(Student student) {
		double studentGrade=0;
		int totalCredits=0;
		for(Course course : student.getCourses()){
			totalCredits += course.getCredits();
			
		}
		studentGrade=totalCredits/student.getCourses().size();
		System.out.println("Student Grade: " + studentGrade);
		
	}


}
