package com.tan.netty;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;

public class OioWithoutNetty {
	public  void server(int port) throws IOException {
		final ServerSocket socket=new ServerSocket(port);
		try {
			for(;;) {
				final Socket  cliensocket=socket.accept();
				new Thread(new Runnable() {
					
					@Override
					public void run() {
						OutputStream out;
						
						out=cliensocket.getOutputStream();
						out.write("hi".getBytes(Charset.forName("UTF-8")));
						out.flush();
						cliensocket.close();
					}
				}).start();
			}
			
		}catch() {
			
		}
		
		
	}
}
