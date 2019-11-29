package com.swiggy.jetty;

import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.servlet.ServletHandler;

import java.util.Objects;
import java.util.concurrent.CompletableFuture;

public class JettyServer {

  private final Server server;

  JettyServer() throws InterruptedException {

    server = new Server();
    server.join();
    ServerConnector connector = new ServerConnector(server);
    connector.setPort(8050);
    server.setConnectors(new Connector[] {connector});
  }

  Server start() throws Exception {

    server.join();
    return CompletableFuture.supplyAsync(
            () -> {
                return server;
            })
        .get();
  }

  void setHandler(ServletHandler servletHandler) throws Exception {

    if (Objects.nonNull(server)) {
      server.setHandler(servletHandler);
    }
  }

  @Override
  protected void finalize() {
    System.out.println("Server stopped");
  }
}
