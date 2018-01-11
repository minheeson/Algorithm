## 06 Brute-force

### 무식하게 풀기 (brute-force)

- 완전 탐색 : 가능한 방법을 전부 만들어보는 알고리즘


### 재귀 호출과 완전 탐색

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




### 완전 탐색 레시피

- 완전 탐색은 존재하는 모든 답을 하나씩 검사하므로, 걸리는 시간은 가능한 답의 수에 정확히 비례
  - 최대 크기의 입력을 가정했을 때 답의 개수를 계산하고 이들을 모두 제한 시간 안에 생성할 수 있을 지를 가늠
- 가능한 모든 답의 후보를 만드는 과정을 여러 개의 선택으로 나눔 (조각)
- 그 중 하나의 조각을 선택해 답의 일부를 만들고, 나머지 답을 재귀 호출을 통해 완성
- 조각이 하나밖에 남지 않은 경우, 혹은 하나도 남지 않은 경우에는 답을 생성했으므로, 이것을 기저 사례로 선택해 처리 




### 최적화 문제 

- 최적화 문제 : 문제의 답이 하나가 아니라 여러 개이고, 그 중에서 어떤 기준에 따라 가장 '좋은' 답을 찾아 내는 문제

- 완전 탐색은 최적화 문제를 풀기 위한 **가장 직관적인 방법** 

- 예제 : **여행하는 외판원 문제** (Traveling Sales-man Problem, TSP)

  > 어떤 나라에 n (2<=n<=10)개의 큰 도시가 있다고 합시다. 한 영업 사원이 한 도시에서 출발해 다른 도시들을 전부 한 번씩 방문한 뒤 시작 도시로 돌아오려고 합니다. 문제를 간단히 하기 위해, 각 도시들은 모두 직선 도로로 연결되어 있다고 합시다. 이때 영업 사원이 여행해야 할 거리는 어느 순서로 각 도시들을 방문하느냐에 따라 달라집니다.
  >
  > 이때 가능한 모든 경로 중 가장 짧은 경로를 어떻게 찾아낼 수 있을까요? 

  - **재귀 호출을 통한 답안 생성**

    - *n* 개의 도시로 구성된 경로를 *n* 개의 조각으로 나눠, 앞에서부터 도시를 하나씩 추가해 경로를 만들면 됨 
    - *shortestPath(path) = path* 가 지금까지 만든 경로일 때, 나머지 도시들을 모두 방문하는 경로들 중 가장 짧은 것의 길이를 반환한다. 

  - **구현**

    ```java
    /**
     * 
     * @param path : 지금까지 만든 경로   
     * @param visited : 각 도시의 방문 여부  
     * @param currentLength : 지금까지 만든 경로의 길이      
     * @return : 나머지 도시들을 모두 방문하는 경로들 중 가장 짧은 것의 길이를 반환한다.   
     */
    static double shortestPath(ArrayList<Integer> path, boolean[] visited, double currentLength) {
    	// 기저 사례 : 모든 도시를 다 방문했을 때는 시작 도시로 돌아가고 종료한다.
    	if (path.size() == n) {
    		return currentLength + dist[path.get(0)][path.get(path.size() - 1)];
    	}

    	double ret = Double.MAX_VALUE; // 매우 큰 값으로 초기화
    	// 다음 방문할 도시를 전부 시도해 본다.
    	for (int next = 0; next < n; next++) {
    		if (visited[next])
    			continue;
    		int here = path.get(path.size() - 1);
    		path.add(next);
    		visited[next] = true;
    		// 나머지 경로를 재귀 호출을 통해 완성하고 가장 짧은 경로의 길이를 얻는다.
    		double cand = shortestPath(path, visited, currentLength + dist[here][next]);
    		ret = Math.min(ret, cand);
    		visited[next] = false;
    		path.remove(path.size() - 1);

    	}
    	return ret;

    }
    ```

    ​

### 많이 등장하는 완전 탐색 유형 

- 모든 순열 만들기
  - **순열(permutation)** : 서로 다른 *N* 개의 원소를 일렬로 줄 세운 것 
- 모든 조합 만들기
  - **조합(combination)** : 서로 다른 *N* 개의 원소 중에서 *R* 개를 순서 없이 골라낸 것 
- *2^n* 가지 경우의 수 만들기 
  - *n* 개의 질문에 대한 답이 예/아니오 중의 하나라고 할 때 존재할 수 있는 답의 모든 조합의 수는 *2^n* 가지 
  - 이 모든 조합들을 생성할 때, 각 조합을 하나의 *n* 비트 정수로 표현한다고 생각하면 재귀 호출을 사용할 것 없이 1차원 for문 하나로 가능