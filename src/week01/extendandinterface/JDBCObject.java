package week01.extendandinterface;


import java.io.IOException;

import okhttp3.Response;

public class JDBCObject {
    public void save(JDBCDao.SaveListener listener) {
        Response response = JDBCHelper.getInstance().save(this); //获取Response响应
        //响应不为空 并且响应码为201 (201在HTTP协议中表示请求成功并且服务器创建了新的资源)
        if (null != response && response.code() == 201) {
            if (response.code() == 201) {
                try {
                    String json = response.body().string(); //数据对象的字符串映射
                    listener.onSucceed(json);
                } catch (IOException e) {
                    e.printStackTrace();
                    listener.onFail(e);
                }
            }
        } else {
            //save方法请求失败
            Exception e = new Exception("save failed!");
            listener.onFail(e);
        }
    }
}


