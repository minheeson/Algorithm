package algospot_picnic;

import java.util.Arrays;

public class Algospot_PICNIC {

	static int n = 4;
	static boolean[][] areFriends = { { false, true, true, true }, { true, false, true, true },
			{ true, true, false, true }, { true, true, true, false } };

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		boolean[] taken = new boolean[4];
		Arrays.fill(taken, false);
		System.out.println(countPairings(taken));

	}

	/**
	 * 
	 * @param taken[i] = i번째 학생이 짝을 이미 찾았으면 true, 아니면 false
	 * @return
	 */
	static int countPairings(boolean taken[]) {
		// 남은 학생들 중 가장 번호가 빠른 학생을 찾는다.
		int firstFree = -1;
		for (int i = 0; i < n; i++) {
			if (!taken[i]) {
				firstFree = i;
				System.out.println("firstFree :: " + firstFree);
				break;
			}
		}

		// 기저 사례 : 모든 학생이 짝을 찾았으면 한 가지 방법을 찾았으니 종료
		if (firstFree == -1)
			return 1;
		int ret = 0;
		// 이 학생과 짝지을 학생을 결정
		for (int pairWith = firstFree + 1; pairWith < n; pairWith++) {
			if (!taken[pairWith] && areFriends[firstFree][pairWith]) {
				taken[firstFree] = taken[pairWith] = true;
				ret += countPairings(taken);
				taken[firstFree] = taken[pairWith] = false;
			}
		}

		return ret;

	}
}
