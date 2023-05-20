package com.example.command;

import com.example.service.StudentService;

public class AddProMembershipCommand implements ICommand {
	
	private StudentService studentService;
	
	public AddProMembershipCommand(StudentService studentService)
	{
		this.studentService = studentService;
	}

	@Override
	public void invoke(String tokens[]) {
		
		studentService.buyProMemberShip();

	}

}
