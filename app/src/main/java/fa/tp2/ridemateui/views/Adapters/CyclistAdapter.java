package fa.tp2.ridemateui.views.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import fa.tp2.ridemateui.R;
import fa.tp2.ridemateui.model.Cyclist;

/**
 * Created by User on 2015/09/19.
 */
public class CyclistAdapter extends ArrayAdapter<Cyclist> {

    private Cyclist[] values;
    public CyclistAdapter(Context context, int resource, Cyclist[] values) {

        super(context, resource, values);
        this.values = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;

        if(view == null){
            LayoutInflater layoutInflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.cyclist_list_view, null);
        }
        TextView txtName = (TextView) view.findViewById(R.id.txtName);
        TextView txtSurname = (TextView) view.findViewById(R.id.txtSurname);
        TextView txtAge = (TextView) view.findViewById(R.id.txtAge);
        txtName.setText(values[position].getName());
        txtSurname.setText(values[position].getLatName());
        txtAge.setText(values[position].getAge());
        return view;
    }
}
