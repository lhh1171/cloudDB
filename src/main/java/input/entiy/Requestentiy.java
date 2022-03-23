package input.entiy;

import io.netty.handler.codec.http.HttpMethod;

public class Requestentiy  {
    String uri;
    HttpMethod method;
    String  content;

    @Override
    public String toString() {
        return "{" + '\n' +
                "uri='" + uri + '\''+'\n' +
                "mode=" + method +'\n'+
                "content=" + content +'\n'+
                '}';
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public HttpMethod getMode() {
        return method;
    }

    public void setMode(HttpMethod mode) {
        this.method = mode;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Requestentiy(String uri, HttpMethod mode, String content) {
        this.uri = uri;
        this.method = mode;
        this.content = content;
    }

    public Requestentiy() {
    }
}
