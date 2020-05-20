package algorithm.easy;

/**
 * @description: merge two ordered arrays into one bigger array and order it
 * @author: yaobw
 * @date: 2020/5/19 4:49 下午
 */
public class MergeArrayAndOrder {

    public void merge(int[] A, int m, int[] B, int n) {
        // 先确保将其中一个数组中的数字遍历完
        while (m > 0 && n > 0) {
            // 对比选出较大的数放在 m + n - 1 的位置，并将选出此数的指针向前移动
            A[m + n - 1] = A[m - 1] > B[n - 1] ? A[m-- - 1] : B[n-- - 1];
        }
        // 剩下的数都比已经遍历过的数小
        // 如果 m 不为 0，则 A 没遍历完，都已经在 A 中不用再管
        // 如果 n 不为 0，则 B 没遍历完，直接全移到 A 中相同的位置
        while (n > 0) {
            A[n - 1] = B[n - 1];
            n--;
        }
    }

    public static void main(String[] args) {
        int[] A = new int[]{1, 2, 3, 0, 0, 0};
        int[] B = new int[]{2, 5, 6};
        new MergeArrayAndOrder().merge(A, 3, B, 3);
        for (int i = 0; i < A.length; i++) {
            System.out.print(A[i] + ",");
        }
    }
}
