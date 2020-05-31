package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {

    ServerSocket ss;
    ArrayList<ServerConnection> connections = new ArrayList<>();
    boolean shouldRun = true;

    public static void main(String[] args) {
        new Server();
    }

    public Server() {
        try {
            while (shouldRun) {
                    ss = new ServerSocket(3333);
                    Socket s = ss.accept();
                    ServerConnection sc = new ServerConnection(s, this);
                    connections.add(sc);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
}
