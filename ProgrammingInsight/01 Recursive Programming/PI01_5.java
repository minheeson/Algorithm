package pi01_5;

public class PI01_5 {
	//static int count = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] bills = { 1, 2, 5, 10, 20, 50 };
		int money = 100;
		int n = 6;

		System.out.println(pay(money, bills, n));

	}

	static int pay(int money, int[] bills, int n) {
		int count = 0;

		if (n == 1) {
			if (money % bills[0] == 0)
				return 1;
			else
				return 0;
		}

		int t = money / bills[n - 1];

		// 해당 지폐(bills[n-1])를 0~t장을 사용하는 경우
		for (int i = 0; i <= t; i++) {
			count += pay(money - (bills[n - 1] * i), bills, n - 1);
		}

		return count;
	}

}
