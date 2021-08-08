
if __name__ =='__main__':
    N = int(input())
    rank = [1] * N
    wh = []

    for i in range(N):
        weight, height = map(int, input().split())
        wh.append([weight, height])

    # 하나씩 돌면서 자신보다 덩치가 큰 사람 있으면 1 더하기
    for i in range(N):
        w1, h1 = wh[i]
        for j in range(N):
            w2 , h2 = wh[j]
            if w1 < w2 and h1 < h2:
                rank[i] = rank[i] + 1


    for i in range(N):
        if i==N:
            print(rank[i], end='')
        else:
            print(rank[i], end=' ')

