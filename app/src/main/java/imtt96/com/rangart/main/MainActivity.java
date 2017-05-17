package imtt96.com.rangart.main;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import imtt96.com.rangart.global.Global;
import imtt96.com.rangart.R;
import imtt96.com.rangart.main.scheduler.Scheduler;
import imtt96.com.rangart.main.show.ShowOwnPiece;

public class MainActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private AppBarLayout appBarLayout;
    private ViewPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = (ViewPager) findViewById(R.id.main_view_pager);
        tabLayout = (TabLayout) findViewById(R.id.main_tab);
        appBarLayout = (AppBarLayout) findViewById(R.id.main_appbar);

        List<Fragment> views = new ArrayList<>();
        views.add(new Scheduler());
        views.add(new ShowOwnPiece());


        adapter = new ViewPagerAdapter(getSupportFragmentManager(), views);
        viewPager.setAdapter(adapter);

        appBarLayout.setBackground(new ColorDrawable(Color.parseColor("#FFFFFF")));
        tabLayout.setupWithViewPager(viewPager);

        for (int i = 0; i < tabLayout.getTabCount(); i++) {
            switch (i) {
                case 0:
                    tabLayout.getTabAt(i).setIcon(R.mipmap.scheduler_icon);
                    break;
                case 1:
                    tabLayout.getTabAt(i).setIcon(R.mipmap.show_own);
                    break;
                case 2:
                    tabLayout.getTabAt(i).setIcon(R.mipmap.own_page_icon);
                    break;
            }
        }
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        ImageView imageView = (ImageView) findViewById(R.id.show_card_image);
//        Log.d("Test",String.valueOf(imageView.getWidth()));
        Global.getInstance().setWantHeight(imageView.getWidth());
//        Log.d("Test2",String.valueOf(Global.getInstance().getWantHeight()));
    }

    private class ViewPagerAdapter extends FragmentStatePagerAdapter {
        private List<Fragment> items;

        public ViewPagerAdapter(FragmentManager fragmentManager, List<Fragment> list) {
            super(fragmentManager);

            if (list == null) throw new IllegalArgumentException("Item Must Not Be NULL");
            this.items = list;
        }

        @Override
        public int getItemPosition(Object object) {
//            if (object instanceof ShowOwnPiece) {
//                return POSITION_NONE;
//            } else {
//                return super.getItemPosition(object);
//            }
            return POSITION_NONE;
        }

        @Override
        public Fragment getItem(int position) {
            return items.get(position);
        }

        @Override
        public int getCount() {
            return items.size();
        }
    }
}
