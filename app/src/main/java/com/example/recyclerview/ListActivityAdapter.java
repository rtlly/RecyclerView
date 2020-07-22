package com.example.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import static com.example.recyclerview.Data.TYPE_HEADER;

public class ListActivityAdapter extends RecyclerView.Adapter {
    private List<Data> dataSet;

    public ListActivityAdapter(List<Data> dataSet) {
        this.dataSet = dataSet;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        if (viewType == TYPE_HEADER) {
            view = layoutInflater.inflate(R.layout.header, parent, false);
            return new HeaderViewHolder(view);
        }
        view = layoutInflater.inflate(R.layout.item, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder.getItemViewType() == TYPE_HEADER) {
            HeaderViewHolder headerViewHolder = (HeaderViewHolder) holder;
            headerViewHolder.getHeader().setText(dataSet.get(position).getTitle());
        } else {
            ItemViewHolder itemViewHolder = (ItemViewHolder) holder;
            itemViewHolder.getTitle().setText(dataSet.get(position).getTitle());
            itemViewHolder.getDescription().setText(dataSet.get(position).getDescription());
            itemViewHolder.getNumber().setText(String.valueOf(dataSet.get(position).getNumber()));
        }
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    @Override
    public int getItemViewType(int position) {
        return dataSet.get(position).getType();
    }
}
