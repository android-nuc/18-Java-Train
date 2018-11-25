package week02.arraylist;


public class Person implements Comparable {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }


    @Override
    public int hashCode() {
        return super.hashCode();
    }

    /**
     * 返回值大于0表示this>o
     * 返回值小于零表示this < o
     *
     * @param o
     * @return
     */
    @Override
    public int compareTo(Object o) {
        Person other = (Person) o;
        if (this.getAge() > other.getAge())
            return 1;
        else
            return -1;
    }
}
