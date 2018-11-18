package week01.extendandinterface;

public class Employee extends Person implements Comparable<Employee>{
    private int salary;

    public Employee() {
    }

    public Employee(String name, int sex, int salary) {
        super(name, sex);
        this.salary = salary;
    }

    @Override
    public String getDescription() {
        return super.getName() + " " + super.getSex() + " " + getSalary();
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + super.getName() + '\'' +
                ", sex=" + super.getSex() +
                ", salary=" + salary +
                '}' + '\n';
    }



    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; //如果引用相同
        if (obj == null) return false; //如果比较的对象为null,一定不相等
        if (getClass()  != obj.getClass()) return false; //getClass获取对象的类.如果两个对象类都不相同,那么这两个对象肯定不相同
        //排除了前面的条件后,就可以开始判断这两个类的信息是否相同
        Employee other = (Employee) obj;
        return this.getName() == other.getName()
                && this.getSalary() == other.getSalary()
                && this.getSex() == other.getSex();
    }


    @Override
    public int compareTo(Employee o) {
        return Integer.compare(getSalary(), o.getSalary());
    }
}
