//LeetCode 128-Longest Consecutive Sequence
//TC=O(n) SC=O(n)
//Difficulty-Medium
//HashSet used
class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet <Integer> set= new HashSet<>();
        for(int num:nums){
            set.add(num);
        }
        int maxLen=0;
        for(int num:set){
            if(!set.contains(num-1)){
              int  current=num;
               int length=1;   
            while(set.contains(current+1)){
                current++;
                length++;}
            maxLen=Math.max(maxLen,length);
        }
        }
        return maxLen;
    }
}
