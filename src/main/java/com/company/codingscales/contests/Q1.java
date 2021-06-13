package com.company.codingscales.contests;

import java.util.ArrayList;

//public class Q1 {
//    public static boolean containsPattern(int[] arr, int m, int limit) {
//        int n = arr.length;
//        for(int i = 0; i < n; i++){
//            int count = 0;
//            int endPos = Math.min(i + m, n);
//            ArrayList<Integer> al = new ArrayList<>();
//            System.out.println(" Pattern is");
//            for(int k = i; k < endPos; k++){
//                System.out.print(arr[k] + " , ");
//                al.add(arr[k]);
//            }
//            System.out.println();
//
//            int j = i + m;
//            while (j < n) {
//                boolean ok = true;
//                for(int k = 0; k < al.size() && j + k < n; k++){
//                    if (arr[j + k] != al.get(k)) {
//                        ok = false;
//                        break;
//                    }
//                }
//                if (!ok)
//                    break;
//                count++;
//                j += m;
//            }
//            if (count >= limit - 1) {
//                System.out.println(count + " - " + (limit - 1));
//                return true;
//            }
//        }
//        return false;
//    }
//
//    public static void main(String[] args) {
//        System.out.println(containsPattern(new int[] {2, 2, 2, 2}, 2, 3)); // false
//        System.out.println(containsPattern(new int[] {2,2,1,2,2,1,1,1,2,1}, 2, 2)); // false
//    }
//}

import java.util.*;

public class Q1 {

    public static void main(String[] argh) {

        String s = "photo.jpg, Warsaw, 2013-09-05 14:08:15\n"
                   + "john.png, London, 2015-06-20 15:13:22\n"
                   + "myFriends.png, Warsaw, 2013-09-05 14:07:13\n"
                   + "Eiffel.jpg, Paris, 2015-07-23 08:03:02\n"
                   + "pisatower.jpg, Paris, 2015-07-22 23:59:59\n"
                   + "BOB.jpg, London, 2015-08-05 00:02:03\n"
                   + "notredame.png, Paris, 2015-09-01 12:00:00\n"
                   + "me.jpg, Warsaw, 2013-09-06 15:40:22\n"
                   + "a.png, Warsaw, 2016-02-13 13:33:50\n"
                   + "b.jpg, Warsaw, 2016-01-02 15:12:22\n"
                   + "c.jpg, Warsaw, 2016-01-02 14:34:30\n"
                   + "d.jpg, Warsaw, 2016-01-02 15:15:01\n"
                   + "e.jpg, Warsaw, 2016-01-02 09:49:09\n"
                   + "f.jpg, Warsaw, 2016-01-02 10:55:32\n"
                   + "g.jpg, Warsaw, 2016-02-29 22:13:11";
        System.out.println(solution(s));
    }

    public static String solution(String s) {

        List<Photo> photos = new ArrayList<Photo>();
        Map<String, ArrayList<Photo>> myMap = new HashMap();
        List<String> listOfPhoto = new ArrayList<>();
        String newName = "";

        StringTokenizer st = new StringTokenizer(s, "\n");

        while (st.hasMoreTokens()) {
            listOfPhoto.add(st.nextToken());
        }

        for (String str : listOfPhoto) {
            StringTokenizer coma = new StringTokenizer(str, ",");
            //Eliminate blank spaces
            Photo photo = new Photo(coma.nextToken().replace(" ", ""), coma.nextToken().replace(" ", ""), coma.nextToken().replace(" ", ""));
            photos.add(photo);
        }

        //#######Group picture by city################
        for (Photo pic : photos) {
            String myPlace = pic.getCity();
            if (myMap.get(myPlace) != null) {
                myMap.get(myPlace).add(pic);

            } else {
                ArrayList<Photo> mypics = new ArrayList<>();
                mypics.add(pic);
                myMap.put(myPlace, mypics);
            }
            //#######################################
        }



        for (Photo p : photos) {
            ArrayList<Photo> myLisSort = myMap.get(p.getCity());
            Collections.sort(myLisSort);
            int counter = myLisSort.indexOf(p) + 1;

            newName = newName
                      + p.getCity() + ((returnZeros(String.valueOf(myMap.get(p.getCity()).size()).length()))
                                       + counter).substring(String.valueOf(counter).length())
                      + p.getName().substring(p.getName().indexOf(".")) + "\n";
        }

        return newName;
    }

    public static String returnZeros(int counter) {
        String str = "";

        for (int z = 0; z < counter; z++) {
            str += "0";
        }
        return str;
    }
}

class Photo implements Comparable<Photo>{

    String name;
    String city;
    String time;


    public Photo(String name, String city, String time) {
        this.name = name;
        this.city = city;
        this.time = time;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public int compareTo(Photo o) {
        return this.getTime().compareTo(o.getTime());
    }

}