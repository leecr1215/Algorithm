import sys

if __name__ == '__main__':
    '''
    1 2 3
    2 4 6
    3 6 9
    => 1 2 3 2 4 6 3 6 9
    -> 1 2 2 3 3 4 6 6 9
    '''
    N = int(sys.stdin.readline().rstrip())
    K = int(sys.stdin.readline().rstrip())
    arr = []

    for i in range(1,N+1):
        for j in range(1,N+1):
            arr.append(i*j)
    
    arr.sort()

   
    print(arr[K])



