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
                      
                        try {
                            out = cliensocket.getOutputStream();
                            out.flush();
                            cliensocket.close();
                            out.write("hi".getBytes(Charset.forName("UTF-8")));
                        } catch (IOException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
					
					}
				}).start();
			}
			
		}catch(Exception e) {
			
		}
		
		
	}
}
