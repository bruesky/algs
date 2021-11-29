package code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q17 {
    /**
     * @param nums: A set of numbers
     * @return: A list of lists
     */
    public List<List<Integer>> subsets(int[] nums) {
        // write your code here
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        ans.add(new ArrayList(path));
        for(int i = 0; i < nums.length; i++){
            List<List<Integer>> tempAns = new ArrayList<>();
            for(List<Integer> p : ans){
                List<Integer> tempPath = new ArrayList(p);
                tempPath.add(nums[i]);
                tempAns.add(tempPath);
            }
            ans.addAll(tempAns);
        }
        return ans;
    }


    public List<List<Integer>> subsets2(int[] nums) {
        // write your code here
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        process2(nums, 0, path, ans);
        return ans;
    }

    private void process1(int[] nums, int index, List<Integer> path, List<List<Integer>> ans){
        if(index == nums.length){
            ans.add(new ArrayList(path));
            return;
        }
        //not include
        process1(nums, index + 1, path, ans);
        //include
        path.add(nums[index]);
        process1(nums, index + 1, path, ans);
        //backtracre
        path.remove(path.size() - 1);
    }

    private void process2(int[] nums, int index, List<Integer> path, List<List<Integer>> ans){
        ans.add(new ArrayList(path));

        for(int i = index; i < nums.length; i++){
            path.add(nums[i]);
            process2(nums, i + 1, path, ans);
            path.remove(path.size() - 1);
        }
    }
}
