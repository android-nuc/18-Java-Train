package week02.arraylist;


import java.util.*;

public class ArrayListDemo {
    public static void main(String[] args) {
        ArrayList<Person> personList = new ArrayList();
        //向上转型
        List<Person> addtionList = new ArrayList<>();
        addtionList.add(new Person("mazha", 23));
        addtionList.add(new Person("xiangyi", 22));


        Person wanghao = new Person("wanghao", 20);
        //add方法
        //看一下源码
        personList.add(new Person("baoqianyue", 20));
        personList.add(new Person("王天锐", 21));
        personList.add(new Person("zhaolizhi", 21));
        personList.add(new Person("tanzhuo", 22));
        personList.add(wanghao);

        //add添加到指定索引位置上
        personList.add(2, new Person("lihao", 20));

        //remove方法
        personList.remove(wanghao);
        personList.remove(0);

        //addAll方法
        personList.addAll(addtionList);
        System.out.println("---------------------------------");

        for (int i = 0; i < personList.size(); i++) {
            System.out.println(personList.get(i));
        }

        //包括头不包括尾
        List<Person> subList = personList.subList(0, 3);

        Collections.sort(personList);
        Collections.sort(personList, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getAge() - o2.getAge();
            }
        });
      /*  personList.sort(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return Integer.compare(o1.getAge(), o2.getAge());
            }
        });*/

       /* System.out.println("---------------------------------");
        for (Person p :
                subList) {
            System.out.println(p);
        }*/

        //clear方法
//        personList.clear();

        //遍历List
        System.out.println("---------------------------------");
        for (int i = 0; i < personList.size(); i++) {
            System.out.println(personList.get(i));
        }


       /* Iterator<Person> iterator = personList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        for (Person p :
                personList) {
            System.out.println(p);
        }*/


    }
}
