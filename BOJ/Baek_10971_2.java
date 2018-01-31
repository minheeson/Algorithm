package baek_10971;

import java.util.Scanner;

public class Baek_10971_2 {

	static int[][] cost;
	static int[] order;
	static int city;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		city = sc.nextInt();

		cost = new int[city][city];
		order = new int[city];

		for (int i = 0; i < city; i++) {
			for (int j = 0; j < city; j++) {
				cost[i][j] = sc.nextInt();
			}
			order[i] = i;
		}

		System.out.println(minCost());

	}

	static int minCost() {
		int min = Integer.MAX_VALUE;

		while (check()) {
			int sum = 0;
			boolean ok = true;
			for (int i = 0; i < city - 1; i++) {
				if (cost[order[i]][order[i + 1]] == 0) {
					ok = false;
				} else {
					sum = sum + cost[order[i]][order[i + 1]];
				}
			}

			if (ok && cost[order[city - 1]][order[0]] != 0) {
				sum = sum + cost[order[city - 1]][order[0]];

				if (min > sum)
					min = sum;
			}

			order = nextPermutation(order);
		}

		return min;

	}

	static boolean check() {
		for (int i = 0; i < city; i++) {
			if (order[i] != (city - i - 1)) {
				return true;
			}
		}

		return false;

	}

	static int[] nextPermutation(int[] arr) {

		int big = 0;
		int next = 0;
		int len = arr.length;

		for (int i = len - 1; i > 0; i--) {
			if (arr[i - 1] < arr[i]) {
				big = i;
				break;
			}
		}

		for (int i = len - 1; i >= big; i--) {
			if (arr[big - 1] < arr[i]) {
				next = i;
				break;
			}
		}

		int temp = arr[big - 1];
		arr[big - 1] = arr[next];
		arr[next] = temp;

		int[] tmp = new int[len - big];
		for (int i = 0; i < tmp.length; i++) {
			tmp[i] = arr[len - 1 - i];
		}

		for (int i = 0; i < tmp.length; i++) {
			arr[big + i] = tmp[i];
		}

		return arr;

	}

}
