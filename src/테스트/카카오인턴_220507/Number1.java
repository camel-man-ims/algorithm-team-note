package 테스트.카카오인턴_220507;

/*
RT
CF
JM
AN
 */

import java.util.HashMap;
import java.util.Map;

public class Number1 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(new String[]{"AN", "CF", "MJ", "RT", "NA"},new int[]{5, 3, 2, 7, 5});
    }
    static class Solution {
        static Map<Character,Integer> map;
        static int N;
        public String solution(String[] survey, int[] choices) {
            map = new HashMap<>();
            setMap();
            N = survey.length;

            for(int i=0;i<N;i++){
                String sur = survey[i];
                int choice = choices[i];

                char left = sur.charAt(0);
                char right = sur.charAt(1);

                int score = getScore(choice);

                if(score>0){
                    map.put(right,map.get(right)+score);
                }else{
                    score = score * -1;
                    map.put(left,map.get(left)+score);
                }
            }
            /*
            RT
            CF
            JM
            AN
             */

            StringBuilder sb = new StringBuilder();

            if(map.get('R') >= map.get('T')){
                sb.append('R');
            }else{
                sb.append('T');
            }
            if(map.get('C') >= map.get('F')){
                sb.append('C');
            }else{
                sb.append('F');
            }
            if(map.get('J') >= map.get('M')){
                sb.append('J');
            }else{
                sb.append('M');
            }
            if(map.get('A') >= map.get('N')){
                sb.append('A');
            }else{
                sb.append('N');
            }
            return sb.toString();
        }

        static int getScore(int choice){
            switch (choice){
                case 1:
                    return -3;
                case 2:
                    return -2;
                case 3:
                    return -1;
                case 4:
                    return 0;
                case 5:
                    return 1;
                case 6:
                    return 2;
                case 7:
                    return 3;
            }
            return 999;
        }

        static void setMap(){
            map.put('R',0);
            map.put('T',0);
            map.put('C',0);
            map.put('F',0);
            map.put('J',0);
            map.put('M',0);
            map.put('A',0);
            map.put('N',0);
        }
    }
}
