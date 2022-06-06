import sys

if __name__ == "__main__":
    N = int(sys.stdin.readline().rstrip())

    for i in range(1,N+1):
        if i**2 + i + 1 == N:
            print(i)
            break