package baek_1963;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Baek_1963 {

	private static int temp = 3;

	public static int change(int num, int index, int digit) {
		if (index == 0 && digit == 0) {
			return -1;
		}
		String s = Integer.toString(num);
		StringBuilder sb = new StringBuilder(s);
		sb.setCharAt(index, (char) (digit + '0'));

		return Integer.parseInt(sb.toString());
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		boolean[] prime = new boolean[10001];

		// 에라토스테네스의 체
		for (int i = 2; i <= 10000; i++) {
			if (prime[i] == false) {
				for (int j = i * i; j <= 10000; j = j + i)
					prime[j] = true;
			}
		}

		for (int i = 0; i <= 10000; i++)
			prime[i] = !prime[i]; // 소수 : true

		int count = sc.nextInt();
		while (count-- > 0) {
			int n = sc.nextInt(); // n에서
			int m = sc.nextInt(); // m으로 이동
			boolean[] c = new boolean[10001];
			int[] d = new int[10001];
			d[n] = 0;
			c[n] = true;
			Queue<Integer> queue = new LinkedList<Integer>();
			queue.add(n);

			while (!queue.isEmpty()) {
				int now = queue.remove();
				for (int i = 0; i < 4; i++) { // 네 자릿수 소수의 모든 자리
					for (int j = 0; j <= 9; j++) { // 0-9까지 바꿔봄
						int next = change(now, i, j);
						if (next != -1) {
							if (prime[next] && !c[next]) {
								queue.add(next);
								d[next] = d[now] + 1;
								c[next] = true;
							}
						}
					}
				}
			}
			System.out.println(d[m]);
		}

	}
}
