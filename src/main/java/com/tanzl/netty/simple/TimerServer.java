package com.tanzl.netty.simple;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class TimerServer {
  public void bind(int port) {
	  EventLoopGroup bossGroup=new NioEventLoopGroup();
	  EventLoopGroup workerGroup=new NioEventLoopGroup();
	try {
		  ServerBootstrap b=new ServerBootstrap();
		  b.group(bossGroup,workerGroup).channel(NioServerSocketChannel.class).option(ChannelOption.SO_BACKLOG, 1024)
		  .childHandler(new ChildChannelHandler() );
		  ChannelFuture f;
		  f = b.bind(port).sync();
		  f.channel().closeFuture().sync();
	} catch (InterruptedException e) {
		e.printStackTrace();
		bossGroup.shutdownGracefully();
		workerGroup.shutdownGracefully();
	}
	
  }
  private class ChildChannelHandler extends ChannelInitializer<SocketChannel>{
	@Override
	protected void initChannel(SocketChannel channel) throws Exception {
        channel.pipeline().addLast(new TimeServerHandler())	;	
	}
	  
  }
  
}

