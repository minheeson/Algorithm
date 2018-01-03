## 08 Dynamic Programming 

#### 중복되는 부분 문제 

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

#### 메모이제이션을 적용할 수 있는 경우 