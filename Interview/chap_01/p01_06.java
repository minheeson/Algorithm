package chap_01;

public class p01_06 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int n = 5;
		int[][] arr = { { 1, 2, 3, 4, 5 }, { 6, 7, 8, 9, 10 }, { 11, 12, 13, 14, 15 }, { 16, 17, 18, 19, 20 },
				{ 21, 22, 23, 24, 25 } };

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println();
		}

		System.out.println();

		rotate(arr, n);

	}

	static void rotate(int[][] arr, int n) {
		for (int layer = 0; layer < n / 2; ++layer) {
			int first = layer;
			System.out.println(first);
			int last = n - 1 - layer;
			for (int i = first; i < last; ++i) {
				int offset = i - first;

				// 위쪽 저장
				int top = arr[first][i];

				// 왼쪽 -> 위쪽
				arr[first][i] = arr[last - offset][first];

				// 아래 -> 왼쪽
				arr[last - offset][first] = arr[last][last - offset];

				// 오른쪽 -> 아래
				arr[last][last - offset] = arr[i][last];

				// 위 -> 오른쪽
				arr[i][last] = top;
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println();
		}

	}

}
