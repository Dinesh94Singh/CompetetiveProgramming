import functools

class Solution:
    def validPartition(self, nums: List[int]) -> bool:
        # 2 equal elements
        # 3 equal elements
        # 3 consequite increasing elements

        # need to return true or false

        @functools.lru_cache(maxsize=None)
        def dfs(idx):
            nonlocal nums

            if idx >= len(nums):
                return True
            
            cond = False

            # check if 2 elements are equals
            if idx < len(nums) - 1 and nums[idx] == nums[idx + 1]:
                cond = dfs(idx + 2)
            
            if idx < len(nums) - 2 and nums[idx] == nums[idx + 1] == nums[idx + 2]:
                cond = cond or dfs(idx + 3)
            
            if idx < len(nums) - 2 and nums[idx] + 2 == nums[idx + 1] + 1 == nums[idx + 2]:
                cond = cond or dfs(idx + 3)

            return cond

        return dfs(0)