package com.epicodus.lifestock.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.epicodus.lifestock.R;
import com.epicodus.lifestock.model.Siting;

import java.util.ArrayList;

/**
 * Created by oem on 11/4/15.
 */
public class ListAdapter extends BaseAdapter{
    private Context mContext;
    private ArrayList<Siting>mSitings;

    public ListAdapter(Context context, ArrayList<Siting> sitings) {
        mSitings = sitings;
        mContext = context;
    }

    @Override
    public int getCount() {
        return mSitings.size();
    }

    @Override
    public Object getItem(int position) {
        return mSitings.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.single_listing, null);
            holder = new ViewHolder();
            holder.species = (TextView) convertView.findViewById(R.id.speciesText);
            holder.location = (TextView)convertView.findViewById(R.id.locationText);
            holder.notes = (TextView)convertView.findViewById(R.id.notesText);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Siting siting = mSitings.get(position);

        holder.species.setText(siting.getSpecies());
        holder.location.setText(siting.getLocation());
        holder.notes.setText(siting.getNotes());

        return convertView;
    }

    private static class ViewHolder {
        TextView species;
        TextView location;
        TextView notes;
    }

}
