package com.tan.netty;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class NiowithoutNetty {
	public void server(int port) throws IOException {
		ServerSocketChannel serverchannel=ServerSocketChannel.open();
		serverchannel.configureBlocking(false);
		ServerSocket socket=serverchannel.socket();
		InetSocketAddress address=new InetSocketAddress( port);
		socket.bind(address);
		Selector selector=Selector.open();
		serverchannel.register(selector, SelectionKey.OP_ACCEPT);
		final ByteBuffer msg=ByteBuffer.wrap("test".getBytes());
		for(;;) {
			selector.select();
			Set<SelectionKey> keys=selector.selectedKeys();
	    	Iterator<SelectionKey> iterator=keys.iterator();
			while(iterator.hasNext()) {
				SelectionKey key=iterator.next();
				iterator.remove();
			   if(key.isAcceptable()) {
				   ServerSocketChannel server=(ServerSocketChannel) key.channel();
				   SocketChannel client= server.accept();
				   client.configureBlocking(false);
				   client.register(selector, SelectionKey.OP_WRITE|SelectionKey.OP_READ, msg.duplicate());
				 
			   }
			   if(key.isWritable()) {
				   SocketChannel client=(SocketChannel) key.channel();
				   ByteBuffer buff=(ByteBuffer) key.attachment();
				   while(buff.hasRemaining()) {
					   if(client.write(buff)==0) {
						   break;
					   }
				   }
			   }
			   
			   
			}
	    	
		}
		
		
	}
}
