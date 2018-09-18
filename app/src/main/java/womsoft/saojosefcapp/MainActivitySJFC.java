package womsoft.saojosefcapp;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivitySJFC extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_sjfc);

        tabLayout = (TabLayout) findViewById (R.id.tabsMainActivity);
        viewPager = (ViewPager) findViewById (R.id.viewPagesMainActivity);

        getSupportActionBar ().setTitle ("São José FC");
    }

    @Override
    protected void onStart() {
        super.onStart();

        setupViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setupViewPager(ViewPager viewPager) {

        ViewPagerAdapter adapter = new ViewPagerAdapter (getSupportFragmentManager ());
        adapter.addFragment(JogosFragmentSJFC.newInstance(), "Jogos");
        adapter.addFragment(CampeonatoFragmentSJFC.newInstance(), "Campeonatos");
        adapter.addFragment(ElencoFragmentSJFC.newInstance(), "Elenco");
        adapter.addFragment(JogosFragmentSJFC.newInstance(), "História");
        adapter.addFragment(JogosFragmentSJFC.newInstance(), "Parceiros");
        adapter.addFragment(JogosFragmentSJFC.newInstance(), "Notícias");

        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<> ();

        public ViewPagerAdapter(FragmentManager fm) {
            super (fm);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }

}
