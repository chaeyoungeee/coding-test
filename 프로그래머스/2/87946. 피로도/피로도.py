from itertools import permutations

def solution(k, dungeons):
    answer = -1
       
    for p in list(permutations(dungeons)):
        l, s = k, 0
        if answer >= len(dungeons): break
            
        for i in p:
            if l < i[0]:
                break
            l -= i[1]
            s += 1
        answer = max(answer, s)
        
    return answer