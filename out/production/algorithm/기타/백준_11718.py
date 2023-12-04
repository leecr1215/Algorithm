import sys

if __name__ == "__main__":
    while True:
        try:
            print(sys.stdin.readline().rstrip())
        except EOFError:
            break

    