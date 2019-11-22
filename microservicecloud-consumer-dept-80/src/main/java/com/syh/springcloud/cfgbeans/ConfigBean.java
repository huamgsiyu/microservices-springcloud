package com.syh.springcloud.cfgbeans;
 
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RetryRule;
 
@Configuration
public class ConfigBean
{
    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate()
    {
         return new RestTemplate();
    }
    
    //显式指定Ribbon使用的负载均衡算法，如果不指定，默认使用的是RoundRobinRule——轮询算法
    @Bean
    public IRule myRule () {
    	return new RetryRule();	//指定使用随机算法
    }
}

