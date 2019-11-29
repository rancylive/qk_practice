package com.swiggy.jetty;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletHandler;

public class MainClass {

  public static void main(String args[]) throws Exception {

    ServletHandler servletHandler = new ServletHandler();
    servletHandler.addServletWithMapping(BlockingServelet.class, "/status");
    JettyServer jettyServer = new JettyServer();
    jettyServer.setHandler(servletHandler);
    Server server = jettyServer.start();
    server.start();
  }
}
