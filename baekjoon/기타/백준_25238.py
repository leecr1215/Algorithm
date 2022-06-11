import sys

if __name__ == "__main__":
    a, b = map(int, sys.stdin.readline().rstrip().split(" "))
    percent = a * b / 100
    result = a - percent

    if result >= 100:
        print(0)
    else:
        print(1)