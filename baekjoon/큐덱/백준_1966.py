from collections import deque
import sys

if __name__ == '__main__':
    T = int(sys.stdin.readline().rstrip())

    for i in range(T):
        N,M = map(int, sys.stdin.readline().rstrip().split(" "))
        arr = deque(map(int, sys.stdin.readline().rstrip().split(" ")))
        sequence = deque([i for i in range(N)])

        maxi = max(arr)
        count = 0
        
        while True:
            if arr[0] == maxi:
                print("내가 최대임")
                count += 1
                arr.popleft() #인쇄
                maxi = max(arr)
                if sequence.popleft() == M:
                    break
            else:
                arr.append(arr.popleft())
                sequence.append(sequence.popleft())
        
        print(count)
        
        

