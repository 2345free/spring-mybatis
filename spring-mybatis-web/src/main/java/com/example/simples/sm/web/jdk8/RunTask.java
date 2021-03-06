package com.example.simples.sm.web.jdk8;

public interface RunTask {

    /**
     * 静态方法(util method)
     *
     * @param str
     * @return
     */
    static String run(String str) {
        return str;
    }

    ;

    /**
     * 默认实现
     */
    default void run() {
        System.out.println("default");
    }

    ;

}
