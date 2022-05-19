package 테스트.카카오페이_220519;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Number1 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(1,7,new int[][] {{1, 0, 2, 1}, {2, 6, 5, 2}, {3, 10, 2, 4}, {1, 1, 5, 6}, {2, 7, 10, 2}, {3, 8, 6, 3}});
    }
    static class Solution{
        // a b c d
        // a = 거주지
        // b = 무주택 기간
        // c = 청약 통장 가입 기간
        // d = 부양가족 수

        static class Info{
            int city;
            int score;
            int speed;

            public Info(int city, int score, int speed) {
                this.city = city;
                this.score = score;
                this.speed = speed;
            }

            @Override
            public String toString() {
                return "Info{" +
                        "city=" + city +
                        ", score=" + score +
                        ", speed=" + speed +
                        '}';
            }
        }

        public int[] solution(int region,int num, int[][] info){
            Comparator<Info> comp = (o1, o2) -> {
                if(o1.score == o2.score){
                    return Integer.compare(o1.speed,o2.speed);
                }else{
                    return Integer.compare(o2.score,o1.score);
                }
            };

            PriorityQueue<Info> pqIN = new PriorityQueue<>(comp);
            PriorityQueue<Info> pqOUT = new PriorityQueue<>(comp);

            for(int i=0;i<info.length;i++){
                int city = info[i][0];
                int score = cal(info[i][1],info[i][2],info[i][3]);
                if(city==region){
                    pqIN.offer(new Info(city,score,i));
                }else{
                    pqOUT.offer(new Info(city,score,i));
                }
            }

            int N = num;
            int[] arr = new int[info.length];
            Arrays.fill(arr,-1);
            int point = 1;
            while(N-->0){
                if(pqIN.isEmpty()) {
                    N+=1;
                    break;
                }
                Info p = pqIN.poll();
                arr[p.speed] = point++;
            }
            while(N-->0){
                if(pqOUT.isEmpty()){
                    break;
                }
                Info p = pqOUT.poll();
                arr[p.speed] = point++;
            }
            return arr;
        }
        public int cal(int b,int c,int d){
            return (b+1)*2 + (c+2) + (d+1)*5;
        }
    }
}
