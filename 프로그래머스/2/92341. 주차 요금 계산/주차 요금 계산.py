import math
from collections import defaultdict

def toMin(time):
    h, m = map(int, time.split(":"))
    return h * 60 + m

def duration(start, end):
    return toMin(end) - toMin(start) 
    

def solution(fees, records):
    answer = []
    cin = defaultdict(int)
    acc = defaultdict(int)
    
    for record in records:
        time, car, rec = record.split(' ')
        if rec == 'IN':
            cin[car] = time
        else:
            acc[car] += duration(cin.pop(car), time)
    
    for car in cin.keys():
        acc[car] += duration(cin[car], "23:59")
        
    for car in sorted(acc.keys()):
        if fees[0] >= acc[car]:
            answer.append(fees[1])
        else:
            answer.append(fees[1] + math.ceil((acc[car]-fees[0])/fees[2])*fees[3])
            
    return answer