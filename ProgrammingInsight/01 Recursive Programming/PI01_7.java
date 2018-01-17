package pi01_7;

import java.util.Arrays;

public class PI01_7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] code = new int[200];
		Arrays.fill(code, 0);

		print_gray(code, 2, 0);

	}

	static void print_code(int[] code, int len) {
		for (int i = 0; i < len; i++) {
			System.out.print(code[i] + " ");
		}
		System.out.println();
	}

	static void print_gray(int[] code, int n, int index) {
		if (index == n) {
			print_code(code, n);
			return;
		}

		code[index] = 0;
		print_gray(code, n, index + 1);
		code[index] = 1;
		print_gray_reverse(code, n, index + 1);

	}

	static void print_gray_reverse(int[] code, int n, int index) {
		if (index == n) {
			print_code(code, n);
			return;
		}

		code[index] = 1;
		print_gray(code, n, index + 1);
		code[index] = 0;
		print_gray_reverse(code, n, index + 1);
	}

}
