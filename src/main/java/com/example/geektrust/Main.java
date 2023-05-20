package com.example.geektrust;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

import com.example.command.CommandController;
import com.example.entities.Student;
import com.example.service.CouponService;
import com.example.service.StudentService;

public class Main {
	public static void main(String[] args) {

		Student student = new Student();
		StudentService studentService = new StudentService(student);
		CouponService couponService = new CouponService(student);
		CommandController commandController = new CommandController(studentService, couponService);
		try {

			FileInputStream fis = new FileInputStream(args[0]);
			Scanner sc = new Scanner(fis);
			while (sc.hasNextLine()) {
				commandController.invokeCommand(sc.nextLine());
			}
			sc.close();
		} catch (IOException e) {
			
		}

		/*
		 * try { // the file to be opened for reading FileInputStream fis = new
		 * FileInputStream("sample_input/input2.txt"); Scanner sc = new Scanner(fis); //
		 * file to be scanned // returns true if there is another line to read while
		 * (sc.hasNextLine()) { commandController.invokeCommand(sc.nextLine()); }
		 * sc.close(); // closes the scanner } catch (IOException e) { }
		 */

	}
}
