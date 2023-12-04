import sys

if __name__ == '__main__':
    N = int(sys.stdin.readline().rstrip())

    x_coordinates = []
    y_coordinates = []

    for i in range(N):
        x,y = map(int, sys.stdin.readline().rstrip().split(","))
        x_coordinates.append(x)
        y_coordinates.append(y)
    
    print(min(x_coordinates)-1,min(y_coordinates)-1, sep=",")
    print(max(x_coordinates)+1,max(y_coordinates)+1, sep=",")
