package dynamicProgramming;

public class SubsetSumProblem
{
   public static Boolean subsetSum(int[] subset, int total)
   {
	Boolean[][] matrix = new Boolean[subset.length][total+1];   
	
	for(int i=0;i<matrix.length;i++)
	{
		for(int j=0;j<matrix[0].length;j++)
		{
			if(j==0)
			{
				matrix[i][j]=true;
			}
			
		   else if(i==0&&j>0)
			{
			  
				if(subset[i]==j)
				{
					matrix[i][j]=true;
				}
				else
				{
					matrix[i][j]=false;
				}
			}
			else
			{ 
				if(subset[i]>j)
				{
					matrix[i][j]=matrix[i-1][j];
				}
				else
				{
					if(matrix[i-1][j]==true)
						matrix[i][j]=true;	
					else
					    matrix[i][j]=matrix[i-1][j-subset[i]];
				}
			}
		}
	}
	return matrix[matrix.length-1][matrix[0].length-1];
	   
   }
	
	public static void main(String[] args)
	{
		int[] subset = {2,3,7,8,10};
		int total = 2;
		
		if(subsetSum(subset,total))
		{
			System.out.println("There exists the given sum in the subset");
		}
		else
		{
			System.out.println("The given sum in the subset does not exist");
		}
	}
}
