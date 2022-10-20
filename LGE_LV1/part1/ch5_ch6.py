import numpy as np
# broadcasting
print(np.arange(3).reshape((3, 1))+np.arange(3))

# 집계함수
x = np.arange(8).reshape((2, 4))
print(np.sum(x))
print(np.min(x))
print(np.max(x))
print(np.mean(x))

# 마스킹
x = np.arange(5)
print(x < 3)
print(x > 5)
print(x[x < 3])
