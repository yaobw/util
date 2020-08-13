package algorithm.meidum;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @description:
 * @author: yaobw
 * @date: 2020/8/11 11:57 上午
 */
public class NthUglyNumber {

    private static int[] uglyNum = {2, 3, 5};

    public static int nthUglyNumber(int n) {
        Queue<Long> queue = new PriorityQueue<>();
        queue.add(1L);
        int i = 1;
        long ugly = 0;
        while (queue.size() <= n) {
            for (Integer num : uglyNum) {
                ugly = i * num;
                if (queue.contains(ugly)) {
                    continue;
                }
                queue.add(ugly);
                if (queue.size() == n) {
                    break;
                }
            }
            i++;
        }
        return Integer.valueOf(String.valueOf(queue.poll()));
    }

    public static int nthUglyNumber3(int n) {
        PriorityQueue<Long> queue = new PriorityQueue<>();
        queue.offer(1L);
        long cur = 0;
        while (n != 0) {
            if (queue.peek() != cur) {
                n--;
                cur = queue.poll();
                queue.offer(cur * 2);
                queue.offer(cur * 3);
                queue.offer(cur * 5);
            } else {
                queue.poll();
            }
        }
        return (int) cur;
    }

    public static void main(String[] args) {
        System.out.println(nthUglyNumber(10));
    }

    public static int nthUglyNumber4(int n) {
        // 集合&队列
        HashSet<Long> rec = new HashSet<>();
        PriorityQueue<Long> pq = new PriorityQueue<>();
        int[] factor = new int[]{2, 3, 5};
        int i = 1;
        rec.add(1L);
        pq.offer(1L);

        while (true) {
            long e = pq.poll();
            if (i == n) {
                return (int) e;
            }
            i++;
            for (int f : factor) {
                if (!rec.contains(e * f)) {
                    rec.add((long) e * f);
                    pq.offer((long) e * f);
                }
            }
        }
    }


    public static int nthUglyNumber2(int n) {
        Queue<Integer> queue = new PriorityQueue<>();
        queue.add(1);
        int count = 0;
        while (!queue.isEmpty()) {
            int cut = queue.poll();
            if (++count >= n) {
                return (int) cut;
            }
            for (int num : uglyNum) {
                if (!queue.contains(num * cut)) {
                    queue.add(num * cut);
                }
            }
        }
        return -1;
    }

}
