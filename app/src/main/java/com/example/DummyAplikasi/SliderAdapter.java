package com.example.DummyAplikasi; // ganti sesuai package kamu

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SliderAdapter extends RecyclerView.Adapter<SliderAdapter.SliderViewHolder> {
    private final List<Integer> layoutList;

    public SliderAdapter(List<Integer> layoutList) {
        this.layoutList = layoutList;
    }

    @NonNull
    @Override
    public SliderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(viewType, parent, false);
        return new SliderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SliderViewHolder holder, int position) {
        // tidak perlu isi karena isi layout sudah di-handle di XML
    }

    @Override
    public int getItemCount() {
        return layoutList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return layoutList.get(position);
    }

    public static class SliderViewHolder extends RecyclerView.ViewHolder {
        public SliderViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}