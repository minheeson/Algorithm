## 06 Brute-force

#### 무식하게 풀기 (brute-force)

- 완전 탐색 : 가능한 방법을 전부 만들어보는 알고리즘


#### 재귀 호출

- 컴퓨터가 수행하는 많은 작업들은 대개 작은 조각들로 나누어 볼 수 있는데, 들여다보는 범위가 작아지면 작아질수록 __각 조각들의 형태가 유사해지는__ 작업들을 볼 수 있음 

  - 이런 작업을 구현할 때 유용하게 사용되는 **재귀 함수(recursive function), 재귀 호출(recursion)**

- 재귀 함수 : 자신이 수행할 작업을 유사한 형태의 여러 조각으로 쪼갠 뒤 그 중 한 조각을 수행하고, 나머지를 자기 자신을 호출해 실행하는 함수

- 자연수 n이 주어졌을 때 1부터 n까지의 합을 반환하는 함수 

  ```java
  static int recursiveSum(int n) {
  		if (n == 1)
  			return 1; // 더이상 쪼개지지 않을 때     
  		return n + recursiveSum(n - 1);
  }
  ```

  - 모든 재귀 함수는 이와 같이 **'더이상 쪼개지지 않는' 최소한의 작업에 도달했을 때** 답을 곧장 반환하는 조건문을 포함해야 함
  - 기저 사례 (base case) : 쪼개지지 않는 가장 작은 작업들 

- 재귀 호출은 단순한 반복문보다 **간결하고 유연한 코드 작성**

- n개의 원소 중 m개를 고르는 모든 조합을 찾는 알고리즘 

  ```java
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
  ```

  ​