n = int(input())
words = [input() for _ in range(n)]

counts = {}
max_count = 0

for w in words:
    if w in counts:
        counts[w] += 1
    else:
        counts[w] = 1
    
    if counts[w] > max_count:
        max_count = counts[w]

print(max_count)