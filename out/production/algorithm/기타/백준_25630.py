import sys

if __name__ == '__main__':
    N = int(sys.stdin.readline().rstrip())
    sottuk = sys.stdin.readline().rstrip()
    count = 0
    # N //2만 확인 
    i = 0
    while i < (N//2):
        front = sottuk[i]
        back = sottuk[-(i+1)]
        i += 1
        if front!=back:
            count += 1

    print(count)