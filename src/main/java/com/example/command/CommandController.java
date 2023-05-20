package com.example.command;

import com.example.service.CouponService;
import com.example.service.StudentService;

public class CommandController {
	
	private static AddProgrammeCommand addProgrammeCommand = null;
	private static AddProMembershipCommand addProMembershipCommand = null;
	private static ApplyCouponCommand applyCouponCommand = null;
	private static PrintBillCommand printBillCommand = null;
	
	public CommandController(StudentService studentService,CouponService couponService)
	{
		 addProgrammeCommand = new AddProgrammeCommand(studentService);
		 addProMembershipCommand = new AddProMembershipCommand(studentService);
		 applyCouponCommand = new ApplyCouponCommand(couponService);
		 printBillCommand = new PrintBillCommand(studentService);
	}
	
	public void invokeCommand(String command)
	{
		String tokens[] = command.split(" ");
		
		if(tokens[0].equalsIgnoreCase("ADD_PROGRAMME"))
		{
			addProgrammeCommand.invoke(tokens);
		}
		
		if(tokens[0].equalsIgnoreCase("APPLY_COUPON"))
		{
			 applyCouponCommand.invoke(tokens);
		}
		
		if(tokens[0].equalsIgnoreCase("ADD_PRO_MEMBERSHIP"))
		{
			addProMembershipCommand.invoke(tokens);
		}
		
		if(tokens[0].equalsIgnoreCase("PRINT_BILL"))
		{
			printBillCommand.invoke(tokens);
		}
		
	}

}
