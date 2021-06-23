package team.rookie.remark;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @ClassName RemarkApplication
 * @Description TODO
 * @Author tran
 * @Date 2021/6/22 15:22
 * @Version 1.0
 **/
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient //服务发现
@EnableFeignClients
public class RemarkApplication {

    public static void main(String[] args) {
        SpringApplication.run(RemarkApplication.class,args);
    }
}
