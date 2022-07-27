package input.input;

import io.netty.handler.codec.http.HttpMethod;
/**
 * @author : wyy
 * @Date : 2022.7.11
 */
public abstract class RequestEntity {
    String uri;
    HttpMethod method;
}
