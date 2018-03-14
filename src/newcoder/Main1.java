package newcoder;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        while(sc.hasNext()) {
//            int n = Integer.parseInt(sc.nextLine());
//            String[] strings = sc.nextLine().split("\\s");
//            int[] a = new int[n];
//            for (int i = 0; i < n; i++) {
//                a[i] = Integer.parseInt(strings[i]);
//            }
//            int k = sc.nextInt();
//            int d = sc.nextInt();
            int n = 36;
            int[] a = {7,-15,31,49,-44,35,44,-47,-23,15,-11,10,-21,10,-13,0,-20,-36,22,-13,-39,-39,-31,-13,-27,-43,-6,40,5,-47,35,-8,24,-31,-24,-1};
            int k = 3, d = 31;
            int result = solution(n, a, k, d);
            System.out.println(result);
//        }
    }

    private static int solution(int n, int[] a, int k, int d) {
        if (k > n || d <= 0) {
            return -1;
        }
        int[][] dp = new int[n+1][k+1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j <= k; j++) {
            dp[0][j] = 1;
        }
        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= Math.min(i, k) ; j++) {
                int t = i-d > 0 ? i-d : 1;
                if (a[i-1] >= 0) {
                    dp[i][j] = a[i-1] * maxInRange(dp, t, i, j-1);
                } else {
                    dp[i][j] = a[i-1] * minInRange(dp, t, i, j-1);
                }
                if (dp[i][j] > max) {
                    max = dp[i][j];
                }
            }
        }
        return max;
    }

    private static int minInRange(int[][] dp, int start, int end, int k) {
        if (k == 0 || start > end) {
            return 1;
        }
        int min = Integer.MAX_VALUE;
        for (int j = start; j < end; j++) {
            if (dp[j][k] < min) {
                min = dp[j][k];
            }
        }
        return min;
    }

    private static int maxInRange(int[][] dp, int start, int end, int k) {
        if (k == 0 || start > end) {
            return 1;
        }
        int max = Integer.MIN_VALUE;
        for (int j = start; j < end; j++) {
            if (dp[j][k] > max) {
                max = dp[j][k];
            }
        }
        return max;
    }
}
