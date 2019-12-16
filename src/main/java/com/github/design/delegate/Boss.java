package com.github.design.delegate;


/**
 * 功能描述:  老板
 * @author: qinxuewu
 * @date: 2019/12/10 16:59
 * @since 1.0.0
 */
public class Boss {

    public void command(String command,Leader leader){
        leader.doing(command);
    }
}
