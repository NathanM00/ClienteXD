package com.example.a1006106113.myapplication;

import android.util.Log;
import android.webkit.ClientCertRequest;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class Client extends Thread {

    Socket ss;
    Receptor r;

    MainActivity activity;

    public Client(MainActivity activity){
        this.activity = activity;
    }

    @Override
    public void run() {
        try {
             ss = new Socket("172.30.160.16",5000);
             r = new Receptor(ss);
             r.setObserver(activity);
             r.start();
            Log.e("DEBUG","SI NOS CONECTAMOS MANIN");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void enviar(){

        new Thread(new Runnable() {
            @Override
            public void run() {
                //Este codigo se va a ejecutar en paralelo
                try {
                    OutputStream os = ss.getOutputStream();
                    PrintWriter out = new PrintWriter( new OutputStreamWriter(os)  );
                    out.println("Prendalo");
                    out.flush();

                } catch (IOException e) {

                }

            }
        }).start();

    }
}

/*
import java.io.IOException;
        import java.net.InetAddress;
        import java.net.ServerSocket;
        import java.net.UnknownHostException;

public class Main {

    public static void main(String[] args) {
        Servidor ser = new Servidor();
        ser.start();
        System.out.println("Bienvenido servidor!");

    }
}
*/

/*import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class Receptor extends Thread{
	Socket socket;

	public Receptor(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		try {
			InputStream is = socket.getInputStream();
			BufferedReader reader = new BufferedReader( new InputStreamReader(is) );

			PrintWriter out = new PrintWriter ( new OutputStreamWriter(  socket.getOutputStream()  )  );

			while(true){
				String line = reader.readLine();
				System.out.println(line);

				out.println("Prendalo!!");
			    out.flush();

			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Siempre quiero que este en funcionamiento

	}

}
/*
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor extends Thread{

	@Override
	public void run() {
		try {
			ServerSocket server = new ServerSocket(5000);
			System.out.println("Esperando conexion");
			Socket s = server.accept();
			System.out.println("Conexion aceptada");

			Receptor receptor = new Receptor(s);
			receptor.start();


		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

 */