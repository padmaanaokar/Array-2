// Time Complexity : O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if(nums == null || nums.length == 0) return res;
        // 4 -3 -2 7,8,2,3,1
          // 0 1 2 3 4 5 6 7
        for(int i = 0; i < nums.length; i++){
            int no = Math.abs(nums[i]);
            if(nums[no - 1] > 0){
                nums[no -1] =  nums[no - 1] * (-1);
            }
        }        

        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0){
                res.add(i+1);
            }
        }
        return res;
    }
}