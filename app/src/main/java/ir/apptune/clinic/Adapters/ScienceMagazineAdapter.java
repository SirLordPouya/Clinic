package ir.apptune.clinic.Adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import ir.apptune.clinic.DataModels.ScienceMagazineDataModel;
import ir.apptune.clinic.R;

/**
 * Created by Pouya on 29/11/2016.
 */

public class ScienceMagazineAdapter extends BaseAdapter {

    Context mContext;
    List<ScienceMagazineDataModel.ListBean> magazineList;

    public ScienceMagazineAdapter(Context mContext, List<ScienceMagazineDataModel.ListBean> magazineList) {
        this.mContext = mContext;
        this.magazineList = magazineList;
    }

    @Override
    public int getCount() {
        return magazineList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
       View rowView = LayoutInflater.from(mContext).inflate(R.layout.science_magazin_listview_item,viewGroup,false);
        TextView txtTitleScienceMagazine = (TextView) rowView.findViewById(R.id.txt_title_science_magazine);
        ImageView imgScienceMagazine = (ImageView) rowView.findViewById(R.id.img_science_magazine);
        Log.d("LOG",magazineList.get(i).getTitle()+" ");
        txtTitleScienceMagazine.setText(magazineList.get(i).getTitle());
        Picasso.with(mContext).load(magazineList.get(i).getPhoto()).into(imgScienceMagazine);
        return rowView;
    }
}
