package course.examples.UI.GridLayout;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class ListViewDealerAdapter extends BaseAdapter {
    private Context mContext;
    private List<String> mDealers;

    public ListViewDealerAdapter(Context context, List<String> dealers) {
        this.mContext = context;
        this.mDealers = dealers;
    }

    @Override
    public int getCount() {
        return mDealers.size();
    }

    @Override
    public Object getItem(int position) {
        return mDealers.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position; // Using position as unique ID
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;

        if (view == null) {
            LayoutInflater inflater = LayoutInflater.from(mContext);
            view = inflater.inflate(R.layout.listitem, parent, false);
        }

        // Populate the dealer name into the TextView
        TextView dealerText = view.findViewById(R.id.textView);
        dealerText.setText(mDealers.get(position));

        return view;
    }
}