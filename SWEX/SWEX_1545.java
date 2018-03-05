package swex_1545;

import java.util.Scanner;

public class SWEX_1545 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		print(n);
	}

	static void print(int n) {
		for (int i = n; i >= 0; i--) {
			System.out.print(i + " ");
		}

	}

}
