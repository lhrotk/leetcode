package leet.algorithm.q29;
/**
 * 
 * @author lhrotk
 *
 */
public class Solution {
	public static long MAX_ABSOLUTE_POSITIVE_INT = 2147483647L;
	public static long MAX_ABSOLUTE_NEGATIVE_INT = 2147483648L;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
		System.out.println(sol.divide(65536, 16));
	}
	/**
	 * overflow when divisor = 0;
	 * potential overflow when divisor = -1;
	 */
	public int divide(int divident, int divisor){
		if(divisor == 0 && divident > 0){
			return 2147483647;
		}else if(divisor == 0 && divident < 0){
			return -2147483648;
		}
		int flag;
		long result=0;
		long dividentL = divident;
		long divisorL = divisor;
		dividentL = Math.abs(dividentL);
		divisorL = Math.abs(divisorL);
		if(divident>0&&divisor>0||divident<0&&divisor<0){
			flag = 1;
		}else{
			flag = -1;
		}
		while(divisorL<=dividentL){
			long confirmd = 1;
			long divisorTry = divisorL+divisorL;
			long lastAvailableDivisor = divisorL;
			while(divisorTry<dividentL){
				confirmd += confirmd;
				lastAvailableDivisor = divisorTry;
				divisorTry += divisorTry;
			}
			result += confirmd;
			dividentL = dividentL - lastAvailableDivisor;
		}
		if(flag==1){
			if(result>MAX_ABSOLUTE_POSITIVE_INT) {
				return (int)MAX_ABSOLUTE_POSITIVE_INT;
				}
			else {
				return (int)result;
				}
		}else{
			if(result>MAX_ABSOLUTE_NEGATIVE_INT) {
				return (int)(-1*MAX_ABSOLUTE_NEGATIVE_INT);
				}
			else {
				return (int)(0-result);
				}
		}
	}

}
