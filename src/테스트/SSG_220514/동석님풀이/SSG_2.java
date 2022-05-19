package 테스트.SSG_220514.동석님풀이;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SSG_2 {
	
	public static void main(String[] args) {
		String[] logs = {"0001 3 95", "0001 5 90", "0001 5 100", "0002 3 95", "0001 7 80", "0001 8 80", "0001 10 90", "0002 10 90", "0002 7 80", "0002 8 80", "0002 5 100", "0003 99 90"};
		String[] arr = solution(logs);
		for(String s : arr) {
			System.out.println(s);
		}
	}
	
	
	static Map<String, Map<Integer,Integer>> map;
	static Set<String> set = new HashSet<String>(); // 부정행위자
	
	public static String[] solution(String[] logs) {
		map = new HashMap<String, Map<Integer,Integer>>();
		for(int i=0,len=logs.length; i<len; ++i) {
			String[] str = logs[i].split(" ");
			String id = str[0];
			int num = Integer.parseInt(str[1]);
			int score = Integer.parseInt(str[2]);
			Map<Integer,Integer> m = map.getOrDefault(id, new HashMap<Integer, Integer>());
			m.put(num, score);
			map.put(id, m);
		}
		ArrayList<String> arr = new ArrayList<String>();
		for(String id : map.keySet()) {
			if(map.get(id).size()>=5) arr.add(id); // 5문제 이상 풀면 추가
		}
		
		int size = arr.size();
		for(int i=0; i<size; ++i) {
			for(int j=i+1; j<size; ++j) {
				func(arr.get(i),arr.get(j));
			}
		}

		if(set.size()==0) { // 부정행위자 없으면
			return new String[]{"None"};
		}
		String[] answer = new String[set.size()];
		int idx = 0;
		for(String k : set) {
			answer[idx++] = k;
		}
		Arrays.sort(answer);
		return answer;
	}
	public static void func(String id1, String id2) {
		Map<Integer, Integer> m1 = map.get(id1);
		Map<Integer, Integer> m2 = map.get(id2);
		if(m1.size()==m2.size()) { // 문제수 같으면
			for(int num : m1.keySet()) { // 각 문제마다
				if(m1.get(num)!=m2.getOrDefault(num, -1)) { // 점수가 다른 경우가 있으면
					return;
				}
			}
			set.add(id1);
			set.add(id2);
		}
	}
	
}