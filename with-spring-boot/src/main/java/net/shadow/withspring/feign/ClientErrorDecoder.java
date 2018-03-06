package net.shadow.withspring.feign;

import feign.Response;
import feign.codec.ErrorDecoder;

public class ClientErrorDecoder extends ErrorDecoder.Default {

    @Override
    public Exception decode(String methodKey, Response response) {
        return super.decode(methodKey, response);
    }
}
