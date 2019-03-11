package com.jh.design.delegate;

/**
 * @program:
 * @description:
 * @author: lishijia
 * @create: 2019-03-1114:08
 **/
public class CachingExecutor implements IExecutor {

    private IExecutor delegate;
    private boolean useCaching;

    public CachingExecutor(IExecutor executor, boolean useCaching) {
        this.delegate = executor;
        this.useCaching = useCaching;
    }

    @Override
    public Object query() {
        if (useCaching) {
            // get result from cache
            System.out.println("date from cache");
            return null;
        }else{
            System.out.println("not use cache");
        }
        return delegate.query();
    }
}
