package input.handler;


import input.entiy.Restfulentiy;
import input.error.Requesterror;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.HttpMethod;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.HttpResponseStatus;

public class HttpMethodHandler extends SimpleChannelInboundHandler<HttpRequest>{
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, HttpRequest httpRequest) throws Exception {
        if(httpRequest.getMethod().equals(HttpMethod.GET)){
            ctx.fireChannelRead(httpRequest);
        } else if(httpRequest.getMethod().equals(HttpMethod.POST)){
            boolean b = postRequest();
            ctx.fireChannelRead(httpRequest);
        } else if(httpRequest.getMethod().equals(HttpMethod.DELETE)){
            boolean b = deleteRequest();
            ctx.fireChannelRead(httpRequest);
        } else if(httpRequest.getMethod().equals(HttpMethod.PUT)){
            boolean b = putRequest();
            ctx.fireChannelRead(httpRequest);
        }
        else {
            response(ctx,httpRequest, Requesterror.Method_Error);
            ctx.close();
        }
    }

    public Restfulentiy getRequest(){
        Restfulentiy restfulentiy =new Restfulentiy();
        return restfulentiy;
    }

    public boolean postRequest(){
        Restfulentiy restfulentiy =new Restfulentiy();
        return false;
    }

    public boolean deleteRequest(){
        Restfulentiy restfulentiy =new Restfulentiy();
        return false;
    }

    public boolean putRequest(){
        Restfulentiy restfulentiy =new Restfulentiy();
        return false;
    }

    public void response(ChannelHandlerContext ctx, HttpRequest httpRequest, Requesterror re){
        DefaultFullHttpResponse response =new DefaultFullHttpResponse(httpRequest.protocolVersion(), HttpResponseStatus.OK);

        response.headers().set("111",re);
        response.content().writeBytes( re.toString().getBytes());
        //写回
        ctx.writeAndFlush(response);
    }
}
