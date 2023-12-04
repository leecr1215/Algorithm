import sys

if __name__ == "__main__":
    N  = int(sys.stdin.readline().rstrip())

    for i in range(N):
        st = sys.stdin.readline().rstrip()
        print(st[0]+st[-1])