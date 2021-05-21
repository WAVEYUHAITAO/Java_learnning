package com.javastudy.base;

/**
 * @author haitao
 * @version 1.0
 * @since 1.8
 */
public class Doc {
    String name;

    /**
     * @author haitao
     * @param name
     * @return
     * @throws Exception
     */
    public String test(String name){
        return name;
    }
    //用命令行生成javadoc
    //javadoc -encoding UTF-8 -charset UTF-8 Doc.java
}
