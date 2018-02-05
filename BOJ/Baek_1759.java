package baek_1759;

import java.util.Arrays;
import java.util.Scanner;

public class Baek_1759 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int l = sc.nextInt();
		int c = sc.nextInt();

		String[] arr = new String[c];
		for (int i = 0; i < c; i++) {
			arr[i] = sc.next();
		}

		Arrays.sort(arr);
		
		oper(l, arr, "", 0);

	}

	static void oper(int n, String[] alpha, String password, int i) {
		if (password.length() == n) {
			if(check(password, n)) {
				System.out.println(password);
			}
			return;
		}
		
		if(i>=alpha.length) return;
		
		oper(n, alpha, password+alpha[i], i+1);
		oper(n, alpha, password, i+1);

	}

	static boolean check(String password, int n) {
		int mo = 0;
		int ja = 0;
		for (int i = 0; i < n; i++) {
			char temp = password.charAt(i);
			if (temp == 'a' || temp == 'e' || temp == 'o' || temp == 'u' || temp == 'i') {
				mo++;
			} else {
				ja++;
			}
		}

		return mo >= 1 && ja >= 2;
	}

}
