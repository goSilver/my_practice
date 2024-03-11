package org.example.spi;

import java.util.List;

/**
 * 定义一个内容搜索接口，搜索的实现可能是基于文件系统的搜索，也可能是基于数据库的搜索。
 *
 * @author chensh
 * @datetime 2024/3/11 7:48 PM
 */
public interface Search {
    public List<String> searchDoc(String keyword);
}
