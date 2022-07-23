package 테스트.SSG_220514.동석님풀이;

public class SSG_1 {
	
	public static void main(String[] args) {
		int[] v = {4,5,5};
		int a = 2;
		int b = 1;
		System.out.println(solution(v, a, b));
	}

	public static int solution(int[] v, int a, int b) {
		int answer = 0;
		int min = Integer.MAX_VALUE;
		int len = v.length;
		for(int i=0; i<len; ++i) {
			if(v[i]<min) min = v[i];
		}
		if(a==b) {
			return min/b;
		}
		int gap = a-b;
		int high = min/b; // 최대 달릴 수 있는 시간
		int low = 0;
		int mid = 0;
		while(low<=high) {
			mid = (high+low)/2;
			long cnt = 0;
			for(int i=0; i<len; ++i) {
				cnt += (v[i]- (long) mid *b)/gap;
			}
			if(cnt>=mid) { // 달릴 수 있으면
				low = mid+1;
				answer = mid;
			}else { // 달리 수 없으면
				high = mid-1;
			}
		}
		return answer;
	}
}