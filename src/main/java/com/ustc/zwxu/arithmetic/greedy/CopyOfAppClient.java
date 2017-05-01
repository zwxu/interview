package com.ustc.zwxu.arithmetic.greedy;

import java.util.Collection;  
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.apache.curator.framework.CuratorFramework;  
import org.apache.curator.framework.CuratorFrameworkFactory;  
import org.apache.curator.retry.ExponentialBackoffRetry;  
import org.apache.curator.x.discovery.ServiceDiscovery;  
import org.apache.curator.x.discovery.ServiceDiscoveryBuilder;  
import org.apache.curator.x.discovery.ServiceInstance;  
import org.apache.curator.x.discovery.ServiceInstanceBuilder;
import org.apache.curator.x.discovery.details.JsonInstanceSerializer;

import com.iflytek.ifreeconf.core.model.NodeInfoBean;
import com.iflytek.ifreeconf.core.model.NodeModulesBean;

  


public class CopyOfAppClient {  
    public static void main(String[] args) throws Exception{  
        CuratorFramework client = CuratorFrameworkFactory.newClient("127.0.0.1:2181", new ExponentialBackoffRetry(1000, 3));  
        client.start();  
        client.blockUntilConnected();  
          
        ServiceDiscovery<NodeInfoBean> serviceDiscovery = ServiceDiscoveryBuilder.builder(NodeInfoBean.class)
                .client(client)
                .serializer(new JsonInstanceSerializer<NodeInfoBean>(NodeInfoBean.class))
                .basePath("/ifreeconf/client/BaseInterface/development/hf")
                .build();
        
        String localhost = NetUtils.getLocalHost();
        String caseId = String.format("%s_%s", localhost, DateUtils.now("yyyyMMddHHmmssSSS"));
        ServiceInstanceBuilder<NodeInfoBean> instanceBuilder = ServiceInstance.builder();
        instanceBuilder.name("client");
        instanceBuilder.id("123456789");
        instanceBuilder.address(localhost);
        //instanceBuilder.payload(info);
        
        serviceDiscovery.start();
        serviceDiscovery.updateService(instanceBuilder.build());
        
        /*Collection<ServiceInstance<NodeInfoBean>> services = serviceDiscovery.queryForInstances("client");
        for(ServiceInstance<NodeInfoBean> service : services) {  
        	serviceDiscovery.updateService(service);
        }  
        */
        
        //serviceDiscovery.registerService(instanceBuilder.build());
        
        System.in.read();
          
        //根据名称获取服务  
        /*Collection<ServiceInstance<NodeInfoBean>> services = serviceDiscovery.queryForInstances("client");  
        for(ServiceInstance<NodeInfoBean> service : services) {  
            System.out.println(service.getPayload());  
            System.out.println(service.getAddress() + "\t" + service.getPort());  
            System.out.println("---------------------");  
        }  */
          
        //serviceDiscovery.close();  
        //client.close();  
    }  
}  


