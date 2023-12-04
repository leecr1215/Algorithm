import sys
if __name__ == '__main__':
    A, B = map(int, sys.stdin.readline().rstrip().split())   
    maxBun = A // 2
    
    if maxBun < B:
        print(maxBun)
    else:
        print(B)
