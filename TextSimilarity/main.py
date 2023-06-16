import text
import choice
import numpy as np
list1 = [1, 0, 1, 0, 1, "我喜欢打英雄联盟"]
list2 = [0, 1, 0, 1, 0, "无"]

vec1 = np.asarray(list1[0:5])
vec2 = np.asarray(list2[0:5])
text1 = list1[-1]
text2 = list2[-1]

result = 0.8 * choice.getCosineDistance(vec1, vec2) + 0.2 * text.getScore(text1, text2)
print(choice.getCosineDistance(vec1, vec2))
print(result)

