// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach

public class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> map = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->{return b-a;});
        for(Character c:tasks)
        {
            map.put(c,map.getOrDefault(c,0)+1);
        }
        pq.addAll(map.values());
        int cycle = 0;
        while(!pq.isEmpty())
        {
            List<Integer>  temp = new ArrayList<>();
            for(int i = 0 ; i <=n;i++)
            {
                if(!pq.isEmpty())
                {
                    temp.add(pq.poll());
                }
            }
            for(int i = 0; i <temp.size();i++)
            {
                if(temp.get(i)-1>0)
                {
                    pq.add(temp.get(i)-1);
                }
            }
            cycle+=pq.isEmpty()?temp.size():n+1;
        }
        return cycle;
    }
}