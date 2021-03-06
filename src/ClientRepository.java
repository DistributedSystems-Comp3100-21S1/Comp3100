import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientRepository {

    private String mHost;
    private int mPort;
    private Socket socket;
    private BufferedReader inputReader;
    private DataOutputStream outputStream;

    public ClientRepository() {
        this("localhost", 50_000);
    }

    public ClientRepository(String host, int port) {
        mHost = host;
        mPort = port;
    }
    
    public void connectToServer() throws IOException {
        socket = new Socket(mHost, mPort);
        inputReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        outputStream = new DataOutputStream(socket.getOutputStream());
    }

    public void sendMessage(String message) throws IOException {
        sendMessage(message.getBytes());
    }

    public void sendMessage(byte[] bytes) throws IOException {
        outputStream.write(bytes);
        outputStream.flush();
    }

    public String readMessage() throws IOException {
        String message = "";
        while(!inputReader.ready()) { /* Await until messages area ready to be read */}
        while(inputReader.ready()) {
            message += (char) inputReader.read();
        }
        return message;
    }
}
