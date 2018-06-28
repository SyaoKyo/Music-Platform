package me.wlw.music.utils;

/**
 * Created by wlw on 2018/6/8.
 */
public class ParseUtils {

    public static long parseInt(String s) {
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public static long parseLong(String s) {
        try {
            return Long.parseLong(s);
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}
