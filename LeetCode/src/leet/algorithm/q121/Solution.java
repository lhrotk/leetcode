package leet.algorithm.q121;

public class Solution {
	public int maxProfit(int[] prices) {
        int maxProfit = 0;
        if(prices == null||prices.length <=1)
            return maxProfit;
        int preMin = prices[0];
        for(int i=1; i<prices.length; i++){
            if(prices[i]<preMin)
                preMin = prices[i];
            else{
                if(prices[i]-preMin > maxProfit)
                    maxProfit = prices[i] - preMin;
            }
        }
        return maxProfit;
    }
	
	public static void main(String[] args) {
		Solution sol = new Solution();
		int[] data = new int[] {7,6,4,3,1};
		System.out.println(sol.maxProfit(data));
	}
}
