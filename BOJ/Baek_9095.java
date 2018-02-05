package baek_9095;

import java.util.Scanner;

public class Baek_9095 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int total = sc.nextInt();

		while (total-- > 0) {
			int goal = sc.nextInt();
			System.out.println(count(0, goal));
		}
	}

	static int count(int sum, int goal) {
		int rtn = 0;
		if (sum == goal) {
			return 1;
		}
		if (sum > goal) {
			return 0;
		}

		for (int i = 1; i <= 3; i++) {
			rtn += count(sum + i, goal);
		}

		return rtn;
	}

}
