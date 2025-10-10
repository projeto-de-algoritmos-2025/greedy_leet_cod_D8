class Solution(object):
    def removeDuplicateLetters(self, s):
        last_index = {c: i for i, c in enumerate(s)}  # última posição de cada caractere
        stack = []
        seen = set()

        for i, c in enumerate(s):
            if c in seen:
                continue

            while stack and c < stack[-1] and i < last_index[stack[-1]]:
                seen.remove(stack.pop())

            stack.append(c)
            seen.add(c)

        return ''.join(stack)
