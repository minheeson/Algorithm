package swex_2115;

import java.util.Scanner;

public class SWEX_2115 {

	static int n;
	static int m;
	static int c;
	static int[][] map;
	static int[][] max;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		int t = 1;

		while (t <= tc) {
			n = sc.nextInt();
			m = sc.nextInt();
			c = sc.nextInt();

			map = new int[n][n];
			max = new int[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					map[i][j] = sc.nextInt();

				}
			}
			
			System.out.println("#"+ (t++) + " " + oper());

		}
	}

	static int oper() {
		int sum;
		int ans = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= n - m; j++) {
				max[i][j] = getFirst(0, i, j, 0, 0);
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= n - m; j++) {
				sum = max[i][j] + getMaxPair(i, j);
				if (ans < sum)
					ans = sum;
			}
		}

		return ans;
	}

	// worker 1이 
	// x,y 부터 시작할때 가장 큰 값을 계산하는 재귀 함수  
	// sum은 c보다 작은지 확인해야됨 
	// psum은 최대값 찾는용   
	static int getFirst(int num, int x, int y, int sum, int psum) {
		if (num >= m)
			return psum;

		int nextSum; // 탐색한 경우의 수익 저장   
		int max = 0;

		for (int i = num; i < m; i++) {
			// c를 안넘으면 꿀 채취 가능  
			if (sum + map[x][y + i] <= c) {
				nextSum = getFirst(i+1, x, y, sum + map[x][y + i], psum + map[x][y + i] * map[x][y + i]);
				if (max < nextSum)
					max = nextSum;
			}

			// 채취하지 않는 경우   
			nextSum = getFirst(i+1, x, y, sum, psum);
			if (max < nextSum)
				max = nextSum;
		}

		return max;

	}

	// x,y를 가장 왼쪽좌표로 두는 벌통과
	// 동시에 선택 가능한 다른 벌통 중 최대 수익을 만드는 함수  
	static int getMaxPair(int x, int y) {
		int maxR = 0;
		// 같은 x행에서 찾는 경우  
		for (int i = y + m; i <= n - m; i++) {
			if (maxR < max[x][i])
				maxR = max[x][i];
		}

		// x 이후 행에서 찾는 경우   
		for (int i = x + 1; i < n; i++) {
			for (int j = 0; j <= n - m; j++) {
				if (maxR < max[i][j])
					maxR = max[i][j];
			}
		}

		return maxR;
	}

}
