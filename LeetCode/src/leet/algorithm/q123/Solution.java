package leet.algorithm.q123;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(sol.maxProfit(new int[] {5,4,3,2,1}));
	}
	
	public int maxProfit(int[] prices) {
        int maxSingleProfit = 0;
        if(prices.length<2)
        	return 0;
        int leftMin = prices[0];
        boolean increasing = true;
        List<buyPoint> buyDays = new ArrayList<buyPoint>();
        for(int i=1; i<prices.length; i++) {
        	//calculate 
        	if(prices[i]==prices[i-1])
        		continue;
        	else if(prices[i]>prices[i-1]){
        		
        		for(int j=0; j<buyDays.size(); j++) {
        			buyDays.get(j).updateRightProfit(prices[i]);
        		}
        		

        		if(!increasing) {
        			buyPoint newDay = new buyPoint(prices[i-1], maxSingleProfit, prices[i]-prices[i-1]);
        			buyDays.add(newDay);
        		}
        		
        		increasing = true;
        	}else {
        		
        		increasing = false;
        	}
        	//calculate left max profit
        	if(prices[i]<leftMin) {
        		leftMin = prices[i];
        	}else{
        		maxSingleProfit = Math.max(maxSingleProfit, prices[i]-leftMin);
        	}
        }
        
        for(int i=0; i<buyDays.size(); i++) {
        	maxSingleProfit = Math.max(maxSingleProfit, buyDays.get(i).getSum());
        }
        
        return maxSingleProfit;
    }
}

class buyPoint{
	int currentPrice;
	int leftMaxSingleSale;
	int rightMaxSingleSale;
	void updateRightProfit(int newPoint) {
		this.rightMaxSingleSale = Math.max(rightMaxSingleSale, newPoint-this.currentPrice);
	}
	buyPoint(int currentPrice, int leftMax, int rightMax) {
		this.currentPrice = currentPrice;
		this.leftMaxSingleSale = leftMax;
		this.rightMaxSingleSale = rightMax;
	}
	int getSum() {
		return this.leftMaxSingleSale + this.rightMaxSingleSale;
	}
}
