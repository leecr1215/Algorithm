import sys

if __name__ == "__main__":
    T = int(sys.stdin.readline().rstrip())
    
    for i in range(T):
        result = []
        C = int(sys.stdin.readline().rstrip())
        # quarter
        result.append(C // 25)
        C = C%25
        #dime
        result.append(C//10)
        C = C%10
        # nickel
        result.append(C//5)
        C = C%5
        # penny
        result.append(C//1)
        C = C%1
        print(result[0], result[1], result[2], result[3])