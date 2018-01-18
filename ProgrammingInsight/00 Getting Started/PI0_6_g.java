package pi0_6_g;

import java.util.Scanner;
import java.util.Stack;

// PInsight 0.6.g 10진수 정수를 입력받아서 이진수로 바꾸어 출력   
public class PI0_6_g {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();

		toBinary(num);
	}

	static void toBinary(int num) {
		Stack<Integer> bin = new Stack<>();
		while (num > 0) {
			bin.add(num % 2);
			num /= 2;
		}

		for (int i = 0, len = bin.size(); i < len; i++) {
			System.out.print(bin.pop());
		}
	}

}
