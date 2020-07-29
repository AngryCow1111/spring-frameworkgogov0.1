package com.ac.spring.gogo;


import java.util.ArrayList;
import java.util.List;

/**
 * DefaultHandlerHolder
 *
 * @author <a href="mailto:yanghui@it.gongmall.com">yanghui</a>
 * @since 2020/7/28
 */
public class DefaultHandlerHolder implements HandlerHolder {

    private List<Handler> handlerList = new ArrayList<Handler>();

    public HandlerHolder addHandler(Handler handler) {
        handlerList.add(handler);
        return this;
    }

    public void invoke() {
        for (Handler handler : handlerList) {
            HandlerInvoker handlerInvoker = handler1 -> handler1.doHandle();
            handlerInvoker.invoke(handler);

        }
    }


}
