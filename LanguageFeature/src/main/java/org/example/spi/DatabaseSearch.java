package org.example.spi;

import java.util.List;

/**
 * 数据库搜索实现
 *
 * @author chensh
 * @datetime 2024/3/11 7:50 PM
 */
public class DatabaseSearch implements Search{
    @Override
    public List<String> searchDoc(String keyword) {
        System.out.println("数据库搜索：" + keyword);
        return null;
    }
}
