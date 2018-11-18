package week01.classandobject;


/**
 * 演示this关键字
 */
public class ThisDemo {

    private String name;

    private int age;


    public ThisDemo(String name, int age) {
        name = name;
        this.age = age;
        this.show();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        //这里使用this会将局部变量和成员变量区分开
//        name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void show() {
        //这里访问的其实是当前对象的属性
        //在每个属性前都默认有一个this
        System.out.println("姓名是: " + this.name + " 年龄是: " + age);
    }

    public static void main(String[] args) {
        new ThisDemo("b", 20);
    }
}
