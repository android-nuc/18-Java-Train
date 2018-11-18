package week01.extendandinterface;

public class Manager extends Employee {
    private int bonus;

    public Manager() {
    }

    public Manager(String name, int sex, int salary, int bonus) {
        //子类隐式地持有一个父类的对象
        super(name, sex, salary); //调用父类Employee中 含有name,sex,salary的构造器
        //Q:为什么这样写呢
        //A:因为父类的name,sex和salary成员变量是private,子类无法访问
        //super.name = name; //报错

        //如果没有super(xx),就会调用父类的默认构造器
        this.bonus = (int) (bonus * Math.random());
    }

    public Manager(String name, int sex, int salary) {
        super(name, sex, salary);
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    /**
     * 同名方法重载
     *
     * @param bonus  浮动奖金
     * @param pyDeal 写py thon代码的奖金
     */
    public void setBouns(int bonus, int pyDeal) {
        this.bonus = bonus + pyDeal;
    }

    /**
     * 更新获取薪水的方法: 底薪+浮动奖金
     * 重写父类方法是一种多态现象.父类对象会调用父类的方法,子类对象会调用子类的方法
     *
     * @return
     */
    @Override
    public final int getSalary() {
        //先调用父类的getSalary()获取底薪
        int baseSalary = super.getSalary(); //注意要有super才能指定父类对象,否则会无限地调用自身
        return baseSalary + bonus;
    }

    @Override
    public int compareTo(Employee o) {
        return Integer.compare(getSalary(), o.getSalary());
    }
}
