package baek_10971;

import java.util.Scanner;

public class Baek_10971 {
	static int[][] weight;
	static int[][] visited;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		weight = new int[size][size];
		visited = new int[size][size];
		int[] answer = new int[size];
		int minAns = 0;

		for (int i = 0; i < size; i++) {
			answer[i] = 0;
			for (int j = 0; j < size; j++) {
				weight[i][j] = sc.nextInt();
				visited[i][j] = 0; // 미방문으로 초기화
			}
		}

		int valueJ = Integer.MAX_VALUE;

		for (int i = 0; i < size; i++) { // i는 처음으로 방문할 지역

			int min = Integer.MAX_VALUE;

			for (int j = 0; j < size; j++) {
				System.out.println("TEST J 1:: ");
				visited[j][i] = 1;
			}

			for (int j = 0; j < size; j++) {
				if (weight[i][j] != 0 && visited[i][j] == 0) {
					if (min > weight[i][j]) {
						min = weight[i][j];
						valueJ = j;
						System.out.println("TEST J 2:: " + min);
					}
				}
				answer[i] = answer[i] + min;
				visited[i][valueJ] = 1;
				visited[valueJ][i] = 1;

			}
			System.out.println("TEST J :: " + valueJ);

		}

		for (int i = 0; i < size - 1; i++) {
			minAns = answer[i];
			System.out.println(minAns);
			if (minAns > answer[i + 1]) {
				minAns = answer[i + 1];
			}

		}

		System.out.println(minAns);

	}

}
