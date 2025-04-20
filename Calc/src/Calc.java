import java.util.Scanner;

public class Calc {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		double num1 = 0.00;
		double num2 = 0.00;
		double res = 0.00;
		int option = 0;
		String choice = "";

		System.out.println("Welcome to the Basic Calculator.");

		do {
			System.out.print("Enter the first number: ");
			num1 = sc.nextDouble();

			System.out.print("Enter the second number: ");
			num2 = sc.nextDouble();

			do {
				System.out.println("\nHere is a list of operations:");
				System.out.println("1. Addition");
				System.out.println("2. Subtraction");
				System.out.println("3. Multiplication");
				System.out.println("4. Division");
				System.out.print("What operation would you like to perform? (1-4): ");
				
				while (!sc.hasNextInt()) {
					System.out.print("Invalid input. Please enter a number between 1 and 4: ");
					sc.next(); // consume the invalid input
				}
				
				option = sc.nextInt();

				if (option < 1 || option > 4) {
					System.out.println("Invalid choice. Please pick a valid operation (1-4).");
				}
			} while (option < 1 || option > 4);
 
				switch (option) {
					case 1:
						res = Add(num1, num2);
						break;
					case 2:
						res = Sub(num1, num2);
						break;
					case 3:
						res = Mult(num1, num2);
						break;
					case 4:
						if (num2 == 0) {
							System.out.println("Cannot divide by zero.");
							continue;
						}
						res = Div(num1, num2);
						break;
				}
				System.out.printf("The result is: %.2f\n", res);
			

			System.out.print("Would you like to perform another operation? (Y/N): ");
			sc.nextLine(); // clear buffer
			choice = sc.nextLine();

		} while (!choice.equalsIgnoreCase("n"));

		sc.close();
		System.out.println("Thanks for using the calculator!");
	}

	public static double Add(double a, double b) {
		return a + b;
	}

	public static double Sub(double a, double b) {
		return a - b;
	}

	public static double Mult(double a, double b) {
		return a * b;
	}

	public static double Div(double a, double b) {
		return a / b;
	}
}
