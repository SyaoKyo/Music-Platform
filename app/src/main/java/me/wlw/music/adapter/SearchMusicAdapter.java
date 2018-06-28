package me.wlw.music.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import me.wlw.music.R;
import me.wlw.music.model.SearchMusic;
import me.wlw.music.utils.binding.Bind;
import me.wlw.music.utils.binding.ViewBinder;

/**
 * 搜索结果适配器
 * Created by zxy/ztp on 2018/6/13.
 */
public class SearchMusicAdapter extends BaseAdapter {
    private List<SearchMusic.Song> mData;
    private OnMoreClickListener mListener;

    public SearchMusicAdapter(List<SearchMusic.Song> data) {
        mData = data;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int position) {
        return mData.get(position);
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
        holder.tvTitle.setText(mData.get(position).getSongname());
        holder.tvArtist.setText(mData.get(position).getArtistname());
        holder.ivMore.setOnClickListener(v -> mListener.onMoreClick(position));
        holder.vDivider.setVisibility(isShowDivider(position) ? View.VISIBLE : View.GONE);
        return convertView;
    }

    private boolean isShowDivider(int position) {
        return position != mData.size() - 1;
    }

    public void setOnMoreClickListener(OnMoreClickListener listener) {
        mListener = listener;
    }

    private static class ViewHolder {
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
            ivCover.setVisibility(View.GONE);
        }
    }
}
