package week01.extendandinterface;

public abstract class Person extends JDBCObject{
    private String name;
    private int sex;

    /**
     * 声明构造函数,在创建子类时需要调用
     */
    public Person() {
    }

    public Person(String name, int sex) {
        this.name = name;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    /**
     * 抽象方法
     * @return 对Person的描述
     */
    public abstract String getDescription();
}
