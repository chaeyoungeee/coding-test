from pprint import pprint

def solution(n, left, right):
    rm1 =  left // n
    re1 = left % n
    rm2 = right // n
    re2 = right % n
    result = []
    
    for i in range(rm1+1, rm2+2):
        for j in range(1, n+1):
            if j < i:
                result.append(i)
            else:
                result.append(j)
    
    return result[re1:(rm2-rm1)*n+re2+1]
    
