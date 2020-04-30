import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer {
    public static final int PORT = 8080;

    @SneakyThrows
    public void start() {
        ServerSocket serverSocket = new ServerSocket(PORT);
        Socket socket = null;

        while (true) {
            socket = serverSocket.accept();
            if (socket != null) {
                new Thread(new ClientEntity(socket)).start();
            }
        }
    }
}
