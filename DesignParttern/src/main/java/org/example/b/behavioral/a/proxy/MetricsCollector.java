package org.example.b.behavioral.a.proxy;

import cn.hutool.json.JSONUtil;

/**
 * @author goku
 * @datetime 2023/8/3 10:03 PM
 */
public class MetricsCollector {
    public void recordRequest(RequestInfo requestInfo) {
        System.out.println(JSONUtil.toJsonPrettyStr(requestInfo));
    }
}
