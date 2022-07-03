package 테스트.라인_220528;

import java.util.*;

public class Number1 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(new String[]{"morgan sort", "felix sort", "morgan sqrt", "morgan sqrt", "rohan reverse", "rohan reverse"});
    }
    static class Solution {
        static int N;
        public String[] solution(String[] logs) {

            Map<String,Integer> map = new HashMap<>();
            List<String> list = new ArrayList<>();
            Set<String> persons = new HashSet<>();
            Set<String> problems = new HashSet<>();

            for(String s : logs){
                String[] split = s.split(" ");
                if(!problems.contains(split[0]+split[1])){
                    map.put(split[1],map.getOrDefault(split[1],0)+1);
                }
                persons.add(split[0]);
                problems.add(split[0]+split[1]);
            }
            N = persons.size();

            Set<String> strings = map.keySet();
            for(String s : strings){
                if(map.get(s)*100/N >= 50){
                    list.add(s);
                }
            }
            String[] res = new String[list.size()];
            for(int i=0;i<list.size();i++){
                res[i] = list.get(i);
            }
            Arrays.sort(res);
            return res;
        }
    }
}
