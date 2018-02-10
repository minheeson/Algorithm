package chap_01;

import java.util.Arrays;
import java.util.Scanner;

public class p01_02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String test1 = "abdcfe";
		String test2 = "dbcefa";
		String test3 = "abdcf";
		String test4 = "  abdcfe";

		System.out.println(checkPermutation(test1, test2));

	}

	static String sort(String s) {
		char[] content = s.toCharArray();
		Arrays.sort(content);
		return new String(content);
	}

	static boolean checkPermutation(String a, String b) {
		if (a.length() != b.length()) {
			return false;
		}

		return sort(a).equals(sort(b));
	}

}
