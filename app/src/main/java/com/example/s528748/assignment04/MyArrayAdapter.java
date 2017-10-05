package com.example.s528748.assignment04;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by S528748 on 10/4/2017.
 */

public class MyArrayAdapter extends ArrayAdapter {

    /**
     * Constructor
     *
     * @param context            The current context.
     * @param resource           The resource ID for a layout file containing a layout to use when
     *                           instantiating views.
     * @param textViewResourceId The id of the TextView within the layout resource to be populated
     * @param objects            The objects to represent in the ListView.
     */
    public MyArrayAdapter(@NonNull Context context, @LayoutRes int resource, @IdRes int textViewResourceId, @NonNull List<Event> objects) {

        super(context, resource, textViewResourceId, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        int arr[] = new int[20];
        int j = -10;
        for(int i = 0; i < 20; i++){
            arr[i] = j ;
            j++;
        }
        View v = super.getView(position, convertView, parent);
        TextView tv1 = (TextView) v.findViewById(R.id.textView1);
        TextView tv2 = (TextView) v.findViewById(R.id.textView2);
        TextView tv3 = (TextView) v.findViewById(R.id.textView3);
        Event e = (Event) getItem(position);

        tv1.setText(e.getName());
        tv2.setText(e.getCount() + "");
        //e.setRating();
        tv3.setText(e.getRating() + "");

        return v;


    }
}
