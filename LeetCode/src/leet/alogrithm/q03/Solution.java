package leet.alogrithm.q03;

import java.util.Arrays;

class Solution {
	public static int getNextIndex(int[] nums, int index, int tail, int ref){
		int nextIndex = (index + tail)/2;
		while(index<=tail){
			if(nums[nextIndex]<=ref){
				index = nextIndex + 1;
				nextIndex = (tail + index)/2;
			}else{
				tail = nextIndex -1;
				nextIndex = (nextIndex + index)/2;
			}
		}
		return index;
	}
	
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    	int index1 = 0, index2 = 0, tail1=nums1.length-1, tail2 = nums2.length-1;
    	int accumulator = 0;
    	int value1 = 0;
    	int value2 = 0;
    	int midOne = (int) Math.floor((nums1.length + nums2.length + 1)/2.0);
    	int midTwo = (int) Math.ceil((nums1.length + nums2.length + 1)/2.0);
    	if(tail1<0){
    		return (nums2[midOne-1]+nums2[midTwo-1])/2.0;
    	}
    	if(tail2<0){
    		return (nums1[midOne-1]+nums1[midTwo-1])/2.0;
    	}
    	while(true){
    		int next_index1 = getNextIndex(nums1, index1, tail1, nums2[index2]);
    		if(accumulator < midOne && next_index1 - index1 + accumulator >= midOne){
    			value1 = nums1[midOne-accumulator+index1-1];
    		}
    		if(accumulator < midTwo && next_index1 - index1 + accumulator >= midTwo){
    			value2 = nums1[midTwo-accumulator+index1-1];
    			break;
    		}
    		accumulator+=next_index1-index1;
    		index1 = next_index1;
    		if(index1 > tail1){
    			if(accumulator<midOne){
    				value1 = nums2[index2+midOne-accumulator-1];
    			}
    			value2 = nums2[index2+midTwo-accumulator-1];
    			break;
    		}
    		int next_index2 = getNextIndex(nums2, index2, tail2, nums1[index1]);
    		if(accumulator < midOne && next_index2 - index2 + accumulator >= midOne){
    			value1 = nums2[midOne-accumulator+index2-1];
    		}
    		if(accumulator < midTwo && next_index2 - index2 + accumulator >= midTwo){
    			value2 = nums2[midTwo-accumulator+index2-1];
    			break;
    		}
    		accumulator+=next_index2-index2;
    		index2 = next_index2;
    		if(index2 > tail2){
    			if(accumulator<midOne){
    				value1 = nums1[index1+midOne-accumulator-1];
    			}
    			value2 = nums1[index1+midTwo-accumulator-1];
    			break;
    		}
    	}
    	return (value1 + value2)/2.0;
    }
    
    public static void main(String[] args){
    	int nums1[] = {1};
    	int nums2[] = {1};
    	Solution sol = new Solution();
    	System.out.println(sol.findMedianSortedArrays(nums1, nums2));
    }
}