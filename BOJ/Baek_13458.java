package baek_13458;

import java.util.Scanner;

public class Baek_13458 {

	static long[] tester;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 시험장의 개수

		tester = new long[N];
		for (int i = 0; i < N; i++)
			tester[i] = sc.nextInt();// 각 시험장의 응시자 수

		long B = sc.nextInt(); // 총감독관의 감시 명 수
		long C = sc.nextInt(); // 부감독관의 감시 명 수

		long total = 0;// 총 감독관 명 수
		for (int i = 0; i < N; i++) {
			if (tester[i] > B) {
				long temp = tester[i] - B;
				if (temp % C == 0)
					total += temp / C + 1;
				else
					total += temp / C + 2;
			} else
				total += 1;
		}
		System.out.println(total);
	}

}
