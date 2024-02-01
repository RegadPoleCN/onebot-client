package server;

import org.apache.logging.log4j.Logger;
import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;

import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;

public abstract class AbstractWsEchoServer extends WebSocketServer {

    Logger log;

    public AbstractWsEchoServer(Logger log, InetSocketAddress address) {
        super(address);
        this.log = log;
    }

    @Override
    public void onOpen(WebSocket conn, ClientHandshake handshake) {
        log.info("onOpen: {} " , new String(handshake.getContent(), StandardCharsets.UTF_8));
    }

    @Override
    public void onClose(WebSocket conn, int code, String reason, boolean remote) {
        log.info("");
    }

    @Override
    public void onMessage(WebSocket conn, String message) {
        log.info("received message: {} ", message);
        conn.send(handleMessage(message));
    }

    protected abstract String handleMessage(String inputMsg);
    @Override
    public void onError(WebSocket conn, Exception ex) {

    }

    @Override
    public void onStart() {
        log.info("onStart() ");
    }
}
