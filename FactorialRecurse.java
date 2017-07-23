
import java.util.Scanner;
public class FactorialRecurse {
	int factorial(int i)
	{
		if (i<=1)
			return 1;
		else
			return (i*factorial(i-1));
	}

	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		System.out.println("Enter your number to get the factorial");
		int a = s.nextInt();
		s.close();
		FactorialRecurse n = new FactorialRecurse();
		
		System.out.println("Factorial ==>\t"+n.factorial(a));
	}
}
