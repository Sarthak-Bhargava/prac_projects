package temp;

public class Program {

	public static void divide(int n, int div) {
		try {
			int ans = n/div;
		}
		finally {
			System.out.println("finally of divide");
		}
	}
	public static void main(String[] args) 
	{
		try {
			Program.divide(100, 0);
		}
		finally {
			System.out.println("finally in main");
		}

	}

}
