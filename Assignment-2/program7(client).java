import java.io.*;
import java.net.*;

public class EchoClient {
    public static void main(String[] args) {
        String hostname = "localhost";
        int port = 5000;

        try (Socket socket = new Socket(hostname, port);
             OutputStream out = socket.getOutputStream();
             PrintWriter writer = new PrintWriter(out, true);
             InputStream in = socket.getInputStream();
             BufferedReader reader = new BufferedReader(new InputStreamReader(in));
             BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in))) {

            String text;
            System.out.println("Connected to server. Type messages (type 'exit' to quit):");

            do {
                System.out.print("> ");
                text = consoleReader.readLine();
                writer.println(text);

                String response = reader.readLine();
                System.out.println(response);

            } while (!text.equals("exit"));

        } catch (UnknownHostException ex) {
            System.out.println("Server not found: " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("I/O error: " + ex.getMessage());
        }
    }
}
