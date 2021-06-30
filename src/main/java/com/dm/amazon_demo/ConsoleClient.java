package com.dm.amazon_demo;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;

public class ConsoleClient {
    public static void main(String[] args) throws IOException {
        final Socket socket = new Socket("localhost", 8080);

        OutputStream oss = socket.getOutputStream();
        InputStream iss = socket.getInputStream();

        PrintStream printStream = new PrintStream(oss, true);
        //printStream.println("GET /order/fromCustomer HTTP/1.0\nname: Klaus Bauer\r\n");

        //socket.shutdownOutput();

        int c;
        StringBuilder message = new StringBuilder();
        /*while ((c = iss.read()) != -1) {
            message.append((char) c);
        }

        System.out.println(message);*/

        //final String body = "{\"id\": \"4\", \"name\": \"Klaus Koenig\"}";
        final String body = "{\"name\": \"Conrad Koenig\"}";
        //printStream.println("PUT /customer HTTP/1.0\r\ncontent-length: " + body.length() + "\r\ncontent-type: application/json\r\n\r\n" + body);
        printStream.println("PATCH /customer/4 HTTP/1.0\r\ncontent-length: " + body.length() + "\r\ncontent-type: application/json\r\n\r\n" + body);

        while ((c = iss.read()) != -1) {
            message.append((char) c);
        }

        System.out.println(message);
    }
}
