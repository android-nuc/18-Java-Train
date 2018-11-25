package week02.callback;

public class Main {
    public static void main(String[] args) {
      /* class ResponseHandler implements JDBCDao.SaveListener {
            @Override
            public void onSucceed(String jsonResponse) {
                System.out.println(jsonResponse);
            }

            @Override
            public void onFail() {
                System.out.println("网络请求失败");
            }
        }
       */


        Employee employee = new Employee("java", 1, 15000);
        System.out.println(employee);
        System.out.println(new Employee("python", 1, 123));
        //匿名内部类作为方法的参数

        //匿名内部类 这个类没有名字
        JDBCDao.SaveListener saveListener = new JDBCDao.SaveListener() {
            private int a = 123;

            public int getA() {
                return a;
            }

            @Override
            public void onSucceed(String jsonResponse) {
                System.out.println(jsonResponse);
                System.out.println("here    ");
                System.out.println(getA());

            }

            @Override
            public void onFailed() {
                System.out.println("请求失败");
            }
        };

        employee.save(saveListener);
    }
}
