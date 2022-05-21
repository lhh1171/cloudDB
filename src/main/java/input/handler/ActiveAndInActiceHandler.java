package input.handler;


import input.entiy.Requestentiy;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.util.CharsetUtil;
import io.netty.util.ReferenceCountUtil;


public class ActiveAndInActiceHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        String ip=ctx.channel().remoteAddress().toString();
        String[] a= ip.split(":");
        System.out.println(a[0]+"-->"+"已连接");
    }
    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        String ip=ctx.channel().remoteAddress().toString();
        String[] a= ip.split(":");
        System.out.println(a[0]+"-->"+"已断开");
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        if (!(msg instanceof HttpRequest)) ReferenceCountUtil.release(msg);
        Requestentiy requestentiy = toRequestentiy(msg);
        //Restfulentiy restfulentiy = toRestfulentiy(msg);
        ctx.fireChannelRead(msg);
    }
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }

    //将从客户端传来的HTTP+Json转换为自定义Request对象
    public Requestentiy toRequestentiy(Object msg){

        FullHttpRequest fullHttpRequest =(FullHttpRequest) msg;
        String content = fullHttpRequest.content().toString(CharsetUtil.UTF_8);
        return new Requestentiy(fullHttpRequest.getUri(),fullHttpRequest.getMethod(),content);
    }

}

