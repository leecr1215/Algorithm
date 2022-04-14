import sys
if __name__ == '__main__':
    N=int(sys.stdin.readline().rstrip())
    a = list(map(int, sys.stdin.readline().rstrip().split(" ")))
    answer = 0

    if N==1:
        print(1)
    else:
        answer = min(a) * N
        if min(a) != max(a):
            answer += N-1
        print(answer)
       

