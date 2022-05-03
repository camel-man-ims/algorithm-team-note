package 테스트.십일번가_220503;

import java.util.*;

public class Number3 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String solution1 = solution.solution("photo.jpg, Warsaw, 2013-09-05 14:08:15\njohn.png, London, 2015-06-20 15:13:22\nmyFriends.png, Warsaw, 2013-09-05 14:07:13\nEiffel.jpg, Paris, 2015-07-23 08:03:02\npisatower.jpg, Paris, 2015-07-22 23:59:59\nBOB.jpg, London, 2015-08-05 00:02:03\nnotredame.png, Paris, 2015-09-01 12:00:00\nme.jpg, Warsaw, 2013-09-06 15:40:22\na.png, Warsaw, 2016-02-13 13:33:50\nb.jpg, Warsaw, 2016-01-02 15:12:22\nc.jpg, Warsaw, 2016-01-02 14:34:30\nd.jpg, Warsaw, 2016-01-02 15:15:01\\ne.png, Warsaw, 2016-01-02 09:49:09\nf.png, Warsaw, 2016-01-02 10:55:32\ng.jpg, Warsaw, 2016-02-29 22:13:11");
        System.out.println(solution1);
    }
    static class Solution {
        static class Res{
            String name;
            int index;

            public Res(String name, int index) {
                this.name = name;
                this.index = index;
            }

            @Override
            public String toString() {
                return "Res{" +
                        "name='" + name + '\'' +
                        ", index=" + index +
                        '}';
            }
        }

        static class Info implements Comparable<Info>{
            String extension;
            String city;
            Time time;
            int pointer;

            @Override
            public String toString() {
                return "Info{" +
                        "extension='" + extension + '\'' +
                        ", city='" + city + '\'' +
                        ", time=" + time +
                        ", pointer=" + pointer +
                        '}';
            }

            public Info(String extension, String city, Time time, int pointer) {
                this.extension = extension;
                this.city = city;
                this.time = time;
                this.pointer = pointer;
            }

            @Override
            public int compareTo(Info o) {
                if(this.time.year != o.time.year){
                    return Integer.compare(this.time.year,o.time.year);
                }else{
                    if(this.time.month != o.time.month){
                        return Integer.compare(this.time.month,o.time.month);
                    }else{
                        if(this.time.day != o.time.day){
                            return Integer.compare(this.time.day,o.time.day);
                        }else{
                            if(this.time.hour != o.time.hour){
                                return Integer.compare(this.time.hour,o.time.hour);
                            }else{
                                if(this.time.min != o.time.min){
                                    return Integer.compare(this.time.min,o.time.min);
                                }else{
                                    return Integer.compare(this.time.sec,o.time.sec);
                                }
                            }
                        }
                    }
                }
            }
        }
        static class Time{
            int year;
            int month;
            int day;
            int hour;
            int min;
            int sec;

            @Override
            public String toString() {
                return "Time{" +
                        "year=" + year +
                        ", month=" + month +
                        ", day=" + day +
                        ", hour=" + hour +
                        ", min=" + min +
                        ", sec=" + sec +
                        '}';
            }

            public Time(int year, int month, int day, int hour, int min, int sec) {
                this.year = year;
                this.month = month;
                this.day = day;
                this.hour = hour;
                this.min = min;
                this.sec = sec;
            }
        }

        static Map<String, PriorityQueue<Info>> map;

        public String solution(String S) {
            map = new HashMap<>();

            String[] firstSplit = S.split("\\\\n");
            int pointer = 0;
            for(String fir : firstSplit){
                System.out.println(fir);
                // [photo.jpg, Warsaw, 2013-09-05 14:08:15]
                String[] secondSplit = fir.split(", ");

                // [photo, jpg]
                String[] photoSplit = secondSplit[0].split("\\.");

                // [2013-09-05, 14:08:15]
                String[] timeSplit1 = secondSplit[2].split(" ");

                String[] years = timeSplit1[0].split("-");
                int year = Integer.parseInt(years[0]);
                int month = Integer.parseInt(years[1]);
                int day = Integer.parseInt(years[2]);

                // [14, 08, 15]
                String[] timeSplit2 = timeSplit1[1].split(":");

                int hour = Integer.parseInt(timeSplit2[0]);
                int min = Integer.parseInt(timeSplit2[1]);
                int sec = Integer.parseInt(timeSplit2[2]);

                Time time = new Time(year,month,day,hour,min,sec);

                Info info = new Info(photoSplit[1],secondSplit[1],time,pointer);

                String cityName = secondSplit[1];

                if(map.containsKey(cityName)){
                    map.get(cityName).add(info);
                }else{
                    map.put(cityName,new PriorityQueue<>());
                    map.get(cityName).add(info);
                }
                pointer++;
            }

            Set<String> strings = map.keySet();

            Comparator<Res> comp = Comparator.comparingInt(o -> o.index);

            PriorityQueue<Res> pq = new PriorityQueue<>(comp);

            for(String s : strings){
                PriorityQueue<Info> infos = map.get(s);

                Res[] res = new Res[infos.size()];

                int cn = 1;
                int size = infos.size();
                while(!infos.isEmpty()){
                    Info poll = infos.poll();
                    StringBuilder add = new StringBuilder();
                    add.append(poll.city);
                    if(size >= 10 && cn < 10){
                        add.append("0");
                    }
                    add.append(cn);
                    add.append(".");
                    add.append(poll.extension);
                    Res re = new Res(add.toString(),poll.pointer);
                    res[cn-1] = re;
                    cn++;
                }
                for(int i=0;i<size;i++){
                    pq.offer(res[i]);
                }
            }
            StringBuilder sb = new StringBuilder();

            while(!pq.isEmpty()){
                Res poll = pq.poll();
                sb.append(poll.name).append("\n");
            }
            sb.setLength(sb.length()-1);
            return sb.toString();
        }
    }
}
