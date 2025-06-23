import java.util.*;
class Solution {
    public int solution(int[] nums) {
        Map<Integer,Integer> poketmons = new HashMap<>();
        for (int n : nums) {
            poketmons.put(n, poketmons.getOrDefault(n,0)+1);
        }
        
        int max = nums.length / 2;
        int poketCnt = poketmons.keySet().size();
        
        return Math.min(max, poketCnt);
    }
}