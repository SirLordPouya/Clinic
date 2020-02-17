package ir.apptune.clinic.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import ir.apptune.clinic.DataModels.CareListDataModel;
import ir.apptune.clinic.R;

/**
 * Created by Pouya on 01/12/2016.
 */

public class CareListAdapter extends BaseAdapter {
    List<CareListDataModel.ListBean> model;
    Context mContext;

    public CareListAdapter(List<CareListDataModel.ListBean> model, Context mContext) {
        this.model = model;
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return model.size();
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
        View rowView = LayoutInflater.from(mContext).inflate(R.layout.care_list_listview_item,viewGroup,false);
        TextView txtTitleCareList = (TextView) view.findViewById(R.id.txt_title_care_list);
        ImageView imgCareList = (ImageView) view.findViewById(R.id.img_care_list);

        txtTitleCareList.setText(model.get(i).getTitle());
        Picasso.with(mContext).load(model.get(i).getPhoto()).into(imgCareList);

        return rowView;
    }
}
