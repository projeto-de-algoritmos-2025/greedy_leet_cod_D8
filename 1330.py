class Solution(object):
    def maxValueAfterReverse(self, nums):
        n = len(nums)
        base = 0
        for i in range(n - 1):
            base += abs(nums[i] - nums[i + 1])

        # Caso 1 -  reversao no meio (nao pega início nem fim)
        # maximiza (max(b) - min(a))
        max_b = float('-inf')
        min_a = float('inf')

        for i in range(n - 1):
            a, b = nums[i], nums[i + 1]
            max_b = max(max_b, min(a, b))
            min_a = min(min_a, max(a, b))

        mid_gain = max(0, (max_b - min_a) * 2)

        # Caso 2: reversao que inclui o início ou o fim
        edge_gain = 0
        for i in range(n - 1):
            edge_gain = max(edge_gain,
                            abs(nums[0] - nums[i + 1]) - abs(nums[i] - nums[i + 1]),
                            abs(nums[-1] - nums[i]) - abs(nums[i] - nums[i + 1]))

        return base + max(mid_gain, edge_gain)
        