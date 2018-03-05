package swex_2019;

import java.util.Scanner;

public class SWEX_2019 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int result = 1;

		for (int i = 1; i <= n+1; i++) {
			System.out.print(result + " ");
			result *= 2;
		}
	}

}
