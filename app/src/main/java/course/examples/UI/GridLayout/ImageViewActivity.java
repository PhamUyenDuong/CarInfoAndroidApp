package course.examples.UI.GridLayout;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;

public class ImageViewActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();

        ImageView imageView = new ImageView(getApplicationContext());


        imageView.setImageResource(intent.getIntExtra(GridLayoutActivity.EXTRA_RES_ID, 0));

        setContentView(imageView);

        int imagesID = intent.getIntExtra(GridLayoutActivity.EXTRA_RES_ID, 0);

        imageView.setOnClickListener(v -> {
            String manufactureLink = "";
            if (imagesID == R.drawable.subaru){
                manufactureLink = "https://www.subaru.com/vehicles/ascent.html";
            }
            else if (imagesID == R.drawable.kia){
                manufactureLink = "https://www.kia.com/us/en/k5";
            }
            else if (imagesID == R.drawable.jeep){
                manufactureLink = "https://www.jeep.com/wagoneer/wagoneer-s.html";
            }
            else if (imagesID == R.drawable.dodge){
                manufactureLink = "https://www.dodge.com/charger.html";
            }
            else if (imagesID == R.drawable.jaguar){
                manufactureLink = "https://www.jaguarusa.com/all-models/i-pace/index.html";
            }
            else if (imagesID == R.drawable.mercedes){
                manufactureLink = "https://www.mbusa.com/en/vehicles/class/gle/coupe/type-amg?sd_campaign_type=Search&sd_digadprov=Resolution&sd_campaign=Corporate_Google_US_Search_Brand_TEV&sd_channel=GOOGLE&sd_adid=Brand_TEV_SUV_AMG+GLE+Coupe&sd_digadkeyword=mercedes+benz+gle+coupe&gclsrc=aw.ds&gad_source=1&gbraid=0AAAAADtPev8kKhpPegneHwGpOD6MKr7_K&gclid=Cj0KCQiAoJC-BhCSARIsAPhdfSi8nzeG2wHwBRxqOMLeUWIIJobTR7rNkXzZCO1V7tNu7f0gqOnI-YIaAnhTEALw_wcB";
            }
            else if (imagesID == R.drawable.lincoln){
                manufactureLink = "https://www.lincoln.com/luxury-suvs/aviator/?searchid=20943500370%7C163057987132%7C310513645802%7C&searchid=20943500370%7C163057987132%7Ckwd-310513645802&fcid=pse_20943500370_google&ef_id=Cj0KCQiAoJC-BhCSARIsAPhdfSjOolycVVd3oDnkIImsFJsyV9JH6dylp2qkRog5LPfShbraWJ7SnHoaAgzvEALw_wcB:G:s&s_kwcid=AL!2519!3!687968830735!b!!g!!lincoln%20aviator&gclsrc=aw.ds&gad_source=1&gclid=Cj0KCQiAoJC-BhCSARIsAPhdfSjOolycVVd3oDnkIImsFJsyV9JH6dylp2qkRog5LPfShbraWJ7SnHoaAgzvEALw_wcB";
            }
            else manufactureLink = "https://www.mazdausa.com/vehicles/cx-90?semid=142040832605&providertag=MazdaSEM&servicetag=142040832605&k_keyword=mazda%20cx%2090&k_matchtype=e&gclsrc=aw.ds&gad_source=1&gbraid=0AAAAADuNVTDK3fjfNSJS7_n5DKLc3kdes&gclid=Cj0KCQiAoJC-BhCSARIsAPhdfSig3M6VugHDlHjtC2GelMXaOA1eJR5bt9JSSFAYdgFXNrFN6WhICEgaAhN7EALw_wcB";

            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(manufactureLink));
            startActivity(browserIntent);
        });
    }
}