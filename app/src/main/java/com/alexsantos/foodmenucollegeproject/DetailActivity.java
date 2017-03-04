package com.alexsantos.foodmenucollegeproject;

        import android.graphics.drawable.Drawable;
        import android.os.Bundle;
        import android.support.v7.app.AppCompatActivity;
        import android.widget.ImageView;
        import android.widget.TextView;
        import android.widget.Toast;

        import com.alexsantos.foodmenucollegeproject.model.Product;
        import com.alexsantos.foodmenucollegeproject.sample.SampleDataProvider;


        import java.io.IOException;
        import java.io.InputStream;
        import java.text.NumberFormat;
        import java.util.Locale;

@SuppressWarnings("FieldCanBeLocal")
public class DetailActivity extends AppCompatActivity {

    private TextView tvName, tvDescription, tvPrice;
    private ImageView itemImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        String itemId = getIntent().getExtras().getString(DataProductAdapter.ITEM_ID_KEY);
        Toast.makeText(getApplicationContext(),"Item ID: "+itemId, Toast.LENGTH_LONG).show();
        Product item = SampleDataProvider.dataItemMap.get(itemId);
        Toast.makeText(getApplicationContext(),"Item: "+item, Toast.LENGTH_LONG).show();

        /*Product item = SampleDataProvider.dataItemMap.get(itemId);

        tvName = (TextView) findViewById(R.id.tvItemName);
        tvPrice = (TextView) findViewById(R.id.tvPrice);
        tvDescription = (TextView) findViewById(R.id.tvDescription);
        itemImage = (ImageView) findViewById(R.id.itemImage);

        tvName.setText(item.getProductName());
        tvDescription.setText(item.getDescription());

        NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.ITALY);
        tvPrice.setText(nf.format(item.getPrice()));

        InputStream inputStream = null;
        try {
            String imageFile = item.getImage();
            inputStream = getAssets().open(imageFile);
            Drawable d = Drawable.createFromStream(inputStream, null);
            itemImage.setImageDrawable(d);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }*/
    }
}
