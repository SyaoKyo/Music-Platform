package me.wlw.music.executor;

/**
 * Created by zxy/ztp on 2018/6/20.
 */
public interface IExecutor<T> {
    void execute();

    void onPrepare();

    void onExecuteSuccess(T t);

    void onExecuteFail(Exception e);
}
