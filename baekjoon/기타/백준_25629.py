import sys

if __name__ == '__main__':
    # N 보고 필요한 홀수 개수랑 짝수 개수 확인
    # N // 2 값이 짝수 개수
    N = int(sys.stdin.readline().rstrip())
    arr = list(map(int, sys.stdin.readline().rstrip().split(" ")))
    evenNum = N // 2
    oddNum = N - evenNum

    countEven = 0

    for i in range(N):
        if arr[i] % 2 == 0:
            countEven += 1

    if countEven==evenNum:
        print(1)
    else:
        print(0)

