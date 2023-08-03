package org.example.b.behavioral.a.proxy;

import lombok.*;

/**
 * @author goku
 * @datetime 2023/8/3 10:04 PM
 */
@Getter
@Setter
@AllArgsConstructor
@ToString
public class RequestInfo {
    private String apiName;
    private double responseTime;
    private long startupTimestamp;
}
