package leet.algorithm.q134;

public class Solution {
	public int canCompleteCircuit(int[] gas, int[] cost) {
		int minGas = 0;
		int totalChange = 0;
		int resultIndex = 0;
		for(int i=0; i<gas.length; i++) {
			totalChange += gas[i]-cost[i];
			if(totalChange<minGas) {
				minGas = totalChange;
				resultIndex = (i+1)%gas.length;
			}
		}
		if(totalChange<0)
			return -1;
		else {
			return resultIndex;
		}
	}
	
	public static void main(String[] args) {
		Solution sol = new Solution();
		int[] gas = new int[] {0,2,3,0};
		int[] cost = new int[] {2,0,0,3};
		System.out.println(sol.canCompleteCircuit(gas, cost));
	}
}
