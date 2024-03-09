package org.example.generic;

import java.util.Arrays;

/**
 * @author chensh
 * @datetime 2024/3/6 6:01 PM
 */
public class GenericClassTest {
    public static void main(String[] args) {
        GenericClassTest gct = new GenericClassTest();
        MysqlConnInfo mysqlConnInfo = new MysqlConnInfo("127.0.0.1", "3306");
        doSomething(new Conn<MysqlConnInfo>(mysqlConnInfo){});

    }

    private static <T> void doSomething(Conn<T> conn) {
        System.out.println(conn.t.getClass().getGenericSuperclass());
        System.out.println(Arrays.toString(conn.t.getClass().getClasses()));
        System.out.println(Arrays.toString(conn.t.getClass().getDeclaredClasses()));
        System.out.println(Arrays.toString(conn.t.getClass().getDeclaredFields()));
    }




}
class Conn<T> {
    T t;

    Conn(T t) {
        this.t = t;
    }
}
class MysqlConnInfo {
    String host;
    String port;

    MysqlConnInfo(String host, String port) {
        this.host = host;
        this.port = port;
    }
}
