package week01.classandobject;

/**
 * Java实体类
 * 使用private修饰属性
 * 对外提供public的getter和setter方法
 */
public class Book {

    public String publicName;

    private String name;

    private int price;

    private boolean isCS;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isCS() {
        return isCS;
    }

    public void setCS(boolean CS) {
        isCS = CS;
    }
}
