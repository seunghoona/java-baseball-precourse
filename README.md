# 숫자 야구 게임 

------------

## 요구사항 정보
### 설명 
* 숫자 야구게임은 1부터 9까지 서로 다른 수로 이루어진 3자리의 수를 맞추는 게임

### 규칙
* 동일한 숫자가 같은 자리에 있으면 '스트라이크'
* 다른자리에 있으면 '볼' 
* 같은 수가 전혀 없으면 '낫싱' 
* (스트라이크, 볼 , 낫싱) 힌트를 이용해 컴퓨터의 수를 사용자가 맞추면 승리 
  
### 방법
    
* 사용자 
  * 1~9까지의 임의의 수 3개를 입력한다.

* 컴퓨터
  * 규칙에 따라 입력한 숫자의 결과를 출력한다.
  * 컴퓨터가 생성한 숫자(3개)를 사용자가 전부 맞춘 경우 재게임 의사를 묻는다. 


## 기능구현

* 야구번호 생성
  * 기능 
    * 랜덤한 숫자 3개를 생성
  * 제약사항 
    * 1~9 범위에서 3개의 숫자를 생성  
    * 생성된 숫자는 중복되지 않아야한다.


* 야구번호를 입력
  * 기능 
    * [사용자]는 숫자를 입력할 수 있다.
  * 제약사항 
    * 숫자는 총 3개까지 입력할 수 있다.
    * 숫자 입력시 서로 다른 수를 입력해야한다.
    * 잘못된 값을 입력할 수 없다.
  * 예외처리 
    * 숫자를 3개 이상 입력하는 경우 오류 
    * 서로 다른 숫자가 아닌 경우 오류 
    * 잘못된 값을 입력시 [ERROR]로 시작하는 에러메시지를 출력후 게임을 계속 할 수 있어야한다.


* 야구번호 검증
  * 기능 
    * [사용자]가 입력한 숫자를 이용하여 컴퓨터가 생성한 숫자를 검증 후 메시지 출력 
  * 제약사항 
    * 메시지는 숫자 야구게임 **규칙(스트라이크, 볼 , 낫싱)에** 따른 메시지를 출력한다. 
    
  