package server.impl;

import org.apache.logging.log4j.Logger;
import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;
import server.AbstractWsEchoServer;

import java.net.InetSocketAddress;

public class SimpleWsEchoServer extends AbstractWsEchoServer {

    public SimpleWsEchoServer(Logger logger, InetSocketAddress address) {
        super(logger, address);
    }

    @Override
    public void onOpen(WebSocket conn, ClientHandshake handshake) {
        super.onOpen(conn, handshake);
    }

    @Override
    protected String handleMessage(String inputMsg) {
        return inputMsg;
    }
}
