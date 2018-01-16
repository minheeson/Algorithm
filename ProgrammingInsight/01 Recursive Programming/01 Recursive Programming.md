## 01 Recursive Programming

#### 1.1 팩토리얼  

- 반복문 이용


  ```java
  static int factorial(int n) {
  	int ret = 1;
  	for (int i = 2; i <= n; i++) {
  	ret *= i;
  	}
  	return ret;
  }
  ```
  - factorial(1000000) 의 결과 : 0
    - 1000000!는 int 형의 범위를 훨씬 넘기 때문

- 재귀 호출을 이용

  ```java
  static int factorial2(int n) {
  	if (n == 1)
  		return 1;
  	else
  		return n * factorial2(n - 1);
  }
  ```

  - factorial2(1000000) 의 결과 : **segmentation fault** 발생
    - factorial2() 가 재귀 호출하면서 **메모리의 스택을 계속 누적해서 사용하다가 스택이 부족하여** **스택 오버플로가 발생하기 때문** 



#### 1.4 이항계수

- 이항계수 : n개의 원소를 가지는 집합에서 크기가 r인 부분집합을 고르는 경우의 수 