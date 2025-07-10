n = int(input())
arr = list(map(int, input().split()))
new_arr = [i ** 2 for i in arr]

print(*new_arr)