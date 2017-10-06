package leet.algorithm.q50;

public class Solution {
	public double myPow(double x, int n) {
        if(n==0 || x==1)
        	return 1;
        else if(x==0)
        	return 0;
        else if(n==1)
        	return x;
        else if(n==-1){
        	return 1/x;
        }else {
        	if(n%2==0) {
        		double tempResult = myPow(x, n/2);
        		return tempResult*tempResult;
        	}else {
        		double tempResult = myPow(x, (n-1)/2);
        		return tempResult*tempResult*x;
        	}
        }
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
		System.out.println(sol.myPow(2,-4));
	}

}
