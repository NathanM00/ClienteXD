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

			while(true){
				String line = reader.readLine();
				System.out.println(line);
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}

 */