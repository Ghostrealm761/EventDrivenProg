# HackerRank Practice 2

n = int(input("Enter a number"))

if n % 2 != 0:
    print("Weird")
elif n % 2 == 0 and n >= 2 and n <= 5:
    print("Not Weird")
elif n % 2 == 0 and n >= 6 and n <= 20:
    print("Weird")
elif n% 2 == 0 and n > 20:
    print("Not Weird")
    
# HackerRank Practice 3
a = int(input())
b = int(input())
    
c = a+b
d = a-b
e = a*b
    
print(c)
print(d)
print(e)

# 
a = int(input())
b = int(input())
    
c = a//b
d = a/b
    
print(c)
print(d)

# HackerRank Practice 5
n = int(input())
    
for i in range(n):
    if n >= 1 and n <= 20:
        print(i**2)



