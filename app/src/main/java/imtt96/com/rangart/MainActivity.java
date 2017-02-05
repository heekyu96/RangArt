package imtt96.com.rangart;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private AppBarLayout appBarLayout;
    private ViewPagerAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager=(ViewPager) findViewById(R.id.main_view_pager);
        tabLayout=(TabLayout)findViewById(R.id.main_tab);
        appBarLayout=(AppBarLayout)findViewById(R.id.main_appbar);

        List<Fragment> views=new ArrayList<>();
        views.add(new ShowOwnPiece());


        adapter=new ViewPagerAdapter(getSupportFragmentManager(),views);
        viewPager.setAdapter(adapter);

        appBarLayout.setBackground(new ColorDrawable(Color.parseColor("#FFFFFF")));
        tabLayout.setupWithViewPager(viewPager);
    }

    private class ViewPagerAdapter extends FragmentStatePagerAdapter{
        private List<Fragment> items;

        public ViewPagerAdapter(FragmentManager fragmentManager,List<Fragment> list){
            super(fragmentManager);

            if(list==null) throw new IllegalArgumentException("Item Must Not Be NULL");
            this.items=list;
        }
        @Override
        public int getItemPosition(Object object) {
//            if (object instanceof EtcTab) {
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

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "달리미";
                case 1:
                    return "부르미";
                case 2:
                    return "ETC";
                default:
                    return "dafault";
            }
        }
    }
}
