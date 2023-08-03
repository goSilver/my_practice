package org.example.b.behavioral.a.proxy;

import cn.hutool.json.JSONUtil;

/**
 * 指标收集器
 *
 * @author goku
 * @datetime 2023/8/3 10:03 PM
 */
public class MetricsCollector {
    /**
     * 记录请求，打印指标信息
     *
     * @param requestInfo 请求信息
     */
    public void recordRequest(RequestInfo requestInfo) {
        System.out.println(JSONUtil.toJsonPrettyStr(requestInfo));
    }
}
