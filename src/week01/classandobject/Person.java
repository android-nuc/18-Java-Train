package week01.classandobject;

public class Person {

    String name;
    int age;

    protected static String protectedStaName;
    public static String publicStaName;
    private String privateName;
    protected String protectedName;

    /**
     * 构造方法没有返回值
     * 方法名与类名一致
     * <p>
     * 为了让不同包下的子类能够顺利调用到父类的构造方法
     * 父类的构造方法必须设置为public或者protected的
     *
     * @param name1
     * @param age1
     */
    protected Person(String name1, int age1) {
        name = name1;
        age = age1;
    }

    Person() {
    }

    void code() {
        System.out.println("coding");
    }

    void study() {
        System.out.println("studying");
    }

    /**
     * 演示protected修饰符，在同包下和不同包下其他类的访问情况
     */
    protected static void protectedFun() {
        System.out.println();
    }

    /**
     * 演示public修饰符，在同包下和不同包下的其他类的访问情况
     * 与protected进行对比
     */
    public static void publicFun() {
        System.out.println();
    }


    public static void main(String[] args) {
        //声明对象，同时初始化
        Person person = new Person("bao", 20);
        //使用对象访问对象自身的属性
        String name = person.name;
        int age = person.age;
        System.out.println("我叫" + name + "，今年" + age + "岁了");
        //调用对象的方法
        person.code();
        person.study();
    }

}
