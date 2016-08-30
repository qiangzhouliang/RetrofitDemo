package com.example.qzl.retrofitdemo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.qzl.retrofitdemo.R;
import com.example.qzl.retrofitdemo.bean.Cook;
import com.squareup.picasso.Picasso;

import java.util.Collection;
import java.util.List;

/**
 * Created by Qzl on 2016-08-30.
 */
public class MyAdapter extends BaseAdapter {
    private Context mContext;
    private List<Cook> mList;

    public MyAdapter(Context context, List<Cook> list) {
        this.mContext = context;
        this.mList = list;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return mList.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item, parent, false);
            convertView.setTag(new ViewHolder(convertView));
        }
        ViewHolder holder = (ViewHolder) convertView.getTag();
        Cook cook = mList.get(position);
        holder.mTitle.setText(cook.getName());
        holder.mInfo.setText(cook.getDescription());
        //加载图片
        Picasso.with(mContext).load("http://tnfs.tngou.net/image" + cook.getImg()).into(holder.mImageView);
        return convertView;
    }

    public void addAll(Collection<? extends Cook> collection) {
        mList.addAll(collection);
        notifyDataSetChanged();

    }

    public static class ViewHolder {
        private ImageView mImageView;
        private TextView mInfo, mTitle;

        public ViewHolder(View item) {
            mImageView = (ImageView) item.findViewById(R.id.item_image);
            mInfo = (TextView) item.findViewById(R.id.item_info);
            mTitle = (TextView) item.findViewById(R.id.item_title);
        }
    }
}
