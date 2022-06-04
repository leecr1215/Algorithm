import sys

if __name__ == "__main__":
    N = int(sys.stdin.readline().rstrip())
    result = 0

    for i in range(1,N+1):
        string = str(i)
        result += string.count("3")
        result += string.count("6")
        result += string.count("9")
    
    print(result)
