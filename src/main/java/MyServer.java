import lombok.SneakyThrows;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class MyServer implements Observable {
    public static final int PORT = 8080;
    public static volatile List<Observer> clients = new ArrayList<>();

    @SneakyThrows
    public void start() {
        ServerSocket serverSocket = new ServerSocket(PORT);

        while (true) {
            Socket socket = serverSocket.accept();
            if (socket != null) {
                new Thread(new ClientEntity(socket, this)).start();
            }
        }
    }

    @Override
    public void registerObserver(Observer o) {
        clients.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        clients.remove(o);
    }

    @Override
    public void notifyObservers(String message) {
        for (Observer observer : clients) {
            observer.notifyObserver(message);
        }
    }
}
