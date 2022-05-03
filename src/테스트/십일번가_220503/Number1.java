package 테스트.십일번가_220503;

public class Number1 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int solution1 = solution.solution(153786, 153786);
        System.out.println(solution1);
    }
    static class Solution {
        static int len;
        public int solution(int A, int B) {
            String s1 = String.valueOf(A);
            String s2 = String.valueOf(B);
            len = -1;
            if(s1.length() > s2.length()) return -1;

            for(int i=0;i<=s2.length()-s1.length();i++){
                String substring = s2.substring(i, i + s1.length());
                if(s1.equals(substring)){
                    len = i;
                    break;
                }
            }
            return len;
        }
    }
}
