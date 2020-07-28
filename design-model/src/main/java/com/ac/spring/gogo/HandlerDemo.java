package com.ac.spring.gogo;

/**
 * HandlerDemo
 *
 * @author <a href="mailto:yanghui@it.gongmall.com">yanghui</a>
 * @since 2020/7/28
 */
public class HandlerDemo {
    public static void main(String[] args) {
        HandlerHolder handlerHolder = new DefaultHandlerHolder();
        handlerHolder.addHandler(new Handler() {
            public void doHandle() {
                System.out.println("doHandle1");
            }
        }).addHandler(new Handler() {
            public void doHandle() {
                System.out.println("doHandle1");
            }
        }).invoke();
    }
}
