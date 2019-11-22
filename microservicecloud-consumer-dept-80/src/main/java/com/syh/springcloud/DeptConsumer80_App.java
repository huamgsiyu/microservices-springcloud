package com.syh.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

import com.syh.springcloud.cfgbeans.ConfigBean;

@SpringBootApplication
@EnableEurekaClient
//@RibbonClient(name="MICROSERVICECLOUD-DEPT",configuration=MySelfRule.class)	//使用MySelfRule无法使得Ribbon算法生效，不知道为什么？ 
@RibbonClient(name = "MICROSERVICECLOUD-DEPT", configuration = ConfigBean.class)
public class DeptConsumer80_App {
	public static void main(String[] args) {
		SpringApplication.run(DeptConsumer80_App.class, args);
	}
}
//在启动该微服务的时候就能去加载我们的自定义Ribbon配置类，从而使配置生效
/*
 * 官方文档给出警告：
	这个自定义的类不能放在@ComponentScan所扫描的当前包以及子包下，
	否则我们自定义的这个配置类就会被所有的Ribbon客户端所共享，
	也就是我们达不到特殊化指定的目的了。
 */