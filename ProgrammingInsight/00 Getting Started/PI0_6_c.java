package pi0_6_c;

import java.util.Scanner;

// PInsight 0.6.c int형 정수를 입력받은 후 이진수로 변환하여 1의 개수를 세는 프로그램 작성 
public class PI0_6_c {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int count = 0;

		while (num > 0) {

			if (num % 2 == 1) {
				count++;
			}
			num /= 2;

		}

		System.out.println(count);
	}

}
