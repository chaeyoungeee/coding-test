def solution(citations):
    citations.sort(reverse=True)
    for i, v in enumerate(citations):
        if i >= v: return i
    return 0 if citations[-1] < len(citations) else len(citations)