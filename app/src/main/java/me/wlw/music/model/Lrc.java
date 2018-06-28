package me.wlw.music.model;

import com.google.gson.annotations.SerializedName;

/**
 * JavaBean
 * Created by zxy/ztp on 2018/6/13.
 */
public class Lrc {
    @SerializedName("lrcContent")
    private String lrcContent;

    public String getLrcContent() {
        return lrcContent;
    }

    public void setLrcContent(String lrcContent) {
        this.lrcContent = lrcContent;
    }
}
