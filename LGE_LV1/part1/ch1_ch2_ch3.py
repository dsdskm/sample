import numpy as np
# basic
arr = np.array([1, 2, 3, 4, 5])
print(arr)
arr = np.zeros(10, dtype=int)
print(arr)
arr = np.ones((3, 5), dtype=float)
print(arr)
arr = np.arange(0, 20, 2)
print(arr)
arr = np.linspace(0, 1, 5)
print(arr)

# random
arr = np.random.random((2, 2))
print(arr)
arr = np.random.normal(0, 1, (2, 2))
print(arr)
arr = np.random.randint(0, 10, (2, 2))
print(arr)

x2 = np.random.randint(10, size=(3, 4))
print(x2)
print(x2.ndim)  # 차원
print(x2.shape)  # 모양
print(x2.size)  # 크기
print(x2.dtype)  # 타입

# reshape
x = np.arange(8)
x2 = x.reshape(2, 4)
print(x)
print(x2)

# concatenate
x = np.array([0, 1, 2])
y = np.array([3, 4, 5])
z = np.concatenate([x, y])
print(x, y, z)
matrix = np.arange(4).reshape(2, 2)
matrix2 = np.concatenate([matrix, matrix], axis=0)
print(matrix, matrix2)

# split
matrix = np.arange(16).reshape(4, 4)
upper, lower = np.split(matrix, [3], axis=0)
print(matrix, upper, lower)
