package chap_01;

import java.util.Arrays;

public class p01_08 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s1 = "waterbottle";
		String s2 = "erbottlewat";

		System.out.println(isRotate(s1, s2));
	}

	static boolean isSubstring(String big, String small) {
		if (big.indexOf(small) >= 0) {
			return true;
		} else {
			return false;
		}
	}

	static boolean isRotate(String s1, String s2) {

		if (s1.length() == s2.length()) {
			String s1s1 = s1 + s1;
			return isSubstring(s1s1, s2);
		}
		return false;
	}

}
