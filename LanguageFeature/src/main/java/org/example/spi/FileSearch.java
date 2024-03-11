package org.example.spi;

import java.util.List;

/**
 * 文件搜索实现
 *
 * @author chensh
 * @datetime 2024/3/11 7:50 PM
 */
public class FileSearch implements Search{
    @Override
    public List<String> searchDoc(String keyword) {
        System.out.println("文件搜索：" + keyword);
        return null;
    }
}
