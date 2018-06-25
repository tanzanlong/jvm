package com.tanzl.netty.simple;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class TimerClient {
  public void bind(int port) {
	  EventLoopGroup group=new NioEventLoopGroup();
	try {
		  ServerBootstrap b=new ServerBootstrap();
		  b.group(group).channel(NioServerSocketChannel.class).option(ChannelOption.SO_BACKLOG, 1024)
		  .childHandler(new ChildChannelHandler() );
		  ChannelFuture f;
		  f = b.bind(port).sync();
		  f.channel().closeFuture().sync();
	} catch (InterruptedException e) {
		e.printStackTrace();
		group.shutdownGracefully();
	}
	
  }
  private class ChildChannelHandler extends ChannelInitializer<SocketChannel>{
	@Override
	protected void initChannel(SocketChannel channel) throws Exception {
        channel.pipeline().addLast(new TimeServerHandler())	;	
	}
	  
  }
  
}

