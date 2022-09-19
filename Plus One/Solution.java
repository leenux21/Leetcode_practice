/*You are given a large integer represented as an integer array digits, where each digits[i] is the ith digit of the integer. The digits are ordered from most significant to least significant in left-to-right order. The large integer does not contain any leading 0's.

Increment the large integer by one and return the resulting array of digits.

 

Example 1:

Input: digits = [1,2,3]
Output: [1,2,4]
Explanation: The array represents the integer 123.
Incrementing by one gives 123 + 1 = 124.
Thus, the result should be [1,2,4].
Example 2:

Input: digits = [4,3,2,1]
Output: [4,3,2,2]
Explanation: The array represents the integer 4321.
Incrementing by one gives 4321 + 1 = 4322.
Thus, the result should be [4,3,2,2].
Example 3:

Input: digits = [9]
Output: [1,0]
Explanation: The array represents the integer 9.
Incrementing by one gives 9 + 1 = 10.
Thus, the result should be [1,0].
 

Constraints:

1 <= digits.length <= 100
0 <= digits[i] <= 9
digits does not contain any leading 0's.*/

class Solution {
    public int[] plusOne(int[] digits) {
        int size = digits.length;
        int carry=0;
        if(digits[size-1] != 9)
        {
            digits[digits.length-1]++;
            return digits;
        }
        else
        {
            digits[size-1] = 0;
            carry = 1; 
            for(int i = size-2;i>=0;i--)
            {
                int res = digits[i]+carry;
                if(res >= 10)
                {
                    carry = 1;
                    digits[i] = res%10;
                }
                else
                {
                    digits[i] = res;
                    carry = 0;
                }
            }
            if(carry == 0)
                return digits;
            else
            {
                int[] new_digits = new int[size+1];
                new_digits[0] = 1;
                for(int j=1;j<size;j++)
                    new_digits[j]=digits[j-1];
                return new_digits;
            }
        }
        
    }
}