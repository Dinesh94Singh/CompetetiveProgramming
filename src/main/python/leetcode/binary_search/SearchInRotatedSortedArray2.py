class Solution:
    """ Just use one Binary Search insted of 2 way binary search !! """

    """
        1. Get Mid 
        2. See if Mid has the Target -> If yes, return True
        3. See if Lo ----> Mid is sorted (If Yes, we are inside the sorted region)
            1. Check if Target falls inside lo ----> mid -> If so, hi = mid - 1
            2. If the target doesn't fall inside lo ---> mid and its sorted, then there is no chance, it to be here -----> so lo = mid + 1
        4. Lo -----> Mid is not the sorted region, So, Mid ----> Hi should be sorted (since question only has 1 pivoting point)
            1. Check if Target falls inside mid ---> target -----> hi => If yes, lo = mid + 1
            2. If the target is not inside - decrease the seach space to lo ---> mid - 1 # This is where the solution would be


        To Remove duplicates, just move lo and hi pointers so that, they are at their last occurences 
    """
    def search(self, A, target):
        if len(A) == 1:
            return A[0] == target

        lo = 0
        hi = len(A) - 1


        while lo <= hi:

            # Remove dups

            while lo < hi and A[lo] == A[lo + 1]:
                lo = lo + 1

            while lo < hi and A[hi] == A[hi - 1]:
                hi = hi - 1

            mid = lo + (hi - lo) // 2

            if A[mid] == target:
                return True
            elif A[lo] <= A[mid]: # Meaning lo ----> mid (its sorted)
                if A[mid] >= target and A[lo] <= target: # Check if Target exists within lo --- target --> mid
                    hi = mid - 1
                else: # Check if Target exists within mid + 1 ----> hi
                    lo = mid + 1
            else:
                if A[mid] <= target <= A[hi]: # Meaning mid ----> target ----> hi
                    lo = mid + 1
                else:
                    hi = mid - 1

        return False
            
