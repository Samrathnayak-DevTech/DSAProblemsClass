/*
 * 
 * 
Closest MinMax

Problem Description

Given an array A, find the size of the smallest subarray such that it contains at least one occurrence of the maximum value of the array

and at least one occurrence of the minimum value of the array.



Problem Constraints

1 <= |A| <= 2000



Input Format

First and only argument is vector A



Output Format

Return the length of the smallest subarray which has at least one occurrence of minimum and maximum element of the array



Example Input

Input 1:

A = [1, 3, 2]
Input 2:

A = [2, 6, 1, 6, 9]


Example Output

Output 1:

 2
Output 2:

 3


Example Explanation

Explanation 1:

 Take the 1st and 2nd elements as they are the minimum and maximum elements respectievly.
Explanation 2:

 Take the last 3 elements of the array.


 */

 public class Solution {
    public int solve(int[] A) {
        int n=A.length;
        //find min and max of the array 
        int minNum=A[0];
        int maxNum=A[0];
        for(int i= 0;i<n;i++){
            if(A[i]<minNum){
                minNum=A[i];
            }
            if(A[i]>maxNum){
                maxNum=A[i];
            }

        }

        //corner case if Min and max is same then length is 1
        if(minNum==maxNum){return 1;}

        //now find the length 
        //define the index to be carry forwarded
        int min_idx=-1;
        int max_idx=-1;
        int ans=n;
        for(int i = 0;i<n;i++){
            if(A[i]==minNum){
                min_idx=i;
                if(max_idx!=-1){
                    ans=ans<(i-max_idx+1)?ans:(i-max_idx+1);
                }
            }
            else if(A[i]==maxNum){
                max_idx=i;
                if(min_idx!=-1){
                    ans=ans<(i-min_idx+1)?ans:(i-min_idx+1);
                }
            }
        }
        return ans;
    }
}
