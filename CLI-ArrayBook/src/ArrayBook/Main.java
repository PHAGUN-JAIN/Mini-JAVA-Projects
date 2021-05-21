package ArrayBook;

import java.util.Scanner;
import ArrayBook.Student;

public class Main
{
	public static void main(String[] args)
	{
		System.out.println("Hello");
		Student[] records_register = new Student[22];
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter name id contact and sig of student");

		int i = 0;
		while(i<5)
		{
			if(i==0)
			{
				records_register[i].name=sc.next();
			}
			if(i==1)
			{
				records_register[i].id=sc.nextInt();
			}			
			if(i==2)
			{
				records_register[i].contact=sc.next();
			}			
			if(i==3)
			{
				records_register[i].sig=sc.next();
			}

			i++;
			
		}
		
	}
}