package app.daeng.tokped;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import app.daeng.tokped.Adapters.ViewPagerAdapter;
import app.daeng.tokped.Fragments.FourthFragment;
import app.daeng.tokped.Fragments.HomeFragment;
import app.daeng.tokped.Fragments.SecondFragment;
import app.daeng.tokped.Fragments.ThirdFragment;
import app.daeng.tokped.Utils.SlidingTabLayout;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.toolbar_main)
    Toolbar toolbarMain;

    @BindView(R.id.tab_main)
    SlidingTabLayout tabMain;

    @BindView(R.id.vpg_main)
    ViewPager viewPagerMain;

    final int CART_AMOUNT = 4;

    private void initializeComponent() {
        setSupportActionBar(toolbarMain);
        setupTabLayout(viewPagerMain);
        tabMain.setDistributeEvenly(true);
        tabMain.setViewPager(viewPagerMain);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        initializeComponent();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu, menu);

        MenuItem menuItem = menu.findItem(R.id.mn_cart);
        menuItem.setIcon(buildCounterDrawable(CART_AMOUNT, R.drawable.ic_tokped));

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.mn_cart:
                Toast.makeText(this, "Ada " + CART_AMOUNT + " Belanjaan di Keranjang.", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void setupTabLayout(ViewPager v) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new HomeFragment(), "HOME");
        adapter.addFragment(new SecondFragment(), "SECOND");
        adapter.addFragment(new ThirdFragment(), "THIRD");
        adapter.addFragment(new FourthFragment(), "FOURTH");
        v.setAdapter(adapter);
    }

    private Drawable buildCounterDrawable(int count, int backgroundImageId) {
        LayoutInflater inflater = LayoutInflater.from(this);
        View view = inflater.inflate(R.layout.custom_notification_icon, null);
        view.setBackgroundResource(backgroundImageId);

        if (count == 0) {
            View counterTextPanel = view.findViewById(R.id.counterValuePanel);
            counterTextPanel.setVisibility(View.GONE);
        } else {
            TextView textView = (TextView) view.findViewById(R.id.txt_cart_count);
            textView.setText("" + count);
        }

        view.measure(
                View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED),
                View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED));
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());

        view.setDrawingCacheEnabled(true);
        view.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);
        Bitmap bitmap = Bitmap.createBitmap(view.getDrawingCache());
        view.setDrawingCacheEnabled(false);

        return new BitmapDrawable(getResources(), bitmap);
    }
}
