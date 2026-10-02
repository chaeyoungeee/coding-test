import heapq
from collections import defaultdict

def solution(operations):
    maxH = [] # 최대힙
    minH = [] # 최소힙
    dic = defaultdict(int)
    
    for op in operations:
        a, b = op.split(" ")
        if a == 'I':
            heapq.heappush(maxH, -int(b))
            heapq.heappush(minH, int(b))
            dic[int(b)] += 1
        else:
            if b == "1": # 최댓값 삭제
                while maxH:
                    n = -heapq.heappop(maxH)
                    if dic[n] > 0:
                        dic[n] -= 1
                        break
            else: # 최솟값 삭제
                while minH:
                    n = heapq.heappop(minH)
                    if dic[n] > 0:
                        dic[n] -= 1
                        break
                
    answer = [0, 0]
    while maxH:
        n = -heapq.heappop(maxH)
        if dic[n] > 0:
            answer[0] = n
            break
            
    while minH:
        n = heapq.heappop(minH)
        if dic[n] > 0:
            answer[1] = n
            break
    return answer