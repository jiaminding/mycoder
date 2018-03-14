package newcoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main3 {
    public List<List<Integer>> ans(int[] a, int target) {
        List<List<Integer>> res = new ArrayList<>();
//        Arrays.sort(a);
        helper(res, new ArrayList<Integer>(), a, target, 0);
        return res;
    }

    public void helper(List<List<Integer>> res, List<Integer> list, int[] nums, int target, int start) {
        if (target == 0) {
            res.add(new ArrayList<Integer>(list));
        } else if (target > 0) {
            for (int i = start; i < nums.length; i++) {
                if (i > start && nums[i] == nums[i - 1] || nums[i] > target) continue;
                list.add(nums[i]);
                helper(res, list, nums, target - nums[i], i + 1);
                list.remove(list.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {5,4,3,2,1};
        int target = 10;
        Main3 main3 = new Main3();
        System.out.println(main3.ans(a, target));
    }
}
