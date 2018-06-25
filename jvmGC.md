https://plumbr.io/handbook/garbage-collection-algorithms-implementations

老年带  Incremental  年轻代  Incremental   jvm参数采用-Xincgc

老年带  Serial  年轻代  Serial   jvm参数采用	-XX:+UseSerialGC

老年带  Parallel Old  年轻代  Parallel Scavenge   jvm参数采用	-XX:+UseParallelGC -XX:+UseParallelOldGC

老年带  CMS  年轻代  Serial   jvm参数采用	-XX:-UseParNewGC -XX:+UseConcMarkSweepGC


老年带  CMS  年轻代  Parallel New   jvm参数采用	-XX:+UseParNewGC -XX:+UseConcMarkSweepGC

老年带    年轻代  G1   jvm参数采用		jvm参数采用 -XX:+UseG1GC


串行GC（Serial GC）

     串行收集器使用年轻代用标记复制算法 。顾名思义，这些收集器都是单线程收集器，无法并行处理手头的任务。这两个收集器还会触发停止世界暂停，停止所有应用程序线程。

 这种GC算法不能充分利用现代硬件中的多CPU服务器。独立于可用内核的数量，JVM在垃圾回收期间仅使用一个内核。

通过在JVM启动脚本中指定单个参数来为年轻一代和旧一代启用此收集器：

java -XX：+ UseSerialGC com.mypackages.MyExecutableClass
这个选项是有意义的，并且只推荐用于具有几百兆字节堆大小的JVM，运行在具有单个CPU的环境中。对于大多数服务器端部署来说，这是一个罕见的组合。大多数服务器端部署是在具有多个内核的平台上完成的，本质上意味着通过选择串行GC，您可以设置对系统资源使用的人为限制。这会导致闲置的资源，否则可能会用于减少延迟或增加吞吐量。

现在让我们回顾一下使用串行GC时垃圾收集器日志的样子，以及可以从中获得哪些有用的信息。为此，我们使用以下参数在JVM上启用了GC日志记录：

-XX：+ PrintGCDetails -XX：+ PrintGCDateStamps -XX：+ PrintGCTimeStamps

