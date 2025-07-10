
class Person:
    def __init__(self, name, street, region):
        self.name = name
        self.street = street
        self.region = region
    
    def __str__(self):
        return f'name {self.name}\naddr {self.street}\ncity {self.region}'

n = int(input())

people = []

for _ in range(n):
    n_i, s_i, r_i = input().split()
    people.append(Person(n_i, s_i, r_i))

people = sorted(people, key=lambda p: p.name)
print(people.pop())



