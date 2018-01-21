package pi02_1;

import java.util.Scanner;

// 출근길 문제   
public class PI02_1 {
	
	static int[][] map;
	static int[][] path;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		map = new int[m][n];
		path = new int[m][n];
		
		for(int i=0; i<m; i++) {
			for (int j=0; j<n; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		calculate_path(m, n);
		System.out.println(path[m-1][n-1]);
		
		
		
	}
	
	static void calculate_path(int m, int n) {
		path[0][0] = map[0][0];
		
		for(int i=1; i<m; i++) {
			if(map[i][0] == 0) {
				path[i][0]= 0;
			}else {
				path[i][0] = path[i-1][0];
			}
		}
		
		for(int j=1; j<n; j++) {
			if(map[0][j] == 0) {
				path[0][j] = 0;
			}else {
				path[0][j] = path[0][j-1];
			}
		}
		
		for(int i=1; i<m; i++) {
			for(int j=1; j<n; j++) {
				if(map[i][j] == 0) {
					path[i][j] =0;
				}else {
					path[i][j] = path[i-1][j] + path[i][j-1];
				}
			}
		}
		
	}

}
