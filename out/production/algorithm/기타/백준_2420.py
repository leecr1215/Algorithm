import sys

if __name__ == "__main__":
    N, M = map(int, sys.stdin.readline().rstrip().split(" "))

    print(abs(N-M))