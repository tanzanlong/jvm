package com.tan.performance.param;

import java.util.Vector;

/**-Xmx5M 设置最大堆 -Xms5M 设置最小堆 -verbose:gc
 * 
 * -Xmx5M -Xms5M -verbose:gc
 * 
 * @author tan
 *
 */
public class XmxParamSample {
 public static void main(String[] args) {
    Vector v=new Vector();
    for (int i = 0; i < 10; i++) {
        byte[]b=new byte[1024*1024];
        v.add(b);
        System.out.println(i+"M is allocated");
    }
    System.out.println("Max memory:"+Runtime.getRuntime().maxMemory()/1024/1024+"M");
}
}
