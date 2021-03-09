#!/bin/python3

import math
import os
import random
import re
import sys


def dynamicArray(n, queries):
    lastanswer=0
    a=[[]for _ in range(n)]
    op=[]
    for i in queries:
        indx=((i[1] ^ lastanswer)%n)
        if i[0]==1:
            a[indx].append(i[2])
        elif i[0]==2:
            pos=(i[2]%len(a[indx]))
            lastanswer=a[indx][pos]
            op.append(lastanswer)
    return op
            

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    first_multiple_input = input().rstrip().split()

    n = int(first_multiple_input[0])

    q = int(first_multiple_input[1])

    queries = []

    for _ in range(q):
        queries.append(list(map(int, input().rstrip().split())))

    result = dynamicArray(n, queries)

    fptr.write('\n'.join(map(str, result)))
    fptr.write('\n')

    fptr.close()
