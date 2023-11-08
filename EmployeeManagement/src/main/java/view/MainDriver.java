package view;

import java.util.Scanner;

public class MainDriver {

public static void main(String[] args) {
	EmployeeMain main = new EmployeeMain();
	Scanner sc = new Scanner(System.in);
	
		
		boolean flag = true;
		//try {
			while (flag) {
			//	sc = new Scanner(System.in);
				
				
			
				System.out.println("1.Insert Employee");
				System.out.println("2.Search Employee by ID");
				System.out.println("3.Delete Employee by ID");
				System.out.println("4.SearchAll Employee");
				System.out.println("5.Update Employee ID");
				System.out.println("0.Exit");
				System.out.println("Enter your choice");
				int choice=sc.nextInt();
				
				switch(choice) {
				case 1:main.insertData();break;
				case 2:main.searchData();break;
				case 3:main.deleteData();break;
				case 4:main.searchAllData();break;
				case 5:main.updateData();break;
				case 0:flag=false;System.out.println("Thank You......"); break;
				}
			}
//		}catch(InputMismatchException e) {
//			System.out.println(e);
//		}catch(NoSuchElementException e) {
//			System.out.println(e);
//			e.printStackTrace();
//		}
//		
//		finally {
//			sc.close();
//		}
	}
}
