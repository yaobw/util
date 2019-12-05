package find;

/**
 * @author yaobw
 * @description binary search
 * @date 2019/12/5
 */
public class FindValueInArray {

    public static int findValue(int[] array, int key) {
        int left = 0;
        int right = array.length;
        int mid = (left + right) / 2;
        while (left < right) {
            if (array[mid] < key) {
                right = mid;
                mid = (right - left) / 2;
            } else if (array[mid] > key) {
                left = mid + 1;
                mid = (right - left) / 2;
            } else if (array[mid] == key) {
                return mid;
            }
        }
        return -1;
    }
}
