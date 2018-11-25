package week02.callback;

public class Manager extends Employee{
    private int bonus;

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public Manager(String name, int sex, int salary,int bonus) {
        super(name, sex, salary);
        this.bonus = (int) (bonus * Math.random()); //0-bonus的值
    }

    /**
     * 重写
     * @return
     */
    @Override
    public int getSalary() {
        int baseSalary = super.getSalary();
        return baseSalary + bonus;
    }

    public final int test() {
        return 0;
    }

}
