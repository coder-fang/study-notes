package com.atguigu.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author LiFang
 * @version 1.0
 * @since 2021/12/30 21:02
 * 使用java配置路由
 */

@Configuration
public class GateWayConfig {
    /**
     * @param routeLocatorBuilder
     * @return org.springframework.cloud.gateway.route.RouteLocator
     * @description 配置了一个id为route_name的路由规则，
     * 当访问地址为http://localhost:9527/guonei时会自动转发到地址：http://news.baidu.com/guonei
     * @author LiFang
     * @date 2021/12/30 21:27
     */
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder) {
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        routes.route("path_route_atguigu",
                r -> r.path("/guonei")
                        .uri("http://news.baidu.com/guonei")).build();
        return routes.build();
    }

    @Bean
    public RouteLocator customRouteLocator2(RouteLocatorBuilder builder) {
        RouteLocatorBuilder.Builder routes = builder.routes();
        routes.route("path_route_atguigu2", r -> r.path("/guoji").uri("http://news.baidu.com/guoji")).build();
        return routes.build();
    }
}
