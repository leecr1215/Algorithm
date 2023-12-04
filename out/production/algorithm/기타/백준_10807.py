import sys

if __name__ == "__main__":
    N = int(sys.stdin.readline().rstrip())

    arr = list(map(int, sys.stdin.readline().rstrip().split(" ")))
    target = int(sys.stdin.readline().rstrip())

    count = 0

    for i in arr:
        if i == target:
            count += 1

    print(count)
