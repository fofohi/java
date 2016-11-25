package websocket;

import com.koushikdutta.async.AsyncServer;
import com.koushikdutta.async.AsyncServerSocket;
import com.koushikdutta.async.AsyncSocket;
import com.koushikdutta.async.callback.ListenCallback;

/**
 * Created by dell on 2016/11/25.
 */
public class VncSocketServer {
    public static void main(String[] args) {
        final AsyncServer server = new AsyncServer();

      /*  AsyncServerSocket rawSocket = server.listen("", 53517, new ListenCallback() {
            @Override
            public void onCompleted(Exception e) {
                System.out.println("complete");
            }

            @Override
            public void onAccepted(AsyncSocket asyncSocket) {
                System.out.println("accepted");
                System.out.println(asyncSocket.getDataCallback());
            }

            @Override
            public void onListening(AsyncServerSocket asyncServerSocket) {
                System.out.println("listen");
            }
        });*/

    }
}
