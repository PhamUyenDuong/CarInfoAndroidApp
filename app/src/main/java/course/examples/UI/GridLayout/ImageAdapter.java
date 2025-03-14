package course.examples.UI.GridLayout;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ImageAdapter extends BaseAdapter {
    private static final int PADDING = 8;

    private Context mContext;
    private List<Integer> mThumbIds;
    private List<String> mNames;

    public ImageAdapter(Context context, List<Integer> images) {
        this.mContext = context;
        this.mThumbIds = images;
    }

    @Override
    public int getCount() {
        return mThumbIds.size();
    }

    public void setNames(List<String> names) {
        this.mNames = names;
        notifyDataSetChanged();
    }

    @Override
    public long getItemId(int position) {
        return mThumbIds.get(position);
    }

    @Override
    public Object getItem(int position) {
        return mThumbIds.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;

        if (view == null) {
            LayoutInflater inflater = LayoutInflater.from(mContext);
            view = inflater.inflate(R.layout.item, parent, false);
        }

        ImageView imageView = view.findViewById(R.id.imageView);

        imageView.setPadding(PADDING, PADDING, PADDING, PADDING);
        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);

        TextView textView = view.findViewById(R.id.textView);

        imageView.setImageResource(mThumbIds.get(position));
        textView.setText(mNames.get(position));

        return view;
    }
}
