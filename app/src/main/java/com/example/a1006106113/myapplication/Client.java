package com.example.a1006106113.myapplication;

import android.util.Log;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class Client extends Thread {

    @Override
    public void run() {
        try {
            Socket ss = new Socket("10.0.2.2",5000);

            InputStream is =ss.getInputStream();
            OutputStream os = ss.getOutputStream();

            PrintWriter out = new PrintWriter( new OutputStreamWriter(os)  );
            out.println("Prendalo");
            out.flush();

            Log.e("DEBUG","SI NOS CONECTAMOS MANIN");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
