package 테스트.SSG_220514;

import java.util.*;

public class Number2 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] solution1 = solution.solution(new String[]{"1901 4 100", "1901 7 100", "1901 2 100", "1901 1 100", "1901 8 100", "1902 2 100", "1902 1 100", "1902 7 100", "1902 4 100", "1902 8 100", "1903 8 100", "1903 7 100", "1903 4 100", "1903 2 100", "1903 1 100", "1101 1 95", "1101 2 100", "1101 4 100", "1101 7 100", "1101 9 100", "1102 1 95", "1102 2 100", "1102 4 100", "1102 7 100", "1102 9 100"});
        System.out.println(Arrays.toString(solution1));
    }

    static class Solution{

        static Map<String, Map<String,String>> map;
        public String[] solution(String[] logs){
            map = new HashMap<>();

            Map<String,Integer> studentProblems = new HashMap<>();
            for(String log : logs){
                String[] split = log.split(" ");
                String student = split[0];
                String problemNum = split[1];
                String score = split[2];

                if(!map.containsKey(student)){
                    map.put(student,new HashMap<>());
                }

                if(!map.get(student).containsKey(problemNum)){
                    studentProblems.put(student,studentProblems.getOrDefault(student,0)+1);
                }

                map.get(student).put(problemNum,score);
            }

            Set<String> strings = map.keySet();

            Map<String,String> mappingStringMap = new HashMap<>();

            Comparator<String[]> comp = (o1, o2) -> {
                int n1 = Integer.parseInt(o1[0]);
                int n2 = Integer.parseInt(o2[0]);
                return Integer.compare(n1,n2);
            };

            for(String stuNum : strings){
                Map<String, String> problemMap = map.get(stuNum);

                StringBuilder sb = new StringBuilder();

                Set<String> problemNumsSet = problemMap.keySet();

                List<String[]> li = new ArrayList<>();

                for(String proNums : problemNumsSet){
                    li.add(new String[]{proNums,problemMap.get(proNums)});
                }

                li.sort(comp);

                for(String[] strings1 : li){
                    sb.append(strings1[0]).append(strings1[1]);
                }
                mappingStringMap.put(stuNum,sb.toString());
            }

            Map<String,Boolean> isVisitedMap = new HashMap<>();

            Set<String> stuNumsSet = mappingStringMap.keySet();

            for(String stuNum : stuNumsSet){
                isVisitedMap.put(stuNum,false);
            }

            Set<String> set = new HashSet<>();

            for(String stuNum : stuNumsSet){
                if(isVisitedMap.get(stuNum)) continue;
                String original = mappingStringMap.get(stuNum);

                for(String stuNumLoop : stuNumsSet){
                    if(stuNum.equals(stuNumLoop)) continue;
                    String compare = mappingStringMap.get(stuNumLoop);

                    if(original.equals(compare) && studentProblems.get(stuNum) >= 5 && studentProblems.get(stuNumLoop) >= 5){
                        set.add(stuNum);
                        set.add(stuNumLoop);
                        isVisitedMap.put(stuNum,true);
                        isVisitedMap.put(stuNumLoop,true);
                    }
                }
            }

            List<String> list = new ArrayList<>(set);
            Collections.sort(list);

            if(list.isEmpty()){
                return new String[]{"None"};
            }

            String[] result = new String[list.size()];

            for(int i=0;i<list.size();i++){
                result[i] = list.get(i);
            }
            return result;
        }
    }
}
