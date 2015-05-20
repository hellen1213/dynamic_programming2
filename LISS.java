package q4;

import java.util.Arrays;
/**
 * find the longest increasing substring of a given int[]
 * @author yanan liang
 *
 */
public class LISS {

	public int[] getLongestStr (int[] nums){
		if (nums == null || nums.length == 0) {
			return null ;
		}
		int max = Integer.MIN_VALUE ;
		int [] dp  = new int [nums.length] ;
		int [] track = new int [nums.length] ;
		Arrays.fill(track, -1);
		int start = 0 ;
		Arrays.fill(dp, 1);
		for (int i = 1 ; i < nums.length  ; ++i) {
		  for (int j = 0 ; j < i ; ++j) {			 
			  if (nums[i] > nums[j]) {				  				 				    
				  if (dp[j] + 1 > dp[i]) {
					  dp[i] = dp[j] + 1 ;
					  track[i] = j;
				  }				  	
			  }
			  if (dp[i] > max) {
				  max = dp[i] ;
		//		  track[i] = j ;
				  start = i ;					  				  			 	 
			  } 			 
		  }
		}	
		
//		for(int ele: track)
	//		System.out.println(ele);
		StringBuilder  rst = new StringBuilder ();	
	    int index = start ;	 
	    System.out.println(start);
	    rst.append(nums[start]) ;
		while (track[index] != -1) {
			index = track[index];
			rst.append(' ');
			rst.append(nums[index]) ;
		}		
	//	rst.reverse() ;
		String[] tmp = rst.toString().split(" ");
		int[] result = new int[tmp.length];
		for(int i = 0; i< tmp.length;i++){
			result[i] = Integer.parseInt(tmp[tmp.length -i -1]);
		}
		
		return result;

}
	
	public static void main(String[] args) {
		int[] test = {-1, 2, 100, 100, 101, 3,4, 5, -7};
		LISS l = new LISS();
		int[] dd = l.getLongestStr(test);
		for(int ele: dd){
			System.out.print(ele + " ");
		}

	}

}
