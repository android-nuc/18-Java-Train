package week01.extendandinterface;

public class JDBCDao {
    public interface SaveListener{
        void onSucceed(String response);

        void onFail(Exception e);
    }
}
