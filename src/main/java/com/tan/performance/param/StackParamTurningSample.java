package com.tan.performance.param;

import java.util.Vector;

/**-Xmx5M 设置最大堆 -Xms5M 设置最小堆 -verbose:gc
 * 
 * -Xmx11M -Xms4M -verbose:gc
 * 
 * -Xmx11M -Xms11M -verbose:gc
 * 
 * -Xmx11M -Xms11M -Xmn2M -XX:+PrintGCDetails
 * 
 * -Xmx11M -Xms11M -Xmn10M -XX:SurvivorRatio=8 -XX:+PrintGCDetails
 * 
 * -Xmx11M -Xms11M -XX:NewRatio=2 -XX:+PrintGCDetails
 * 
 * -Xss1M
 * 
 * -XX:NewSize
 * -XX:MaxNewSize
 * -XX:printGCDetails
 * -XX:SurvivorRatio=8 设置eden和survivor的比例
 * -XX:NewRatio=2 设置老年带和新生代的比例
 * @author tan
 *
 */
public class StackParamTurningSample {
 public static void main(String[] args) {
    Vector v=new Vector();
    for (int i = 0; i < 10; i++) {
        byte[]b=new byte[1024*1024];
        v.add(b);
        if(v.size()==3){
            v.clear();
        }
        System.out.println(i+"M is allocated");
    }
    System.out.println("Max memory:"+Runtime.getRuntime().maxMemory()/1024/1024+"M");
}
}
