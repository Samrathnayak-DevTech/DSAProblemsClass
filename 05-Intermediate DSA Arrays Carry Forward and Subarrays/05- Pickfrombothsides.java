// Problem Description

// You are given an integer array A of size N.

// You have to perform B operations. In one operation, you can remove either the leftmost or the rightmost element of the array A.

// Find and return the maximum possible sum of the B elements that were removed after the B operations.

// NOTE: Suppose B = 3, and array A contains 10 elements, then you can:

// Remove 3 elements from front and 0 elements from the back, OR
// Remove 2 elements from front and 1 element from the back, OR
// Remove 1 element from front and 2 elements from the back, OR
// Remove 0 elements from front and 3 elements from the back.


// Problem Constraints

// 1 <= N <= 105

// 1 <= B <= N

// -103 <= A[i] <= 103








// Input Format

// First argument is an integer array A.

// Second argument is an integer B.








// Output Format

// Return an integer denoting the maximum possible sum of elements you removed.



// Example Input

// Input 1:






//  A = [5, -2, 3 , 1, 2]
//  B = 3
// Input 2:

//  A = [ 2, 3, -1, 4, 2, 1 ]
//  B = 4







// Example Output

// Output 1:






//  8
// Output 2:

//  9







// Example Explanation

// Explanation 1:






//  Remove element 5 from front and element (1, 2) from back so we get 5 + 1 + 2 = 8
// Explanation 2:

//  Remove the first element and the last 3 elements. So we get 2 + 4 + 2 + 1 = 9





public class Solution {
    public int max(int Num1, int Num2){
        int result= Num1>Num2?Num1:Num2;
        return result;
    }
    public int solve(int[] A, int B) {
        int n=A.length;

        //lets create the pSum and sSum
        int[] pSum=new int[n];
        int[] sSum=new int[n];

        pSum[0]=A[0];
        sSum[n-1]=A[n-1];

        for (int i=1;i<n;i++){
            pSum[i]=pSum[i-1]+A[i];
        }

        for(int j=n-2;j>=0;j--){
            sSum[j]=sSum[j+1]+A[j];
        }

        //Initalize in such a way that nothing is picked from start and All B items picked from the end
        //or
        //// nothing is picked from end  and All B items picked from the start
        int ans= max(pSum[B-1],sSum[n-B]);

        for (int i=1;i<B;i++){
            ans=max(ans,pSum[i-1]+sSum[n-B+i]);
        }
        return ans;
    }
}

