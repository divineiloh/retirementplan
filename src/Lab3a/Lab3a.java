//Author: Divine Iloh
//BINS 5312
//Date: 02/13/2022

package Lab3a;
import java.util.Scanner;
public class Lab3a {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		//initialize program variables
		double shift1Pay = 17;
		double shift2Pay = 18.50;
		double shift3Pay = 22;
		int fullWeek = 40;
		int shift;
		double OTRate = 1.5;
		boolean isRetirement = false;
		double hours, hourlyRate, regPay, OTPay, OTHours;
		double grossPay, netPay = 0, retDeduction = 0;
		String retirement = null;
		
		
		//scanner for input
		Scanner inputDevice = new Scanner (System.in);
		System.out.println("Enter hours worked >>>>>> ");
		hours = inputDevice.nextDouble();
		
		//ask user to choose shift and receive input  from user.
		System.out.println("Enter Your Shift (1, 2, or 3) >>>>>> ");
		shift = inputDevice.nextInt();
		
		
		if (shift == 2)
		{
			hourlyRate = shift2Pay;
			System.out.println("Contribute to retirement? (Y = Yes, N = No) >>>>> ");  //receive input from user to determine if they want retirement plan
			retirement = inputDevice.next();
			

			if (retirement.equals("Y"))
			{
				isRetirement = true;					//set isRetirement to true if user wants retirement plan and vice versa
			}
			else
			{
				isRetirement = false;
			}
			
		}
		else if (shift == 3)
		{
			hourlyRate = shift3Pay;
			System.out.println("Contribute to retirement? (Y = Yes, N = No) >>>>> ");			//receive input from user to determine if they want retirement plan
			retirement = inputDevice.next();
			if (retirement.equals("Y"))
			{
				isRetirement = true; 		//set isRetirement to true if user wants retirement plan and vice versa
			}
			else
			{
				isRetirement = false;
			}
		}
		else
		{
			isRetirement = false;
			hourlyRate = shift1Pay;
		}	
		
		//compute gross pay
		if (hours > fullWeek)
		{
			OTHours = hours - fullWeek;
			
			regPay = fullWeek * hourlyRate;
			OTPay = (OTHours * (hourlyRate * OTRate));
			grossPay = regPay + OTPay;
			
			if (isRetirement == true)
			{

				retDeduction = 0.03 * grossPay; 		//compute retirement deduction
				netPay = grossPay - retDeduction;
			}
			
			else
			{
				retDeduction =  0;
				netPay = grossPay - retDeduction;
			}
		}
		else
		{
			OTHours = 0;
			
			grossPay = hours * hourlyRate;		//calculate gross pay
			regPay = fullWeek * hourlyRate;		//calculate regular pay
			OTPay = 0;							//initialize over time pay
		}
		
		//display output
		System.out.println(" \n" +
				"Hours:" + hours + "\n" +
				"Shift: " + shift + "\n" +
				"Pay Rate: " + hourlyRate + "\n" +
				"Regular Pay: " + regPay + "\n" +
				"Overtime Pay: " + OTPay + "\n" +
				"Gross Pay: " + grossPay + "\n" +
				"Retirement Deductions: " + retDeduction + "\n" +
				"Net Pay: " + netPay);
		
	}

}
