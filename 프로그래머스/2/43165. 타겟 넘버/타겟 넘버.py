from collections import deque

def solution(numbers, target):
    cnt = 0
    q = deque([(numbers[0], 0), (-numbers[0], 0)])
    
    while q:
        n, k = q.popleft()
        if k == len(numbers)-1:
            if n == target: cnt += 1
        else:
            k += 1
            q.append((n+numbers[k], k))
            q.append((n-numbers[k], k))
        
    return cnt