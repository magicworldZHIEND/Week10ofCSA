import java.util.Stack;

/**
 * @Classname : Main //类名
 * @Description: Week10 DataStructure //描述
 * @Author : Administrator //作者
 * @Date : 2022/2/25 13:35//日期
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("---------第一题---------");
        int number[] = {68,3,68,68,23};
        for(int i: monotonicStack(number)){
            System.out.println(i);
        }
        System.out.println("---------第二题---------");
        colorClassification(number);
        for(int i: number){
            System.out.println(i);
        }


    }

    /**
     * 单调栈写法：
     * @param nums
     * @return
     */
    public static int[] monotonicStack(int[] nums) {
        int[] res = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                int top = stack.pop();
                res[top] = nums[i];
            }
            stack.push(i);
        }
        return res;
    }

    /**
     * 颜色分类
     * @param nums
     */
    public static void colorClassification(int[] nums) {
        int n = nums.length;
        int ptr = 0;
        for (int i = 0; i < n; ++i) {
            if (nums[i] == 0) {
                int temp = nums[i];
                nums[i] = nums[ptr];
                nums[ptr] = temp;
                ++ptr;
            }
        }
        for (int i = ptr; i < n; ++i) {
            if (nums[i] == 1) {
                int temp = nums[i];
                nums[i] = nums[ptr];
                nums[ptr] = temp;
                ++ptr;
            }
        }
    }

}
