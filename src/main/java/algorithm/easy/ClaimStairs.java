package algorithm.easy;

/**
 * @description:
 * @author: yaobw
 * @date: 2020/7/27 6:24 下午
 */
public class ClaimStairs {

    public static void main(String[] args) {
        int n = 10;
        int[] cache = new int[n + 1];
        cache[0] = 1;
        cache[1] = 1;
        for(int i = 2; i <= n; i++){
            cache[i] = cache[i-1] + cache[i-2];
        }
        System.out.println(cache[n]);
    }
}
