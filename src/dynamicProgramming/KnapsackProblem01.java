package dynamicProgramming;

/*
 Given weights and values of n items, put these items in a knapsack of capacity W to get the 
 maximum total value in the knapsack. In other words, given two integer arrays val[0..n-1] a
 and wt[0..n-1] which represent values and weights associated with n items respectively. 
 Also given an integer W which represents knapsack capacity, find out the maximum value 
 subset of val[] such that sum of the weights of this subset is smaller than or equal to W. 
 You cannot break an item, either pick the complete item, or don’t pick it (0-1 property). 
 */


public class KnapsackProblem01 
{
	 //To find the maximum total value of the weights
     public static int maxTotalValue(int[] weight, int[] value, int totWeight)
     {
    	 int[][] matrix = new int[value.length][totWeight+1];
    	 
    	 for(int i=0;i<matrix.length;i++)
    	 {
    		 for(int j=1;j<matrix[0].length;j++)
    		 {   
    			 if(i == 0)
    			 {
    				 if(j>=weight[i])
    				 matrix[i][j] = value[i];
    			 }
    			 else
    			 {   // The maximum value by either including/excluding the current weight 
    				 if(j>=weight[i])
    	             // Including the value of current weight 
    				 matrix[i][j] = Math.max(value[i]+matrix[i-1][j-weight[i]], matrix[i-1][j]);
    				 else
    					 // Not including the value of current weight 
    					 matrix[i][j] = matrix[i-1][j];
    			 }
    		 }
    		
    	 }
      
	   	 return matrix[matrix.length-1][matrix[0].length-1];
     }
     
     public static void main(String[] args)
     {
    	 //Weight of N items
    	 int[] weight = {1,3,4,5};
    	 //Value of N items
    	 int[] value = {1,4,5,7};
    	 //Total weight
    	 int totWeight = 7;
    	 int maxVal = maxTotalValue(weight,value,totWeight);
    	 System.out.println("The maximum value subset is: "+maxVal);
     }
}
