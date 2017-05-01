package com.ustc.zwxu.arithmetic.greedy;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.cache.NodeCache;
import org.apache.curator.framework.recipes.cache.NodeCacheListener;
import org.apache.curator.framework.recipes.cache.PathChildrenCache;
import org.apache.curator.framework.recipes.cache.PathChildrenCacheEvent;
import org.apache.curator.framework.recipes.cache.PathChildrenCacheListener;
import org.apache.curator.framework.recipes.cache.PathChildrenCache.StartMode;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.data.Stat;

import com.google.gson.Gson;


/**
 * Curator事件监听
 * @author  huey
 * @version 1.0 
 * @created 2015-3-2
 */
public class CarutorDemo {
 
    public static void main(String[] args) throws Exception {
        CuratorFramework client = CuratorFrameworkFactory.builder()
            .connectString("127.0.0.1:2181")
            .sessionTimeoutMs(5000)
            .connectionTimeoutMs(3000)
            .retryPolicy(new ExponentialBackoffRetry(1000, 3))
            .build();
        client.start();
        if(client.checkExists().forPath("/ifreeconf/client") == null) {
			System.out.println("bye bye");
		} else {
			List<String> children = client.getChildren().forPath("/ifreeconf/client");
			for(String s:children){
				System.out.println(s);
			}
		}
        //client.delete().forPath("/zk-huey/cnode");
        /*client.create()
            .creatingParentsIfNeeded()
            .forPath("/zk-huey/cnode", "hello".getBytes());*/
        //byte[] data = client.getData().forPath("/ifreeconf/baseinterface/development/hefei/notice");
        /*
        ModulesNotice notice = new Gson().fromJson(new String(data), ModulesNotice.class);
        System.out.print("haha:"+notice.getNid());*/
        
        /**
         * 在注册监听器的时候，如果传入此参数，当事件触发时，逻辑由线程池处理
         */
        ExecutorService pool = Executors.newFixedThreadPool(2);
        
        /**
         * 监听数据节点的变化情况
         */
        /*final NodeCache nodeCache = new NodeCache(client, "/ifreeconf/baseinterface/development/hefei/notice", false);
        nodeCache.start(true);
        nodeCache.getListenable().addListener(
            new NodeCacheListener() {
                @Override
                public void nodeChanged() throws Exception {
                    System.out.println("Node data is changed, new data: " + 
                        new String(nodeCache.getCurrentData().getData()));
                }
            }, 
            pool
        );*/
        
        
        /**
         * 监听子节点的变化情况
         */
        final PathChildrenCache childrenCache = new PathChildrenCache(client, "/ifreeconf/baseinterface/development/hefei/notice", true);
        childrenCache.start(StartMode.POST_INITIALIZED_EVENT);
        childrenCache.getListenable().addListener(
            new PathChildrenCacheListener() {
                public void childEvent(CuratorFramework client, PathChildrenCacheEvent event)
                        throws Exception {
                        switch (event.getType()) {
                        case CHILD_ADDED:
                            System.out.println("CHILD_ADDED: " + event.getData().getPath());
                            break;
                        case CHILD_REMOVED:
                            System.out.println("CHILD_REMOVED: " + event.getData().getPath());
                            break;
                        case CHILD_UPDATED:
                            System.out.println("CHILD_UPDATED: " + event.getData().getPath());
                            break;
                        default:
                            break;
                    }
                }
            },
            pool
        );
        
        //client.setData().forPath("/ifreeconf/baseinterface/development/hefei/notice", data);
        Stat s = client.checkExists().forPath("/ifreeconf/baseinterface/development/hefei/notice");
        System.out.println(s);
        Thread.sleep(10 * 1000);
        pool.shutdown();
        client.close();
    }
}
