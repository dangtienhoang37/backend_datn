//package hoanghoi.datn.config;
//
//
//import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.web.server.ServerHttpSecurity;
//import org.springframework.security.web.server.SecurityWebFilterChain;
//
//@Configuration(proxyBeanMethods = false)
//public class WebSecurityConfig MyWebFluxSecurityConfiguration{
//    @Bean
//    public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
//        http.authorizeExchange((exchange) -> {
//            exchange.matchers(PathRequest.toStaticResources().atCommonLocations()).permitAll();
//            exchange.pathMatchers()
//        });
//    }
//}
//
