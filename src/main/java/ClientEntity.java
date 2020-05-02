import domain.Client;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

@AllArgsConstructor
public class ClientEntity implements Runnable, Observer {
    private final Socket socket;
    private final MyServer myServer;
    private final Client user = new Client();

    @SneakyThrows
    @Override
    public void run() {
        BufferedReader socketReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String messageFromClient;
        while ((messageFromClient = socketReader.readLine()) != null) {
            //!@#REGISTRATION%^*!vitalik::qwerty
            if (messageFromClient.startsWith("!@#REGISTRATION%^*!")) {
                String[] logAndPass = messageFromClient.substring(19).split("::");
                System.out.println(logAndPass[0] + " " + logAndPass[1]);
                user.setLogin(logAndPass[0]);
                user.setPassword(logAndPass[1]);
                myServer.registerObserver(this);
            } else {
                System.out.println(messageFromClient);
                myServer.notifyObservers(messageFromClient);
            }
        }
    }

    @SneakyThrows
    @Override
    public void notifyObserver(String message) {
        PrintWriter socketWriter = new PrintWriter(socket.getOutputStream());
        socketWriter.println(message);
        socketWriter.flush();
    }
}