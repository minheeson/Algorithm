package baek_11726;

import java.util.Arrays;
import java.util.Scanner;

public class Baek_11726 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();

		int[] cache = new int[size + 1];
		cache[0] = cache[1] = 1;

		for (int i = 2; i <= size; i++) {
			cache[i] = (cache[i - 1] + cache[i - 2]) % 10007;

		}

		System.out.println(cache[size]);
	}

}
