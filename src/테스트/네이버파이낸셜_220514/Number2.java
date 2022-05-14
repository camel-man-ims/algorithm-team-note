package 테스트.네이버파이낸셜_220514;

import java.util.*;

public class Number2 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(new String[]{"a","b","c"},new String[]{"a b 1","a c 1","b c 1"},new String[]{"a 100 10","b 300 20","c 50 4"},new String[]{"a b 100","a b 30","c a 250"});
    }
    static class Solution {
        static int V;
        static final int INFINITY = Integer.MAX_VALUE;
        static Map<String, List<int[]>> hashMap;
        static Map<String,Integer> mapCount;
        static int[][] map;
        public String[] solution(String[] cities, String[] roads, String[] cars, String[] customers) {
            V = cities.length;
            hashMap = new HashMap<>();
            mapCount = new HashMap<>();
            map = new int[V][V];

            for(int i=0;i<V;i++){
                mapCount.put(cities[i],mapCount.getOrDefault(cities[i],0)+i);
            }

            for(String car : cars){
                String[] split = car.split(" ");
                String point = split[0];
                int weight = Integer.parseInt(split[1]);
                int price = Integer.parseInt(split[2]);

                if(!hashMap.containsKey(point)){
                    hashMap.put(point,new ArrayList<>());
                }
                hashMap.get(point).add(new int[]{weight,price});
            }

            for(String c : customers){
                String[] split = c.split(" ");
                String startPoint = split[0];
                String endPoint = split[1];
                int customerWeight = Integer.parseInt(split[2]);



            }
            return null;
        }
    }
}
