
import week01.extendandinterface.Employee;
import week01.extendandinterface.JDBCDao;
import week01.extendandinterface.Manager;

public class Main {
    public static void main(String[] args) {
        Employee employee2 = new Employee("Rick2", 1, 8000);
        Manager manager = new Manager("SuperRick", 1, 7000, 5000);
        manager.save(new JDBCDao.SaveListener() {
            @Override
            public void onSucceed(String response) {
                System.out.println(response);
            }

            @Override
            public void onFail(Exception e) {

            }
        });
    }
}