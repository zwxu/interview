package com.ustc.zwxu.arithmetic.greedy;

import java.util.concurrent.TimeUnit;  

import org.apache.curator.framework.CuratorFramework;  
import org.apache.curator.framework.CuratorFrameworkFactory;  
import org.apache.curator.retry.ExponentialBackoffRetry;  
import org.apache.curator.x.discovery.ServiceDiscovery;  
import org.apache.curator.x.discovery.ServiceDiscoveryBuilder;  
import org.apache.curator.x.discovery.ServiceInstance;  
import org.apache.curator.x.discovery.ServiceInstanceBuilder;  
import org.apache.curator.x.discovery.details.JsonInstanceSerializer;  
  

class ServiceDetail {  
    //服务注册的根路径  
    public static final String REGISTER_ROOT_PATH = "/mall";  
      
    private String desc;  
    private int weight;  
      
    public ServiceDetail() {}  
    public ServiceDetail(String desc, int weight) {  
        this.desc = desc;  
        this.weight = weight;  
    }  
    public String getDesc() {  
        return desc;  
    }  
    public void setDesc(String desc) {  
        this.desc = desc;  
    }  
    public int getWeight() {  
        return weight;  
    }  
    public void setWeight(int weight) {  
        this.weight = weight;  
    }  
    @Override  
    public String toString() {  
        return "ServiceDetail [desc=" + desc + ", weight=" + weight + "]";  
    }  
}  
  
public class ServerApp {  
    public static void main(String[] args) throws Exception {  
        CuratorFramework client = CuratorFrameworkFactory.newClient("127.0.0.1:2181", new ExponentialBackoffRetry(1000, 3));  
        client.start();  
        client.blockUntilConnected();  
          
        /** 
         * 指定服务的 地址，端口，名称 
         */  
        ServiceInstanceBuilder<ServiceDetail> sib = ServiceInstance.builder();  
        sib.address("127.0.0.1");  
        sib.port(8855);  
        sib.name("tomcat");  
        sib.payload(new ServiceDetail("主站web程序", 1));  
          
        ServiceInstance<ServiceDetail> instance = sib.build();  
          
        ServiceDiscovery<ServiceDetail> serviceDiscovery = ServiceDiscoveryBuilder.builder(ServiceDetail.class)  
                                                           .client(client)  
                                                           .serializer(new JsonInstanceSerializer<ServiceDetail>(ServiceDetail.class))  
                                                           .basePath(ServiceDetail.REGISTER_ROOT_PATH)  
                                                           .build();  
        //服务注册  
        serviceDiscovery.registerService(instance);  
        serviceDiscovery.start();  
          
        TimeUnit.SECONDS.sleep(70);  
          
        serviceDiscovery.close();  
        client.close();  
    }  
}  