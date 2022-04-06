import sys
if __name__ == '__main__':
    n,m = map(int, sys.stdin.readline().rstrip().split(" "))
    arr = []
    for i in range(n):
        arr.append(list(map(int, sys.stdin.readline().rstrip().split(" "))))
    L1, R1 = map(int, sys.stdin.readline().rstrip().split(" "))    
    L2, R2 = map(int, sys.stdin.readline().rstrip().split(" "))

    # 첫번째 공격
    for i in range(L1-1, R1):
        for j in range(m):
            if list[i][j] == 1:
                list[i][j] = 0
                continue