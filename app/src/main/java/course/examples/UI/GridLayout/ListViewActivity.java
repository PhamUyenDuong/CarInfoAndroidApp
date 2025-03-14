package course.examples.UI.GridLayout;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.Arrays;
import java.util.List;

public class ListViewActivity extends Activity {
    protected static final String DEALER_ID = "SENDMONEY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listviewlayout);

        String carName = getIntent().getStringExtra(DEALER_ID);
        ListView listView = findViewById(R.id.listView);

        assert carName != null;
        List<String> dealerList = Arrays.asList(getDealersForCar(carName));

        ListViewDealerAdapter adapter = new ListViewDealerAdapter(this, dealerList);
        listView.setAdapter(adapter);
    }


    private String[] getDealersForCar(String carName) {
        int resId = 0;

        switch (carName) {
            case "Cybertruck":
                resId = R.array.subaru;
                break;
            case "Hyundai Ioniq":
                resId = R.array.kia;
                break;
            case "Mini Cooper":
                resId = R.array.jeep;
                break;
            case "Porsche 911":
                resId = R.array.dodge;
                break;
            default:
                resId = R.array.jaguar;
        }

        return getResources().getStringArray(resId);
    }
}
