package com.example.command;

import com.example.service.StudentService;

public class PrintBillCommand implements ICommand {
	
	private StudentService studentService;
	
	public PrintBillCommand(StudentService studentService)
	{
		this.studentService = studentService;
	}

	@Override
	public void invoke(String tokens[]) {
		
		studentService.printBill();
	}

}
