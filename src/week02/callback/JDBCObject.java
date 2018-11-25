package week02.callback;

import okhttp3.Response;

public class JDBCObject {
    public void save(JDBCDao.SaveListener listener) {
        //假设网络通信在子线程运行
        Response response =
                JDBCHelper.getInstance().save(this);
        //201创建资源成功
        if (null != response && response.code() == 201) {
            try {
                String json = response.body().string();
                listener.onSucceed(json);
            } catch (Exception e) {
                listener.onFailed();
                e.printStackTrace();
            }
        } else {
            listener.onFailed();
        }
    }
}
