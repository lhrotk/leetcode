package leet.algorithm.q122;


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
                if(prices[i]-preMin > 0) {
                    maxProfit += prices[i] - preMin;
                    preMin = prices[i];
                }
            }
        }
        return maxProfit;
    }
	
	public static void main(String[] args) {
		Solution sol = new Solution();
		int[] data = new int[] {7,1,5,6,3,7};
		System.out.println(sol.maxProfit(data));
	}
}
