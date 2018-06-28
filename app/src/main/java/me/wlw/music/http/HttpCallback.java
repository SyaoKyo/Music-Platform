package me.wlw.music.http;

/**
 * Created by zxy/ztp on 2017/2/8.
 */
public abstract class HttpCallback<T> {
    public abstract void onSuccess(T t);

    public abstract void onFail(Exception e);

    public void onFinish() {
    }
}
