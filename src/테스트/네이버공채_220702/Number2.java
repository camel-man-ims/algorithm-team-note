package src.코딩테스트.네이버공채_220702;

import java.io.*;
import java.util.*;

/**
 * 22.07.02
 */

/*
 * input을 어떻게 줬는 지 기억이 안나서 임의로 설정
 * n,m 주어짐 -> n 과일의 종류 개수 , m 등급의 개수
 * n 최대 100
 * m 최대 26
 */

 /*

1. 풀이: Map<String,int[]> map을 활용하여 입력값 받는다.
    * ex) apple A -> grade[0]++
    * 입력값 다 받으면 apple : 1 2 2 3 4 2 ... 이런식으로 값이 받아져 있을 것
2. 해당 값에서 최대값, 최대값 index를 찾는다.
    * 위의 예에서 최대값 4
    * 최대값 index 4 -> A B C D E : grade E
3. 해당 grade를 Long으로 바꿔준다.
    * Long으로 바꿔주는 것은 같은 값에서 비교해서 정렬을 하기 위함
    * List<Fruit>[] list = new ArrayList[M] 선언해준다.
        * 해당 list에 0: A, 1: B, 2: C, ... 이렇게 매핑해놓은 개념이다.
    * 2번에서 구한 max값에 따라 list에 넣어준다.
4. list를 정렬하고, 순서에 따라 출력해준다.
  
  */

public class Number2 {
    static int T;
    static int N,M;

    static class Fruit implements Comparable<Fruit>{
        String name;
        Long grade;
        public Fruit(String name, Long grade) {
            this.name = name;
            this.grade = grade;
        }
        @Override
        public int compareTo(Fruit o) {
            return Long.compare(o.grade, this.grade);
        }
        @Override
        public String toString() {
            return "Fruit [grade=" + grade + ", name=" + name + "]";
        }
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        System.setIn(new FileInputStream("./src/코딩테스트/네이버공채_220702/input.txt"));
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        Map<Character,Integer> alphas = new HashMap<>();

        for(int i=0;i<M;i++){
            alphas.put((char)('A'+i),i);
        }

        Map<String,int[]> map = new HashMap<>();

        for(int t=0;t<T;t++){
            st = new StringTokenizer(br.readLine());
            
            String fruit = st.nextToken();
            Character grade = st.nextToken().charAt(0);
            int index = alphas.get(grade);
            if(!map.containsKey(fruit)){
                map.put(fruit,new int[M]);
            }
            map.get(fruit)[index]++;
        }
        
        ArrayList<Fruit>[] fr = new ArrayList[M];

        for(int i=0;i<M;i++){
            fr[i] = new ArrayList<>();
        }

        Set<String> keys = map.keySet();

        // max 가려내고, max를 가진 index에 Fruit 객체 넣어주기
        for(String key : keys){
            int[] grades = map.get(key);

            int max = 0;
            int maxIndex = 0;

            for(int i=0;i<grades.length;i++){
                if(max < grades[i]){
                    max = grades[i];
                    maxIndex = i;
                }
            }
            StringBuilder sb = new StringBuilder();
            
            for(int g : grades){
                sb.append(g);
            }

            Long gradesLong = Long.parseLong(sb.toString());

            fr[maxIndex].add(new Fruit(key, gradesLong));
        }

        for(int i=0;i<M;i++){
            Collections.sort(fr[i]);
        }
        
        for(List<Fruit> f : fr){
            System.out.println(f);
        }
    }
}
