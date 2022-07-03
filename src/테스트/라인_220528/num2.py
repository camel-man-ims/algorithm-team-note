import heapq
def solution(n, times): #줄의 개수 #줄을 x개 잘랐을 때 소요되는 시간
    def bfs():
        q=[]
        heapq.heappush(q, [0, 1]) #걸린시간, 최종 개수
        while True:
            dur, total=heapq.heappop(q)

            for i in range(len(times)):
                if total-(i+1)>=0:
                    time=times[i]
                    ndur=dur+time
                    ntotal=(i+1)*2+(total-(i+1))
                    if ntotal==n:
                        return ndur
                    heapq.heappush(q, [ndur, ntotal])

        return -1
    return bfs()