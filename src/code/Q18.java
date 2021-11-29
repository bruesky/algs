package code;

import java.util.*;

public class Q18 {
    /**
     * @param nums: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // write your code here
        Arrays.sort(nums);
        Set<List<Integer>> ans = new HashSet<>();
        List<Integer> path = new ArrayList<>();
        ans.add(new ArrayList(path));
        for(int i = 0; i < nums.length; i++){
            Set<List<Integer>> tempAns = new HashSet<>();
            for(List<Integer> p : ans){
                List<Integer> tempPath = new ArrayList(p);
                tempPath.add(nums[i]);
                if(!ans.contains(tempPath)){
                    tempAns.add(tempPath);
                }
            }
            ans.addAll(tempAns);
        }
        return new ArrayList<>(ans);
    }

    public List<List<Integer>> subsetsWithDup2(int[] nums) {
        // write your code here
        Arrays.sort(nums);
        Set<List<Integer>> ans = new HashSet<>();
        List<Integer> path = new ArrayList<>();
        process1(nums, 0, path, ans);
        return new ArrayList<List<Integer>>(ans);
    }

    private void process1(int[] nums, int index, List<Integer> path, Set<List<Integer>> ans){

        if(index == nums.length){
            if(!ans.contains(path)){
                ans.add(new ArrayList(path));
            }
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

    public List<List<Integer>> subsetsWithDup3(int[] nums) {
        // write your code here
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        process2(nums, 0, path, ans);
        return ans;
    }

    private void process2(int[] nums, int index, List<Integer> path, List<List<Integer>> ans){
        ans.add(new ArrayList(path));
        for(int i = index; i < nums.length; i++){
            if(i > index && nums[i] == nums[i - 1]){
                continue;
            }
            path.add(nums[i]);
            process2(nums, i + 1, path, ans);
            //backtracre
            path.remove(path.size() - 1);
        }
    }
}
