package soft.spring.aop.demo.main;

import soft.spring.aop.demo.intercept.MyInterceptor;
import soft.spring.aop.demo.proxy.ProxyBean;
import soft.spring.aop.demo.service.HelloService;
import soft.spring.aop.demo.service.impl.HelloServiceImpl;

/**
 * @author : zhayh
 * @date : 2020-3-17 19:50
 * @description : 测试约定流程
 *
 */
public class AopMain {
    public static void main(String[] args) {
        testProxy();
    }

    private static void testProxy() {
        HelloService helloService = new HelloServiceImpl();
        HelloService proxy = (HelloService) ProxyBean.getProxyBean(helloService, new MyInterceptor());
        proxy.sayHello("张三");
        System.out.println("=========== name is null！！ ===========");
        proxy.sayHello(null);
    }
}
