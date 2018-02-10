package chap_01;

import java.util.Scanner;

public class p01_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		System.out.println(isUniqueChars(input));
		System.out.println(isUniquechars2(input));
	}

	static boolean isUniqueChars(String str) {
		if (str.length() > 256)
			return false;

		boolean[] char_set = new boolean[256];

		for (int i = 0; i < str.length(); i++) {
			int val = str.charAt(i);
			System.out.print(i + "::" + val + " ");
			if (char_set[val]) {
				return false;
			}
			char_set[val] = true;
		}

		return true;
	}

	static boolean isUniquechars2(String str) {
		if (str.length() > 26)
			return false;

		int checker = 0;
		for (int i = 0; i < str.length(); i++) {
			int val = str.charAt(i);
			if ((checker & (1 << val)) > 0) {
				return false;
			}
			checker = checker | (1 << val);
		}
		
		return true;
	}

}
