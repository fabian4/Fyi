package com.fabian.Fyi.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.fabian.Fyi.R;

import java.util.List;

public class MsgAdapter extends ArrayAdapter<Message> {

    private int resourceId;

    public MsgAdapter(@NonNull Context context, int resource, @NonNull List<Message> objects) {
        super(context, resource, objects);
        resourceId = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        Message message = getItem(position);
        @SuppressLint("ViewHolder") View view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
        TextView msg = view.findViewById(R.id.msg);
        TextView tag = view.findViewById(R.id.tag);
        TextView detail = view.findViewById(R.id.detail);
        msg.setText(message.getMsg());
        tag.setText(message.getTag());
        detail.setText(message.getDetail());
        return view;
    }
}
