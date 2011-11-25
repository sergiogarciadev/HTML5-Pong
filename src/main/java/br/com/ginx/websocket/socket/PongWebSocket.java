package br.com.ginx.websocket.socket;

import java.io.IOException;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.jetty.websocket.WebSocket.OnTextMessage;

public class PongWebSocket implements OnTextMessage {

    private Connection connection;
    private Set<PongWebSocket> users;

    private int player;
    
    public PongWebSocket() {
    }

    public PongWebSocket(Set<PongWebSocket> users) {
        this.users = users;
    }

    public void onMessage(String data) {
        for (PongWebSocket user : users) {
            try {
                user.connection.sendMessage(data + ":" + this.player);
            } catch (Exception e) {
            }
        }

    }

    @Override
    public void onOpen(Connection connection) {
        this.connection = connection;
        users.add(this);
        this.player = users.size();
        
        try {
            this.connection.sendMessage("player:" + this.player);
        } catch (IOException ex) {
        }
        
        if (users.size() == 2) {
            for (PongWebSocket user : users) {
            try {
                user.connection.sendMessage("start");
            } catch (Exception e) {
            }
        }
        }
    }

    @Override
    public void onClose(int closeCode, String message) {
        users.remove(this);

    }
}
