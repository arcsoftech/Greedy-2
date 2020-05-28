// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Intuition of this method is difficult


// Your code here along with comments explaining your approach

class Solution {
    public int candy(int[] ratings) {
        int sum = 0;
        int [] candies = new int[ratings.length];
        Arrays.fill(candies,1);
        //left pass
        for(int i = 1;i < ratings.length;i++)
        {
            if( ratings[i]>ratings[i-1])
            {
                candies[i] = candies[i-1] + 1;
            }
        }
        //right pass
        for(int i = ratings.length-2;i >=0;i--)
        {
            if(ratings[i]>ratings[i+1] && candies[i]<=candies[i+1])
            {
                candies[i] = candies[i+1] + 1;
            }
        }
        
        for(int el:candies)
        {
            sum+=el;
        }
        return sum;
    }
}