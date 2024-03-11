package org.example.spi;

import java.util.ServiceLoader;

/**
 * SPI机制思想：
 * 接口的实现由provider实现，provider只用在提交的jar包里的META-INF/services下根据平台定义的接口新建文件，并添加进相应的实现类内容就好。
 * <p>
 * SPI机制的缺陷：
 * 1、不能按需加载，需要遍历所有的实现，并实例化，然后在循环中才能找到我们需要的实现。如果不想用某些实现类，或者某些类实例化很耗时，它也被载入并实例化了，这就造成了浪费。
 * 2、获取某个实现类的方式不够灵活，只能通过 Iterator 形式获取，不能根据某个参数来获取对应的实现类。
 * 3、多个并发多线程使用 ServiceLoader 类的实例是不安全的。
 *
 * @author chensh
 * @datetime 2024/3/11 7:52 PM
 */
public class SpiExample {
    public static void main(String[] args) {
        // ServiceLoader.load(Search.class)在加载某接口时，会去META-INF/services下找接口的全限定名文件，再根据里面的内容加载相应的实现类。
        ServiceLoader<Search> serviceList = ServiceLoader.load(Search.class);
        for (Search searchService : serviceList) {
            searchService.searchDoc("这是一段关键字");
        }
    }
}
