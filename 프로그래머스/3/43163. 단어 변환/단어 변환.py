from collections import deque

def solution(begin, target, words):
    q = deque([(begin, 0)])
    visited = {begin}

    while q:
        now, cnt = q.popleft()
        if now == target: return cnt

        for word in words:
            if word not in visited and sum(a != b for a, b in zip(now, word)) == 1:
                visited.add(word)
                q.append((word, cnt + 1))

    return 0