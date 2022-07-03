import math

def solution(fuel, powers, distances): #총 연료량, 각 우주선의 로켓 힘, 각 우주선의 목적지 행성까지의 거리
    #연료 공평하게 나누기
    n=len(powers)
    div=fuel//n
    gas=[div]*(n-1)+[fuel-div*(n-1)]
    time=[]

    def sec(p, d, g): #로켓 힘, 행성까지 거리, 연료량
        #삼각형
        dist=p*g*g/2

        if dist>d: ##이미 도착했을때 #d*2=p*?*?
            return math.sqrt(d*2/p)

        elif dist==d:
            return g

        else: ##아직 도착하지 않았을 때 #사각형
            remain_dist=d-dist
            final_speed=p*g
            return g + remain_dist/final_speed  #삼각형 시간 + 사각형 시간

    #초기값
    for i in range(n):
        power=powers[i]
        dist=distances[i]
        g=gas[i]
        time.append(sec(power, dist, g))

    #본게임 #가장 시간 오래 걸리는거 연료 늘리고, 가장 시간 적게 걸리는 거 연료 줄이고 하며 조정
    while True:
        max_time=max(time)
        min_time=min(time)
        max_time_idx=time.index(max_time)
        min_time_idx=time.index(min_time)

        if gas[min_time_idx]-1==0:
            break

        n_max_time=sec(powers[max_time_idx], distances[max_time_idx], gas[max_time_idx]+1)
        n_min_time=sec(powers[min_time_idx], distances[min_time_idx], gas[min_time_idx]-1)

        if n_max_time<max_time and n_min_time<max_time:
            gas[max_time_idx]+=1
            gas[min_time_idx]-=1
            time[max_time_idx]=n_max_time
            time[min_time_idx]=n_min_time
        else:
            break

    return math.ceil(max(time)) #모든 우주선이 목적지에 도착하는 정수 초의 최솟값