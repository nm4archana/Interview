package dynamicProgramming;

public class LongestCommonSubSequence 
{
   public static int longestCommonSubSequence(String strOne,String strTwo)
   {
	   int[][] matrix = new int[strOne.length()+1][strTwo.length()+1];
	   
	   for(int i=1;i<matrix.length;i++)
	   {
		   for(int j=1;j<matrix[0].length;j++)
		   {
			   if(strOne.charAt(i-1)==strTwo.charAt(j-1))
			   {
				   matrix[i][j]= matrix[i-1][j-1]+1;
			   }
			   else
			   {
				   matrix[i][j] = Math.max(matrix[i-1][j],matrix[i][j-1]);
			   }
		   }
	   }
	   printlongestCommonSubSequence(matrix,strTwo);
	   return matrix[matrix.length-1][matrix[0].length-1];
	   
   }
   public static void printlongestCommonSubSequence(int[][] matrix,String strTwo)
   {   
	   StringBuilder str = new StringBuilder();
	   
	   int i = matrix.length-1;
	   int j = matrix[0].length-1;
	   
	   while(i>0 && j>0)
		  {		   
			if(matrix[i][j]==matrix[i-1][j-1]+1&&matrix[i][j]!=matrix[i-1][j]&&matrix[i][j]!=matrix[i][j-1])
			{
				str.append(strTwo.charAt(j-1));
				i--;
				j--;
			}
			else
			{

				if(matrix[i][j]==matrix[i-1][j])
				{
					i=i-1;
				}
				else
				{
					j=j-1;
				}
			}		
	       }
	   
	System.out.println(str.toString());
   }
   
   
   public static void main(String[] args)
   {
	   String strOne = "abcdaf";
	   String strTwo = "acbcf";
	   System.out.println(longestCommonSubSequence(strOne,strTwo));
   }
	
}
