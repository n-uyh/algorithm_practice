import heapq

n = int(input())
x = [int(input()) for _ in range(n)]
pq = []

for i,el in enumerate(x):
    if el > 0:
        heapq.heappush(pq, el)
    else:
        if (i == 0):
            print(0)
        else:
            min = heapq.heappop(pq)
            print(min)

