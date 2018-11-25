package week02.callback;

public abstract class Person extends JDBCObject {
    private String name;
    private int sex;

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
     * 用于描述一个人
     *
     * @return 返回对这个人的描述信息
     */
    public abstract String getDescription();


}

