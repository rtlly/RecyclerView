package com.example.recyclerview;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ItemViewHolder extends RecyclerView.ViewHolder {
    private TextView title;
    private TextView description;
    private TextView number;
    private ImageView avatar;
    private View view;
    public ItemViewHolder(@NonNull View itemView) {
        super(itemView);
        view = itemView;
        title = itemView.findViewById(R.id.item_title);
        description = itemView.findViewById(R.id.item_description);
        number = itemView.findViewById(R.id.item_number);
        avatar = itemView.findViewById(R.id.item_avatar);
    }

    public TextView getTitle() {
        return title;
    }

    public TextView getDescription() {
        return description;
    }

    public TextView getNumber() {
        return number;
    }

    public ImageView getAvatar() {
        return avatar;
    }

    public View getView() {
        return view;
    }
}
