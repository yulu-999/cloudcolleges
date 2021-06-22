package team.rookie.course;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @ClassName CourseApplication
 * @Description TODO 学生课程管理
 * @Author tran
 * @Date 2021/6/22 15:20
 * @Version 1.0
 **/
@SpringBootApplication
@EnableEurekaClient
public class CourseApplication {
    public static void main(String[] args) {
        SpringApplication.run(CourseApplication.class,args);
    }
}
