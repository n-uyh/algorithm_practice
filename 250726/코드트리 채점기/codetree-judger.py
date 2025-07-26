'''
0. 준비
- 100 N u0
n개의 채점기
    번호 : 1~n
    채점중 task

0초 : p = 1, u = u0인 요청 들어옴

url 
    - 초기 url u0
    - 도메인/문제/ID

채점 task
    - in 채점대기큐
    - 우선순위, url



1. 채점 요청
    - 200 t p u
    - 요청 대기큐에 insert
    - 이미 url 있으면 skip

2. 채점 시도
    - 300 t
    - 채점 불가 조건
        - 도메인이 이미 채점중 도메인 중 하나인 경우
        - 도메인 정확히 일치하는 도메인에 대한 채점시간 start, start+gap, 현재 시간 t < start + 3*gap 인 경우
    - 즉시 채점 가능한 경우
        - p가 작을 수록, 대기 큐에 들어온 시간이 더 빠를 수록
    - 채점 가능 task 있다면 
        - 쉬고있는 채점기 중 번호가 가장 작은 채점기가 채점 시작
        - 쉬고있는 채점기가 없으면 넘어감

3. 채점 종료
    - 400 t J_id
    t초에 J_id 채점기 종료

4. 대기 큐 조회
    - 500 t
    현재 대기큐 채점 task 수 출력
'''
class Marker:
    def __init__(self, no):
        self.no = no
        self.task = None

class Task:
    def __init__(self, p, u):
        self.p = p
        self.u = u

# 채점 요청
def insert_task(t, p, u):
    pass

# 채점 시도
def do_task(t):
    pass

def end_task(t, j_id):
    pass

def check_task():
    print(len(tasks))

Q = int(input()) - 1
tasks = []

# 채점기 준비 무조건
query, N, u_0 = input().split()
for i in range(int(N)):
    markers.append(Marker(i+1))

tasks.append(Task(1,u_0))

# 질의
for t in range(1, 1+Q):
    q = input().split()
    if q[0] == '200':
        insert_task(t, q[1], q[2])
    elif q[0] == '300':
        do_task(t)
    elif q[0] == '400':
        end_task(t, q[1])
    else:
        check_task()




