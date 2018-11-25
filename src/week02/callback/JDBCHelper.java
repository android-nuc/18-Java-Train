package week02.callback;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class JDBCHelper {

    private static volatile JDBCHelper sJDBCHelper;
    private OkHttpClient mClient = new OkHttpClient();

    private JDBCHelper() {

    }

    /**
     * 线程安全的懒加载单例
     *
     * @return
     */
    public static JDBCHelper getInstance() {
        if (null == sJDBCHelper) {
            synchronized (JDBCHelper.class) {
                sJDBCHelper = new JDBCHelper();
            }
        }
        return sJDBCHelper;
    }

    public Response save(Object object) {
        String className = object.getClass().getName();
        className = className.substring(className.lastIndexOf(".") + 1, className.length()).toLowerCase();
        String url = "http://120.77.182.38/javatrain/" + className + "/";
        FormBody.Builder builder = new FormBody.Builder();

        if (object instanceof Employee) {
            Employee e = (Employee) object;
            builder.add("name", e.getName());
            builder.add("salary", String.valueOf(e.getSalary()));
            builder.add("sex", String.valueOf(e.getSex()));
            builder.add("description", String.valueOf(e.getDescription()));
        } else if (object instanceof Manager) {
            Manager m = (Manager) object;
            builder.add("name", m.getName());
            builder.add("salary", String.valueOf(m.getSalary()));
            builder.add("sex", String.valueOf(m.getSex()));
            builder.add("description", String.valueOf(m.getDescription()));
            builder.add("bonus", String.valueOf(m.getBonus()));
        }

        Request request = new Request.Builder()
                .url(url)
                .post(builder.build())
                .build();
        Response response = null;
        try {
            response = mClient.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return response;
    }
}
