package apss06_2;

import java.util.ArrayList;
import java.util.LinkedList;

public class APSS06_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<Integer> arr = new ArrayList<Integer>();
		pick(5, arr, 2);

	}

	/**
	 * @param n : 전체 원소의 수
	 * @param picked : 지금까지 고른 원소들의 번호
	 * @param toPick : 더 고를 원소의 수
	 */
	static void pick(int n, ArrayList<Integer> picked, int toPick) {
		// 기저 사례 : 더 고를 원소가 없을 때 고른 원소들을 출력   
		if (toPick == 0) {
			printPicked(picked);
			return;
		}
		
		// 고를 수 있는 가장 작은 번호를 계산     
		int smallest = picked.isEmpty() ? 0 : picked.get(picked.size() - 1) + 1;

		for (int next = smallest; next < n; ++next) {
			picked.add(next);
			pick(n, new ArrayList<Integer>(picked), toPick - 1);
			picked.remove(picked.size() - 1);
		}
	}

	static void printPicked(ArrayList<Integer> picked) {
		for (int i = 0; i < picked.size(); i++) {
			System.out.print(picked.get(i) + " ");
		}

		System.out.println();
	}

}
