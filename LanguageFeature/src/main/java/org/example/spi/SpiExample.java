package org.example.spi;

import java.util.ServiceLoader;

/**
 * SPI机制思想：
 * 接口的实现由provider实现，provider只用在提交的jar包里的META-INF/services下根据平台定义的接口新建文件，并添加进相应的实现类内容就好。
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
