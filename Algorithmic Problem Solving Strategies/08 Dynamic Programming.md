## 08 Dynamic Programming 

###중복되는 부분 문제

- _Dynamic Programming_ : 주어진 문제를 __더 작은 문제들로 나눈뒤__ 각 조각의 답을 계산하고, 이 답들로부터 원래 문제에 대한 답을 계산함

  - 분할 정복과의 차이 : DP에서는 중복 되는 __부분 문제의 계산 결과를 재활용함으로써__ 속도 향상 
  - __cache__ : 이미 계산한 값을 저장해 두는 메모리의 장소 

- 이항 계수의 계산

  - 이항 계수 : n개의 서로 다른 원소 중에서 r개의 원소를 순서없이 골라내는 방법의 수 

    <img src="https://github.com/minheeson/Algorithm/blob/master/Algorithmic%20Problem%20Solving%20Strategies/screenshots/8_%EC%9D%B4%ED%95%AD%EA%B3%84%EC%88%98.png" width=300/>

  - 재귀 호출을 이용한 이항 계수의 계산

    ```java
    int bino(int n, int r) {
      if(r == 0 || n == r) return 1;
      return bino(n-1, r-1) + bino(n-1, r);
    }
    ```

    - 중복 호출이 발생함

  - __Memoization__ 을 이용한 이항 계수의 계산 : 함수의 결과를 저장하는 캐시를 두고, 한 번 계산한 값을 저장해 뒀다 재활용하는 최적화 기법 

    ```java
    // cache는 -1로 초기화 
    static int bino2(int n, int r) {
    	if (r == 0 || n == r)
    		return 1;
    	if (cache[n][r] != -1)
    		return cache[n][r];
    	return cache[n][r] = bino2(n - 1, r - 1) + bino2(n - 1, r);
    }
    ```

    - 모든 부분 문제가 한 번씩만 계산된다고 보장할 수 있음 

- Memoization을 적용할 수 있는 경우 : 참조적 투명 함수의 경우에만 적용 가능 

  - _참조적 투명성_ (referential transparency) : 함수의 반환 값이 그 입력 값만으로 결정되는지의 여부 

- __Memoization 구현 패턴__

  1. cache 초기화 : Arrays.fill() 사용 
  2. 항상 기저 사례를 제일 먼저 처리 : 예를 들면, 입력이 범위를 벗어난 경우 등 
  3. (a,b)에 대한 답을 구한 적이 있으면 곧장 반환
  4. 없으면 답을 계산 

- Memoization 시간 복잡도 분석 

  > (존재하는 부분 문제의 수)  X (한 부분 문제를 풀 때 필요한 반복문의 수행 횟수)

- __예제 : 외발 뛰기 (JUMPGAME)__

  > n X n 크기의 격자에 1부터 9까지의 정수를 쓴 게임판이 있습니다. 이때 게임의 목적은 게임판의 왼쪽 위 칸에서 시작해서 게임판의 맨 오른쪽 아래 칸에 도착하는 것입니다. 이때 각 칸에 적혀 있는 숫자만큼 아래쪽이나 오른쪽으로 이동할 수 있으며, 중간에 게임판 밖으로 벗어나면 안됩니다. 
  >
  > 문제는 게임판이 주어질 때 시작점에서 끝점으로 도달하는 방법이 존재하는지를 확인하는 것입니다. 

  - 재귀 호출 알고리즘 

    ```java
    static boolean jump(int y, int x) {
    	// 기저 사례 :: 게임판 밖을 벗어난 경우
    	if (y >= n || x >= n)
    		return false;
    	// 기저 사례 :: 마지막 칸에 도착한 경우
    	if (y == n - 1 && x == n - 1)
    		return true;

    	int jumpSize = board[y][x];
      
    	return jump(y + jumpSize, x) || jump(y, x + jumpSize);
    }
    ```

  - 동적 계획법 알고리즘

    ```java
    static int jump2(int y, int x) {
    	// 기저 사례 처리
    	if (y >= n || x >= n)
    		return 0;
    	if (y == n - 1 && x == n - 1)
    		return 1;

    	int ret = cache[y][x];
    	if (ret != -1)
    		return ret;
      
    	int jumpSize = board[y][x];
      
    	return ret = (jump2(y + jumpSize, x) | jump2(y, x + jumpSize));
    	}
    ```

- 동적 계획법 레시피 

  1. 주어진 문제를 완전 탐색을 이용해 해결합니다. 
  2. 중복된 부분 문제를 한 번만 계산하도록 메모이제이션을 적용합니다. 