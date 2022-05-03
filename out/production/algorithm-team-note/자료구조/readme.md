## list,queue 삭제 관련

* list의 경우

```
List<Integer> list = new ArrayList<>();

list.add(3)
list.add(1)
list.add(2)
list.add(4)


list.remove() 의 경우

Integer.valueOf(3);
을 넘기면 값3에 해당하는 첫번째 index값의 3이 사라지고,
이 때, 해당 값이 없어도 null pointer exception이 뜨지 않는다.

그냥 숫자 3을 넘기면 해당 index 3번째 값이 사라진다.
```

* queue의 경우

```
queue.remove()

remove의 경우 값이 없어도 null pointer exception을 내지 않는다.
```