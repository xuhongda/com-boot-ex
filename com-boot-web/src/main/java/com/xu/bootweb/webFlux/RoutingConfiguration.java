package com.xu.bootweb.webFlux;

import com.xu.bootweb.MyRepository;
import entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

/**
 * <p>
 * webflux
 * </P>
 *
 * @author xuhongda on 2018/9/8
 * com.xu.bootweb.webFlux
 * com-boot-ex
 */
@Configuration
public class RoutingConfiguration {

    @Bean
    public RouterFunction<ServerResponse> monoRouterFunction(UserHandler userHandler) {
        return route(GET("/reactive/hello").and(accept(APPLICATION_JSON_UTF8)), userHandler::getUser);
    }

}

@Component
class UserHandler {

    private final MyRepository myRepository;

    @Autowired
    public UserHandler(MyRepository myRepository) {
        this.myRepository = myRepository;
    }

    Mono<ServerResponse> getUser(ServerRequest request) {
        // ...
        UserEntity userEntity = myRepository.get();
        Mono<UserEntity> just = Mono.just(userEntity);
        return ServerResponse.ok().body(just, UserEntity.class);

    }

    Mono<ServerResponse> getUserCustomers(ServerRequest request) {
        // ...
        return null;
    }

    Mono<ServerResponse> deleteUser(ServerRequest request) {
        // ...
        return null;
    }
}