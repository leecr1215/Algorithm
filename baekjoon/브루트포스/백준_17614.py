import sys

if __name__ == "__main__":
    N = int(sys.stdin.readline().rstrip())
    result = 0

    for i in range(N):
        if "3" in str(i) or  "6" in str(i) or  "9" in str(i):
            result += 1
    
    print(result)
