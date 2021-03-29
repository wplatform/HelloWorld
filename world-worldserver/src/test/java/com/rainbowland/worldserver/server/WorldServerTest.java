package com.rainbowland.worldserver.server;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import reactor.netty.DisposableServer;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

class WorldServerTest {

    @Test
    void proto() throws IOException {

        Socket socket = new Socket("127.0.0.1", 8085);
        InputStream inputStream = socket.getInputStream();
        BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())));

        System.out.println(in.readLine());
        out.print("WORLD OF WARCRAFT CONNECTION - CLIENT TO SERVER - V2\n");
        out.flush();

        System.out.println(in.read());
        System.out.println(in.read());
        System.out.println(in.read());
        System.out.println(in.read());
        System.out.println(in.read());
        System.out.println(in.read());
        System.out.println(in.read());
        System.out.println(in.read());
        System.out.println(in.read());
        System.out.println(in.read());
        System.out.println(in.read());
        System.out.println(in.read());
        System.out.println(in.read());
        System.out.println(in.read());
        System.out.println(in.read());
        System.out.println(in.read());
        System.out.println(in.read());
        System.out.println(in.read());
        System.out.println(in.read());
        System.out.println(in.read());
        System.out.println(in.read());
        System.out.println(in.read());
        System.out.println(in.read());
        System.out.println(in.read());
    }


}