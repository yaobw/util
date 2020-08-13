package algorithm.easy;

/**
 * @description:
 * @author: yaobw
 * @date: 2020/8/11 11:46 上午
 */
public class ReplaceSpace {

    public static String replaceSpace(String s) {
        StringBuffer sb = new StringBuffer();
        char[] array = s.toCharArray();
        for(int i = 0; i < array.length; i++){
            if(array[i] == ' '){
                sb.append("%20");
            } else{
                sb.append(array[i]);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "We are happy.";
        System.out.println(replaceSpace(s));
    }
}
