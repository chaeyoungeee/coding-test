import heapq

result = []

def comb(data, i, n, k, cnt):
    if cnt == n:
        result.append(data.copy())
        return 
    for i in range(i, k+1): # k: 유형 수
        data[i] = data.get(i, 0) + 1
        comb(data, i, n, k, cnt+1)
        data[i] -= 1
    

def solution(k, n, reqs):
    answer = float('inf')
    comb({i: 1 for i in range(1, k+1)}, 1, n-k, k, 0)
    
    for i in range(len(result)):
        t = 0
        h_pool = [[] for _ in range(k+1)]
        for j in range(1, k+1):
            r = result[i]
            for _ in range(r[j]): heapq.heappush(h_pool[j], 0)
            
        for r in reqs:
            a, b, c = r
            end = heapq.heappop(h_pool[c])
        
            if end <= a:
                heapq.heappush(h_pool[c], a+b)
            else:
                t += (end-a)
                heapq.heappush(h_pool[c], end+b)
                
        answer = min(answer, t)
    
    return answer