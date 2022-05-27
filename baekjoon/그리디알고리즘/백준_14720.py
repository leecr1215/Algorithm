import sys

if __name__ == '__main__':
    N = int(sys.stdin.readline().rstrip())

    milks = list(map(int, sys.stdin.readline().rstrip().split(" ")))
    index = 0
    candrink = [0,1,2]

    result = 0

    for milk in milks:
        if milk == candrink[index]:
            result += 1
            index += 1
            if index == 3:
                index -= 3
        
    
    print(result)

