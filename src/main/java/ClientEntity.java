import domain.Client;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

@AllArgsConstructor
public class ClientEntity implements Runnable {
    private final Socket socket;
    private final Client user = new Client();

    @SneakyThrows
    @Override
    public void run() {
        BufferedReader socketReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String input;
        while ((input = socketReader.readLine()) != null) {
            //!@#REGISTRATION%^*!vitalik::qwerty
            if (input.startsWith("!@#REGISTRATION%^*!")) {
                String[] logAndPass = input.substring(19).split("::");
                System.out.println(logAndPass[0] + " " + logAndPass[1]);
                user.setLogin(logAndPass[0]);
                user.setPassword(logAndPass[1]);
            } else {
                System.out.println(input);
            }
        }
    }
}