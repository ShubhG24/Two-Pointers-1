// TC: O(n^2)
// SC: O(1)

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        if(nums == null || nums.length == 0) return new ArrayList<>();
        
        List<List<Integer>> result = new ArrayList<>();
        // sort the given nums array
        Arrays.sort(nums);
        int n= nums.length;
        
        for(int i=0;i<n;i++){
            // to prevent outer loop duplicates
            if(i>0 && nums[i]==nums[i-1]) continue;
            // no need to iterate over positive values as the sum !=0
            if(nums[i]>0) break;
            int left = i+1;
            int right = n-1;
            
            while(left<right){
                int sum = nums[i]+nums[left]+nums[right];
                
                if(sum<0){
                   left++; 
                }
                else if(sum>0){
                    right--;
                }
                else{
                    result.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    left++;
                    right--;
                    // removing inner loop duplicates
                    while(left < right && nums[left]==nums[left-1]){
                        left++;
                    }
                    while(left < right && nums[right]==nums[right+1]){
                        right--;
                    }
                }
            }
        }
        return result;
    }
}