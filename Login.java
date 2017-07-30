/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package Assignment;

/**
 *
 * @author valan
 */
import java.util.*;
import java.io.*;
class Database {
	//Declaration 
	String input_username,input_password;
	Scanner s;
	File f1 = new File("C:\\Eclipse Workspace\\Form\\src\\Data.txt");
// TO ADD A NEW USER TO FILE DATA>TXT
	void addEntry() throws IOException
	{
		s = new Scanner(System.in);
		System.out.println("Enter the username\t");
		input_username=s.next();
		if(check()==1) {
			System.out.println("\nThe Username Already exists");
			return;
		}
		System.out.println("Enter the password\t");
		input_password=s.next();
		s.close();
		if(f1.exists()==false)
			f1.createNewFile();
		else 
		{
			FileWriter out = new FileWriter("C:\\\\Eclipse Workspace\\\\Form\\\\src\\\\Data.txt");
			out.append(input_username+"\t"+input_password+"\n");
			out.flush();
			out.close();
		}
		
//TO EXISTENCE OF USERNAME AND PASSWORD IN FILE
	}
	int check() {
		int flag=0;Scanner f=null;
		/*
		 * Flag =1 then username exists
		 * Flag =2 if password matches user
		 * Flag =0 if username unavailable
		 * */
		//String db = FileUtils.readFileToString(f1);
		//String db = f1.toString();
	//	Scanner f= new Scanner(db);
		try {
		f = new Scanner((Readable) new BufferedReader(new FileReader(f1)));
		while(f.hasNext()) {
		if(f.next().equals(input_username))
			{	
				flag=1;
				if(f.next().equals(input_password))
					flag=2;
			}
		else 
			f.next();
		}
		}
		catch(Exception e) {
			System.out.println("Error Occured");
		}
		return flag;
	}
}
//CONTAINS MAIN CLASS
public class Login {
public static void main(String[] args) throws IOException {
	int opt = 0;
	Scanner sc = new Scanner(System.in);
	Database d = new Database();
	while(opt!=3)
		{
		System.out.println("Enter your Option\n1==>Signup\n2==>Login\n3==>Exit");
		opt=sc.nextInt();
		switch(opt)
		{
		case 1:
			System.out.println("_______________________________________");
			d.addEntry();
			System.out.println("_______________________________________");
			break;
		case 2:
			System.out.println("_______________________________________");
			System.out.println("Enter the username\t");
			d.input_username=sc.next();
			System.out.println("Enter the Password\t");
			d.input_password=sc.next();
			int result=d.check();
			if(result==0)
				System.out.println("The Username Unavailable");
			else if(result==1)
				System.out.println("Password Mismatch");
			else
				System.out.println("\nWelcome "+d.input_username+"\n");
			System.out.println("_______________________________________");
			break;
		case 3:
			System.exit(0);
		}
		}
	sc.close();
}
}