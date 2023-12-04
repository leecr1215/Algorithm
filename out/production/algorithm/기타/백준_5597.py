import sys

if __name__ == "__main__":
    arr = [0] * 31

    for i in range(1,29):
        temp = int(sys.stdin.readline().rstrip())
        arr[temp] = 1
    
    for i in range(1,31):
        if arr[i] == 0:
            print(i)       
