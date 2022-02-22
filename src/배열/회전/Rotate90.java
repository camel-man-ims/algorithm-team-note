package 배열.회전;

public class Rotate90 {
    static int N,M;
    public static void main(String[] args) {
        int[][] arr = new int[][]{
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16},
                {17,18,19,20}
        };
        N = arr.length;
        M = arr[0].length;
        int[][] newArr = new int[M][N];

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                newArr[j][N-1-i] = arr[i][j];
                print(newArr);
                System.out.println("====");
            }
        }

        print(newArr);
    }

    private static void print(int[][] a) {
        for(int i=0;i<M;i++){
            for(int j=0;j<N;j++){
                System.out.print(a[i][j]+ " ");
            }
            System.out.println();
        }
    }
}
