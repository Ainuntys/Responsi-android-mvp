package com.example.mvp.view;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.mvp.Network.Data;
import com.example.mvp.R;

import java.util.Collections;
import java.util.List;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.DataAdapterViewHolder> {
    private List<Data> peopleList;

    DataAdapter() {
        this.dataList = Collections.emptyList();
    }

    @NonNull
    @Override public PeopleAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemPeopleBinding itemPeopleBinding =
                DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_people,
                        parent, false);
        return new PeopleAdapterViewHolder(itemPeopleBinding);
    }

    @Override public void onBindViewHolder(PeopleAdapterViewHolder holder, int position) {
        holder.bindPeople(peopleList.get(position));
    }

    @Override public int getItemCount() {
        return peopleList.size();
    }

    void setPeopleList(List<People> peopleList) {
        this.peopleList = peopleList;
        notifyDataSetChanged();
    }

    static class PeopleAdapterViewHolder extends RecyclerView.ViewHolder {
        ItemPeopleBinding mItemPeopleBinding;

        PeopleAdapterViewHolder(ItemPeopleBinding itemPeopleBinding) {
            super(itemPeopleBinding.itemPeople);
            this.mItemPeopleBinding = itemPeopleBinding;
        }

        void bindPeople(People people) {
            if (mItemPeopleBinding.getPeopleViewModel() == null) {
                mItemPeopleBinding.setPeopleViewModel(
                        new ItemPeopleViewModel(people, itemView.getContext()));
            } else {
                mItemPeopleBinding.getPeopleViewModel().setPeople(people);
            }
        }
    }
}
