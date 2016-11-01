package dynamicProgramming;

import java.util.Arrays;

public class MinCoinChange
{
    public static void minCoinChange(int[] coins, int totalAmt)
    {

    	int[] totArr = new int[totalAmt+1];
    	int[] indexArr = new int[totalAmt+1];
    	
    	Arrays.fill(totArr, Integer.MAX_VALUE);
    	Arrays.fill(indexArr, -1);
    	
    	
    	for(int i=0;i<coins.length;i++)
    	{
    		for(int j=0;j<totArr.length;i++)
    		{
    			
    		}
    	}
    }
    
    public static void printCoins(int[] indexArr,int[] coins)
    {
    	
    }
    
    public static void main(String[] args)
    {
    	//The coins available 
    	int coins[] = {2,4,7,5,9};
    	
    	//The total amount for which the minimum number of coins has to be found
    	int totalAmt = 10; 
    	
    	minCoinChange(coins,totalAmt);
    }
}
