import sys

if __name__ == '__main__':
    pips = list(map(int, sys.stdin.readline().rstrip().split(" ")))

    money = max(pips) * 100

    # 3개가 다 같은지
    if pips[0] == pips[1] and pips[1] == pips[2]:
        money = 10000  + (pips[0]) * 1000
    elif pips[0] == pips[1]:
        money = 1000 + (pips[0]) * 100
    elif pips[0] == pips[2]:
        money = 1000 + (pips[0]) * 100
    elif pips[1] == pips[2]:
        money = 1000 + (pips[1]) * 100

    print(money)