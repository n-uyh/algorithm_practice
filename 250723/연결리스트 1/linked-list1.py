S_init = input()
N = int(input())

class S_Node:
    def __init__(self, data):
        self.data = data
        self.prev = None
        self.next = None

def printCur(cur):
    null = '(Null)'
    if cur.prev is None:
        print(null,end=' ')
    else:
        print(cur.prev.data, end=' ')
    
    print(cur.data,end=' ')

    if cur.next is None:
        print(null)
    else:
        print(cur.next.data)

def insert_front(cur,s):
    node = S_Node(s)
    
    node.next = cur
    node.prev = cur.prev

    if node.prev is not None:
        node.prev.next = node
    if node.next is not None:
        node.next.prev = node
    
    return cur

def insert_next(cur,s):
    node = S_Node(s)

    node.prev = cur
    node.next = cur.next

    if node.prev is not None:
        node.prev.next = node
    if node.next is not None:
        node.next.prev = node
    
    return cur

def cur_prev(cur):

    if cur.prev:
        cur = cur.prev

    return cur

def cur_next(cur):
    if cur.next:
        cur = cur.next
    return cur

def main():
    # 초기 단일노드 cur
    cur = S_Node(S_init)
    # N번의 연산
    for i in range(N):
        line = input().split()
        cmd = int(line[0])

        if cmd == 1:
            cur = insert_front(cur,line[1])
        elif cmd == 2:
            cur = insert_next(cur,line[1])
        elif cmd == 3:
            cur = cur_prev(cur)
        else:
            cur = cur_next(cur)

        printCur(cur)

main()