N = int(input())
Q = int(input())

n_arr = [None] * (N+1)

class Node:
    def __init__(self, id):
        self.id = id
        self.prev = None
        self.next = None

def removeNode(i):
    node = n_arr[i]
    if node.prev:
        node.prev.next = node.next
        node.prev = None
    if node.next:
        node.next.prev = node.prev
        node.next = None

def insert_front(i, j):
    back = n_arr[i]
    front = n_arr[j]


    if back.prev:
        back.prev.next = front

    front.next = back
    front.prev = back.prev
    back.prev = front
    

def insert_back(i, j):
    front = n_arr[i]
    back = n_arr[j]

    if front.next:
        front.next.prev = back

    back.prev = front
    back.next = front.next
    front.next = back

def prev_next_id(i):
    cur = n_arr[i]

    if cur.prev is None:
        print(0, end=' ')
    else:
        print(cur.prev.id, end=' ')
    
    if cur.next is None:
        print(0)
    else:
        print(cur.next.id)

def next_id(i):
    cur = n_arr[i]
    if cur.next:
        print(cur.next.id, end=' ')
    else:
        print(0, end=' ')
        

# 노드 초기화
for i in range(N+1):
    n_arr[i] = Node(i)

# 질의
for _ in range(Q):
    q = list(map(int, input().split()))
    if q[0] == 1:
        removeNode(q[1])
    elif q[0] == 2:
        insert_front(q[1], q[2])
    elif q[0] == 3:
        insert_back(q[1], q[2])
    else:
        prev_next_id(q[1])


for i in range(1,N+1):
    next_id(i)