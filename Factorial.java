import java.util.Scanner;
public class Factorial {

	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		System.out.println("Enter your number to get the factorial");
		int a = s.nextInt(),fact=1;
		s.close();
		for (int i=1;i<=a;i++)
			fact*=i;
		System.out.println("Factorial ==>\t"+fact);
	}
}
