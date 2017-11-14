package test.studenthelpdesk;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import static android.R.drawable.ic_menu_delete;

/**
 * Created by steven on 11/11/2017.
 */

public class customAdapter extends ArrayAdapter<String> {


    public customAdapter(Context context, String[] locs) {
        super(context, R.layout.custom_row, locs);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflator = LayoutInflater.from(getContext());
        View customeview = inflator.inflate(R.layout.custom_row, parent, false);

        String singleloc = getItem(position);
        TextView locView = (TextView) customeview.findViewById(R.id.locationView);


        locView.setText(singleloc);

        return customeview;

      /*  trash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                delete(location);

            }
        });*/
    }
}
