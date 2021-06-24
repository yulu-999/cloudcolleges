package team.rookie.myzuul.config;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * @ClassName MyFiller
 * @Description TODO
 * @Author tran
 * @Date 2021/6/22 8:26
 * @Version 1.0
 **/
@Configuration
public class MyFiller extends ZuulFilter {



    @Override
    public String filterType() {
        return "pre"; // 可以在请求被路由之前调用
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @CrossOrigin("*")
    @Override
    public Object run() throws ZuulException {

        return null;
    }
}
