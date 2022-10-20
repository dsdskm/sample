import numpy as np
x = np.arange(4)
print(x)
x += 5
print(x)
x -= 5
print(x)
x *= 5
print(x)
print(x/5)

# 다차원
x = np.arange(4).reshape((2, 2))
y = np.random.randint(10, size=(2, 2))
print(x+y)
print(x-y)
