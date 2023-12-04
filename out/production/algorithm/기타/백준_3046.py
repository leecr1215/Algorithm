import sys

if __name__ == "__main__":
    R1, S = map(int, sys.stdin.readline().rstrip().split(" "))
    R2 = S * 2 - R1
    print(R2)
