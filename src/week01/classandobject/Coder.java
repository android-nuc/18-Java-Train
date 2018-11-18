package week01.classandobject;

/**
 * 演示private和protected权限修饰符
 * 匿名对象的使用
 */
public class Coder extends Person {
    /**
     * 构造方法没有返回值
     * 方法名与类名一致
     *
     * @param name1
     * @param age1
     */
    Coder(String name1, int age1) {
        super(name1, age1);
        this.protectedName = name1;
        Person.protectedStaName = name1;
    }

    public Coder() {

    }


    void code() {
        System.out.println("I am coding!");
    }

    static void show(Coder coder) {
        coder.name = "baoqianyue";
        coder.age = 20;
    }

    public static void main(String[] args) {
        Book book = new Book();
        //在其他类中可以直接访问到实体类中public修饰的属性
        book.publicName = "name";
        //无法访问private修饰的，只能通过访问它们的getter和setter方法
        String name = book.getName();
        book.setName(name);

        //使用匿名对象直接调用成员方法
        new Coder().code();

        //将匿名对象作为参数传递
        //这样在函数中会在栈上创建一个局部引用,并指向该匿名对象
        //这时再去访问该对象的属性就有意义了
        //当函数执行完成,局部变量被释放,该匿名对象失去引用指向,很快被当作垃圾回收
        show(new Coder());

    }

}
