# 코테 관련 주석

* 잠을 못자서 너무 헬이었다...
* 자바 -> 파이썬으로 갈아타려고 했는데 파이썬으로 코드 짜니까 오히려 더 헷갈렸다.
  * 그냥 자바로 가야겠다.
  * 트러블 슈팅이 안된다.
  * 3번문제 python으로 짰는데, indent관련 오류가 나서 30분동안 다시 자바코드로 옮겼다.

* 문제는 1,2번은 너무 쉬웠고, 3번도 어렵지는 않았는데 문제가 좀 까다로웠다.
  * ide를 못 쓰니까 너무 까다로웠다.
  * 로직은 분명 맞게 푼거같은데, 어디서 틀렸는 지 모르겠다.

* 3시간, 3문제

## 1번

* 브론즈~실버5
* 주민등록번호 990803-11232123 이런식으로 주어졌을 때
  * 1900~1999년생은 성별이 남자면 1,여자면 2
    * 2000년생 이후는 남자면 3, 여자면 4이다.
* 주민등록번호가 주어졌을 때 태어난 년도와 성별을 반환하라.

## 2번

* 실버2~3
* a 10 b 20 이런식으로 각 알파벳에 따른 소모값이 주어짐
* pizza ab 104 이렇게 값이 주어짐
  * 해석하면 pizza를 만드는데 ab비용, 즉 30이 소모되고 피자팔면 104원 번다.
  * 104-ab(30) = 74 가 이익이다.
* 해당 이익의 총 합을 구하라.

## 3번

* 골드5~실버1
* 블랙잭인데, 조건이 여러개 달려있다.
* 1차원 배열이 주어짐
  * 해당 배열의 값은 각 턴의 카드를 지칭한다.
  * 만약 턴 중간에 카드가 끊기면, 해당 라운드는 무효로 한다.
    * `[1,2,10,4,9,8,7,6,...]`
      * 위 값의 경우 뒤의 ...을 떼서 보자.
    * `[1,2,10,4,9,8,7,6]`
    * 1은 11로 치환될 수 있다.
    * 21은 블랙잭이다.
    * 처음 4번의 턴 동안 플레이어, 딜러가 한번씩 카드를 주고 받는다.
    * 위 경우
      * 1 player
      * 2 dealer
      * 10 player
      * 4 dealer
        * 이 경우 플레이어에게 카드가 보임(해당 카드를 d라고 하겠음)
    * 만약 플레이어 카드의 합이 위처럼 블랙잭이라면( 1->11 // 11+10 = 21) 딜러 카드와 비교해서 같지 않다면 +3점 획득
      * 이기면 +2, 지면 -2인데 플레이어가 블랙잭으로 이기면 +3점
    * 만약 게임이 끝나지 않았다면 d카드에 의해 카드를 더 받을 수 있다.
      * d가 1이거나 7이상이면 합이 17이상이 될때까지 카드를 받음
        * 이때, 카드를 받다가 21을 넘어가버리면 바로 져버림
      * d가 2,3,4면 멈춤
      * d가 5,6이면 12이상이 될때까지 받음
    * 플레이어가 충족이 되면 딜러는 17이상이 될때까지 받음
      * 이 때도, 카드를 받다가 21을 넘어가버리면 바로 져버림
* score의 총합을 구하라

# 인적성 관련 주석

* 언어, 수리, 자료추론?, 하나 뭐였더라 어쨋든 4개 영역에서 검사 15문제 각 10분씩
  * 전체적으로 쉬우나, 준비를 안했다면 어렵다. 시간도 매우 부족하다.
  * 시간이 부족해서 쫓기면서 풀어서, 각 영역마다 7-8개정도만 풀고 나머지는 거의 찍은 것 같다.
    * 언어와 도표 보는 거는 11개 정도씩 푼것같다.