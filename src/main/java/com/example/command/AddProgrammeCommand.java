package com.example.command;

import com.example.entities.Programme.Certification;
import com.example.entities.Programme.Degree;
import com.example.entities.Programme.Diploma;
import com.example.service.StudentService;

public class AddProgrammeCommand implements ICommand {
	
	private StudentService studentService;
	
	public AddProgrammeCommand(StudentService studentService)
	{
		this.studentService = studentService;
	}

	@Override
	public void invoke(String[] tokens) {
		
		String programmeName = tokens[1];
		int count = Integer.parseInt(tokens[2]);
		
		if(programmeName.equalsIgnoreCase("CERTIFICATION"))
		{
			for(int i=1;i<=count;++i)
			studentService.addProgramme(new Certification());
		}
		
		if(programmeName.equalsIgnoreCase("DEGREE"))
		{
			for(int i=1;i<=count;++i)
			studentService.addProgramme(new Degree());
		}
		
		if(programmeName.equalsIgnoreCase("DIPLOMA"))
		{
			for(int i=1;i<=count;++i)
		   studentService.addProgramme(new Diploma());
		}
		
	}

}
