package com.project.gossip.server;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;

public class TcpServer extends Server {

  private ServerSocketChannel serverSocket;

  public TcpServer(int port, String addr) throws Exception {
    super(port, InetAddress.getByName(addr));

    this.serverSocket = ServerSocketChannel.open();
    this.serverSocket.bind(new InetSocketAddress(getAddr(), port));

    // Set nonblocking mode for the listening socket
    this.serverSocket.configureBlocking(false);
  }

  public ServerSocketChannel getServerSocket() {
    return this.serverSocket;
  }
}

