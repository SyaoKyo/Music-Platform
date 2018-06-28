package me.wlw.music.application;

import android.app.Application;
import android.content.Intent;

import me.wlw.music.service.PlayService;
import me.wlw.music.storage.db.DBManager;

/**
 * 自定义Application
 * Created by wlw on 2018/6/27.
 */
public class MusicApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        AppCache.get().init(this);
        ForegroundObserver.init(this);
        DBManager.get().init(this);

        Intent intent = new Intent(this, PlayService.class);
        startService(intent);
    }
}
