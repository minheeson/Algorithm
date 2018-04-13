package baek_13000;

import java.util.Scanner;

public class Baek_13458_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // 시험장 개수
		int[] a = new int[n];

		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		int b = sc.nextInt(); // 총감독관
		int c = sc.nextInt(); // 부감독관

		long[] ans = new long[n];
		for (int i = 0; i < n; i++) {
			if (a[i] <= b) {
				ans[i] = 1;
				a[i] = 0;
			} else {
				ans[i] = 1;
				a[i] -= b;
			}
		}

		// a에 남아있는 학생수를 부감독관으로 걸러내면됨
		for (int i = 0; i < n; i++) {
			int moc = a[i] / c;
			int na = a[i] % c;
			if (na==0) {
				ans[i] += moc;
			} else {
				ans[i] += (moc + 1);
			}
		}

		long an = 0;
		for (int i = 0; i < n; i++) {
			an += ans[i];
		}

		System.out.println(an);
	}

}
