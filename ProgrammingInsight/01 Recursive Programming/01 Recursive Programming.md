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
-   factorial(1000000) 의 결과 : 0
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

- **이항계수** : *n* 개의 원소를 가지는 집합에서 크기가 *r* 인 부분집합을 고르는 경우의 수 

  <img src="https://github.com/minheeson/Algorithm/blob/master/ProgrammingInsight/screenshot/01_nCr.png" width=450/>

  > f(n, r) = f(n-1, r-1) + f(n-1, r)

- 재귀 호출을 이용 

  ```java
  static long choose(int n, int r) {
  	if (r == 0 || n == r)
  		return 1;
  	return choose(n - 1, r - 1) + choose(n - 1, r);
  }
  ```

- 메모이제이션 적용 

  ```java
  static long choose2(int n, int r) {
  	if (memo[n][r] > 0)
  		return memo[n][r];

  	if (r == 0 || n == r)
  		return memo[n][r] = 1;

  	return memo[n][r] = choose2(n - 1, r - 1) + choose2(n - 1, r);
  }
  ```



#### 1.4 피보나치 수열

- 재귀 호출을 이용

  ```java
  static long fibo(int n) {
  	if (n == 1 || n == 2)
  		return 1;
    	return fibo(n - 1) + fibo(n - 2);
  }
  ```

- 메모이제이션 적용

  ```java
  static long fibo2(int n) {
  	if (memo2[n] > 0)
  		return memo2[n];

  	if (n == 1 || n == 2)
  		return memo2[n] = 1;

  	return memo2[n] = fibo2(n - 1) + fibo2(n - 2);
  }
  ```



#### 1.5 금액 맞추기 

- 지폐의 액수 배열 *bills[]* 가 주어져 있을 때, *pay(m, n)* 을 다음과 같이 정의

  > pay(m, n) : n 종류의 지폐 bills[0], … , bills[n-1] 을 사용하여 m 만원을 지불하는 방법의 수 

- 재귀 호출을 이용

  ```java
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
  ```



#### 1.6 수분할

- *n/m* 수분할 : *n* 을 *m* 이하의 자연수로만 나타내는 방법 

  - 일반적으로 *n/m* 의 수분할은 *i (1<=i<=m)* 로 시작하는 부분과 나머지 *(n-i)/i* 수분할로 이루어짐 

- *n/m* 수분할의 갯수를 *partition(n, m)* 이라고 하면, *m<=n* 일때

  > partition(0, m) = 1
  >
  > n>0 이면, partition(n, m) += parition(n-i, i)     (단,  1<=i<=m)

- 재귀 호출을 이용

  ```java
  static int partition(int n, int m) {
  	int count = 0;

  	if (n < m) {
  		m = n; 
  	}
  	if (n == 0) {
  		return 1;
  	}

  	for (int i = 1; i <= m; i++) {
  		count += partition(n - i, i);
  	}

  	return count;
  }
  ```

  ​


#### 1.7 그레이 코드

- **그레이 코드** : 연속된 수를 한 비트만 다르게 인코딩하는 방법 

  - 연속적으로 변하는 양을 나타낼 때, 변화폭이 작아 오류를 줄일 수 있어 데이터 전송에서 많이 쓰임 
  - *n* 비트 그레이 코드를 이용하여 *n+1* 비트 그레이 코드를 만들 수 있음
    - n비트 그레이 코드를 적고 앞에 0을 붙인 것과, n비트 그레이 코드를 역순으로 적고 앞에 1을 붙인 것을 이으면 n+1비트 그레이 코드가 됨   
    - 예) 00 10 11 10 | 10 11 10 00  >> 000 001 010 011 010 | 110 111 110 100 

- 그레이 코드 출력

  > n을 입력 받아서 n비트 그레이 코드를 출력하는 프로그램을 작성하라. 재귀 호출을 사용하여 간단명료 하게 작성

- 재귀 호출을 이용

  ```java
  static void print_gray(int[] code, int n, int index) {
  	if (index == n) {
  		print_code(code, n);
  		return;
  	}

  	code[index] = 0;
  	print_gray(code, n, index + 1);
  	code[index] = 1;
  	print_gray_reverse(code, n, index + 1);

  }

  static void print_gray_reverse(int[] code, int n, int index) {
  	if (index == n) {
  		print_code(code, n);
  		return;
  	}

  	code[index] = 1;
  	print_gray(code, n, index + 1);
  	code[index] = 0;
  	print_gray_reverse(code, n, index + 1);
  }
  ```

  ​

