package team.rookie.myzuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @ClassName ZuulApplication
 * @Description TODO 网关
 * @Author tran
 * @Date 2021/6/22 15:25
 * @Version 1.0
 **/
@SpringBootApplication
@EnableZuulProxy  //加上zuul代理注解即可让当前项目启动的时候加载到zuul组件
@EnableFeignClients

public class ZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZuulApplication.class,args);
    }
}
