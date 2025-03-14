package course.examples.UI.GridLayout;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class GridLayoutActivity extends AppCompatActivity {

    protected static final String EXTRA_RES_ID = "POS";
    protected static final String DEALER_ID = "SENDMONEY";

    private final ArrayList<Integer> carThumbnails = new ArrayList<>(
            Arrays.asList(R.drawable.subaru, R.drawable.kia,
                    R.drawable.jeep, R.drawable.dodge,
                    R.drawable.jaguar, R.drawable.mercedes,
                    R.drawable.lincoln, R.drawable.mazda));

    private final ArrayList<String> mNamesFlowers = new ArrayList<>(
            Arrays.asList("Subaru Ascent", "Kia K5",
                    "Jeep Wagoneer S", "Dodge Charger Daytona",
                    "Jaguar EV", "Mercedes-Benz GLE Coupe",
                    "Lincoln Aviator", "Mazda CX-90"));

    private final Map<Integer, Runnable> menuActions = new HashMap<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        GridView gridview = findViewById(R.id.gridview);
        ImageAdapter adapter = new ImageAdapter(this, carThumbnails);
        gridview.setAdapter((adapter));
        adapter.setNames(mNamesFlowers);

        setupItemClickListener(gridview);
        registerForContextMenu(gridview);
    }

    private void setupItemClickListener(GridView gridview) {
        gridview.setOnItemClickListener((parent, v, position, id) -> {
            Intent intent = new Intent(GridLayoutActivity.this, ImageViewActivity.class);
            intent.putExtra(EXTRA_RES_ID, carThumbnails.get(position));
            startActivity(intent);
        });
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.contextmenu, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        int position = info.position;

        setupMenuActions(position);

        Runnable action = menuActions.get(item.getItemId());
        if (action != null) {
            action.run();
            return true;
        }

        return false;
    }

    private void setupMenuActions(int position) {
        menuActions.clear();

        menuActions.put(R.id.submenu_1, () -> openImageViewActivity(position));
        menuActions.put(R.id.submenu_2, () -> openManufacturerWebsite(position));
        menuActions.put(R.id.submenu_3, () -> openDealerListActivity(position));
    }

    private void openImageViewActivity(int position) {
        Intent imageIntent = new Intent(GridLayoutActivity.this, ImageViewActivity.class);
        imageIntent.putExtra(EXTRA_RES_ID, carThumbnails.get(position));
        startActivity(imageIntent);
    }

    private void openManufacturerWebsite(int position) {
        String url = getManufacturerUrl(carThumbnails.get(position));
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(browserIntent);
    }

    private void openDealerListActivity(int position) {
        Intent dealerIntent = new Intent(GridLayoutActivity.this, ListViewActivity.class);
        dealerIntent.putExtra(DEALER_ID, mNamesFlowers.get(position));
        startActivity(dealerIntent);
    }

    private String getManufacturerUrl(int imageResId) {
        Map<Integer, String> urlMap = new HashMap<>();
        urlMap.put(R.drawable.subaru, "https://www.subaru.com/vehicles/ascent.html");
        urlMap.put(R.drawable.kia, "https://www.kia.com/us/en/k5");
        urlMap.put(R.drawable.jeep, "https://www.jeep.com/wagoneer/wagoneer-s.html");
        urlMap.put(R.drawable.dodge, "https://www.dodge.com/charger.html");
        urlMap.put(R.drawable.jaguar, "https://www.jaguarusa.com/all-models/i-pace/index.html");
        urlMap.put(R.drawable.mercedes, "https://www.mbusa.com/en/vehicles/class/gle/coupe/type-amg?sd_campaign_type=Search&sd_digadprov=Resolution&sd_campaign=Corporate_Google_US_Search_Brand_TEV&sd_channel=GOOGLE&sd_adid=Brand_TEV_SUV_AMG+GLE+Coupe&sd_digadkeyword=mercedes+benz+gle+coupe&gclsrc=aw.ds&gad_source=1&gbraid=0AAAAADtPev8kKhpPegneHwGpOD6MKr7_K&gclid=Cj0KCQiAoJC-BhCSARIsAPhdfSi8nzeG2wHwBRxqOMLeUWIIJobTR7rNkXzZCO1V7tNu7f0gqOnI-YIaAnhTEALw_wcB");
        urlMap.put(R.drawable.lincoln, "https://www.lincoln.com/luxury-suvs/aviator/?searchid=20943500370%7C163057987132%7C310513645802%7C&searchid=20943500370%7C163057987132%7Ckwd-310513645802&fcid=pse_20943500370_google&ef_id=Cj0KCQiAoJC-BhCSARIsAPhdfSjOolycVVd3oDnkIImsFJsyV9JH6dylp2qkRog5LPfShbraWJ7SnHoaAgzvEALw_wcB:G:s&s_kwcid=AL!2519!3!687968830735!b!!g!!lincoln%20aviator&gclsrc=aw.ds&gad_source=1&gclid=Cj0KCQiAoJC-BhCSARIsAPhdfSjOolycVVd3oDnkIImsFJsyV9JH6dylp2qkRog5LPfShbraWJ7SnHoaAgzvEALw_wcB");
        urlMap.put(R.drawable.mazda, "https://www.mazdausa.com/vehicles/cx-90?semid=142040832605&providertag=MazdaSEM&servicetag=142040832605&k_keyword=mazda%20cx%2090&k_matchtype=e&gclsrc=aw.ds&gad_source=1&gbraid=0AAAAADuNVTDK3fjfNSJS7_n5DKLc3kdes&gclid=Cj0KCQiAoJC-BhCSARIsAPhdfSig3M6VugHDlHjtC2GelMXaOA1eJR5bt9JSSFAYdgFXNrFN6WhICEgaAhN7EALw_wcB");
        return urlMap.getOrDefault(imageResId, "https://www.google.com");
    }
}