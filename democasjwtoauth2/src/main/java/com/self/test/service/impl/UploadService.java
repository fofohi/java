package com.self.test.service.impl;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.http.*;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URI;
import java.nio.ByteBuffer;

public class UploadService {
    public void connect(String host,int port,String url,String local) throws Exception {
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        try {
            Bootstrap b = new Bootstrap();

            b.group(workerGroup);
            b.channel(NioSocketChannel.class);
            b.option(ChannelOption.SO_KEEPALIVE, true);
            //b.handler(new IntermediaryChannelHandler());

            /*--========== 启动客户端 fsfs==========--*/
            ChannelFuture f = b.connect(host, port).sync();
            URI uri = new URI(url);
            /**DefaultFullHttpRequest --模拟浏览器请求，http的版本|http的请求方式|请求url**/
            DefaultFullHttpRequest request = new DefaultFullHttpRequest(HttpVersion.HTTP_1_1, HttpMethod.GET, uri.toASCIIString());

            /*--======== 构建 http 请求 =========--*/
            request.headers().set(HttpHeaderNames.HOST, host);
            request.headers().set(HttpHeaderNames.CONNECTION, HttpHeaderNames.CONNECTION);
            request.headers().set(HttpHeaderNames.CONTENT_LENGTH, request.content().readableBytes());

            /*--======== 发送 http 请求 =========--*/
            f.channel().write(request);
            f.channel().flush();
            f.channel().closeFuture().sync();
        } finally {
            workerGroup.shutdownGracefully();//优雅退出
        }
    }

    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket();
        serverSocket.bind(new InetSocketAddress(8787));
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        String out = "C:\\Users\\JDD\\Desktop\\id_rsa3.txt";

        FileOutputStream outputStream = new FileOutputStream(out);
        while (true) {
            Socket socket = serverSocket.accept();
            InputStream in = socket.getInputStream();
            while (in.read(byteBuffer.array()) != -1){
                byteBuffer.flip();
                System.out.println(".... write ....");
                outputStream.write(byteBuffer.array());
                byteBuffer.clear();
            }
        }
    }

}
