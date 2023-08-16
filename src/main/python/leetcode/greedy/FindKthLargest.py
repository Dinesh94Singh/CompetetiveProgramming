import heapq

"""
Heap will have K Large items

Min with have the Kth Largest Item

Min Heap - Hence Min heap
"""
class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        heap = []

        for each in nums:
            if len(heap) < k:
                heapq.heappush(heap, each)
            elif heap[0] < each:
                heapq.heappop(heap)
                heapq.heappush(heap, each)

        return heap[0]