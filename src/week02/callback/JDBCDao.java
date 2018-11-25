package week02.callback;

public class JDBCDao {
    public interface SaveListener {
        void onSucceed(String jsonResponse);

        void onFailed();
    }
}
