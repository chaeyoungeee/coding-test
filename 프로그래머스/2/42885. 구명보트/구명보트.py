def solution(people, limit):
    people.sort()
    s, e = 0, len(people)-1
    cnt = 0
    
    while s < e:
        if people[s] + people[e] <= limit:
            s+=1
        if s != e:
            e-=1
    return len(people) - e