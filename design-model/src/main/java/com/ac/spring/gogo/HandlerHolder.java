package com.ac.spring.gogo;

/**
 * HandlerHolder
 *
 * @author <a href="mailto:yanghui@it.gongmall.com">yanghui</a>
 * @since 2020/7/28
 */
public interface HandlerHolder {

    HandlerHolder addHandler(Handler handler);

    void invoke();
}
