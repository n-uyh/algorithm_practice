import heapq

n = int(input())
x = [int(input()) for _ in range(n)]
pq = []

for el in x:
    if el > 0:
        heapq.heappush(pq, el)
    else:
        try:
            print(heapq.heappop(pq))
        except IndexError:
            print(0)

