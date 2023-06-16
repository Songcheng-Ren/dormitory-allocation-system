import numpy as np

def getEuclideanDistance(a, b):
    return np.linalg.norm(a - b)

def getCosineDistance(a, b):
    num = float(np.dot(a, b))
    denom = np.linalg.norm(a) * np.linalg.norm(b)
    return (num / denom) if denom != 0 else 0