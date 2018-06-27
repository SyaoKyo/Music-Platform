package me.wlw.music.adapter;

import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import me.wlw.music.R;
import me.wlw.music.model.Music;
import me.wlw.music.service.AudioPlayer;
import me.wlw.music.utils.CoverLoader;
import me.wlw.music.utils.FileUtils;
import me.wlw.music.utils.binding.Bind;
import me.wlw.music.utils.binding.ViewBinder;

/**
 * 本地音乐列表适配器
 * Created by wlw on 2015/11/27.
 */
public class PlaylistAdapter extends BaseAdapter {
    private List<Music> musicList;
    private OnMoreClickListener listener;
    private boolean isPlaylist;

    public PlaylistAdapter(List<Music> musicList) {
        this.musicList = musicList;
    }

    public void setIsPlaylist(boolean isPlaylist) {
        this.isPlaylist = isPlaylist;
    }

    public void setOnMoreClickListener(OnMoreClickListener listener) {
        this.listener = listener;
    }

    @Override
    public int getCount() {
        return musicList.size();
    }

    @Override
    public Object getItem(int position) {
        return musicList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(me.wlw.music.R.layout.view_holder_music, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.vPlaying.setVisibility((isPlaylist && position == AudioPlayer.get().getPlayPosition()) ? View.VISIBLE : View.INVISIBLE);
        Music music = musicList.get(position);
        Bitmap cover = CoverLoader.get().loadThumb(music);
        holder.ivCover.setImageBitmap(cover);
        holder.tvTitle.setText(music.getTitle());
        String artist = FileUtils.getArtistAndAlbum(music.getArtist(), music.getAlbum());
        holder.tvArtist.setText(artist);
        holder.ivMore.setOnClickListener(v -> {
            if (listener != null) {
                listener.onMoreClick(position);
            }
        });
        holder.vDivider.setVisibility(isShowDivider(position) ? View.VISIBLE : View.GONE);
        return convertView;
    }

    private boolean isShowDivider(int position) {
        return position != musicList.size() - 1;
    }

    private static class ViewHolder {
        @Bind(me.wlw.music.R.id.v_playing)
        private View vPlaying;
        @Bind(me.wlw.music.R.id.iv_cover)
        private ImageView ivCover;
        @Bind(me.wlw.music.R.id.tv_title)
        private TextView tvTitle;
        @Bind(me.wlw.music.R.id.tv_artist)
        private TextView tvArtist;
        @Bind(me.wlw.music.R.id.iv_more)
        private ImageView ivMore;
        @Bind(me.wlw.music.R.id.v_divider)
        private View vDivider;

        public ViewHolder(View view) {
            ViewBinder.bind(this, view);
        }
    }
}
