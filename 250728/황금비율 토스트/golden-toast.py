n, m = map(int, input().split())
breads = input()

commands = []
for _ in range(m):
    cmd = input().split()
    if len(cmd) == 1:
        commands.append((cmd[0],))
    else:
        commands.append((cmd[0], cmd[1]))

# Please write your code here.
class Bread:
    def __init__(self, c):
        self.data = c
        self.prev = None
        self.next = None
    
class BreadList:
    def __init__(self):
        self.END = Bread(-1)
        self.head = self.END
        self.tail = self.END

    def push_front(self, new_data):
        new_bread = Bread(new_data)
        new_bread.next = self.head

        self.head.prev = new_bread
        self.head = new_bread
        new_bread.prev = None


    def push_back(self, new_data):
        if self.begin() == self.end():
            self.push_front(new_data)
        else:
            new_bread = Bread(new_data)
            new_bread.prev = self.tail.prev
            self.tail.prev.next = new_bread
            new_bread.next = self.tail
            self.tail.prev = new_bread

    def remove(self, bread):
        next_bread = bread.next

        if bread == self.begin():
            temp = self.head
            temp.next.prev = None
            self.head = temp.next
            temp.next = None
        else:
            bread.prev.next = bread.next
            bread.next.prev = bread.prev
            bread.prev = None
            bread.next = None

        return next_bread

    def insert(self, now, new_data):
        if now == self.end():
            self.push_back(new_data)
        
        elif now == self.begin():
            self.push_front(new_data)

        else:
            new_bread = Bread(new_data)
            new_bread.prev = now.prev
            new_bread.next = now
            now.prev.next = new_bread
            now.prev = new_bread

    def begin(self):
        return self.head
    
    def end(self):
        return self.tail

def printList():
    b = bread_list.begin()
    while b != bread_list.end():
        print(b.data, end='')
        b = b.next
    print()

bread_list = BreadList()
for b in breads:
    bread_list.push_back(b)

it = bread_list.end()

for cmd in commands:
    if cmd[0] == 'L':
        if it != bread_list.begin():
            it = it.prev
    elif cmd[0] == 'R':
        if it != bread_list.end():
            it = it.next
    elif cmd[0] == 'D':
        if it != bread_list.end():
            it = bread_list.remove(it)
    else:
        bread_list.insert(it, cmd[1])

printList()