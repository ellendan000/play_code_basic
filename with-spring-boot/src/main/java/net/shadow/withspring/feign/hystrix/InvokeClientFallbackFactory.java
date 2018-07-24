package net.shadow.withspring.feign.hystrix;

import feign.hystrix.FallbackFactory;
import net.shadow.withspring.exception.InvalidIdException;
import net.shadow.withspring.feign.InvokeClientWithFallback;
import org.springframework.stereotype.Component;

@Component
public class InvokeClientFallbackFactory implements FallbackFactory<InvokeClientWithFallback> {

    /**
     * @param cause FeignException
     *              message:
     *              status 400 reading InvokeClient01#name(String); content:
     *              {"timestamp":1503656322499,
     *              "status":400,
     *              "error":"Bad Request",
     *              "exception":"net.shadow.withspring.feign.target.InvalidIdException",
     *              "message":"This id is invalid.",
     *              "path":"/api/target/9"
     *              }.
     */
    @Override
    public InvokeClientWithFallback create(Throwable cause) {
        return new InvokeClientWithFallback() {
            @Override
            public String nameFallbackString(String id) {
                return "failed: reason is:" + cause.getMessage();
            }

            @Override
            public String nameFallbackException(String id) throws InvalidIdException {
                //FeignException.message
                throw new InvalidIdException(cause.getMessage());
            }
        };
    }
}
