import sys

if __name__ == '__main__':
    N = int(sys.stdin.readline().rstrip())
    A, B = map(int, sys.stdin.readline().rstrip().split())

    chicken = (A//2) + (B)

    if chicken <= N:
        print(chicken)
    else:
        print(N)