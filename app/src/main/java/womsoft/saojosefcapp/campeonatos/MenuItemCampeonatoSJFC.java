package womsoft.saojosefcapp.campeonatos;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import womsoft.saojosefcapp.CampeonatoFragmentSJFC;
import womsoft.saojosefcapp.ElencoFragmentSJFC;
import womsoft.saojosefcapp.JogosFragmentSJFC;
import womsoft.saojosefcapp.MainActivitySJFC;
import womsoft.saojosefcapp.R;

/**
 * Created by Willian.Matos on 30/03/2018.
 */

public class MenuItemCampeonatoSJFC extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.menu_item_campeonato_sjfc);

        tabLayout = (TabLayout) findViewById (R.id.tabsMenuItemCampeonato);
        viewPager = (ViewPager) findViewById (R.id.viewPagesMenuItemCampeonato);

        getSupportActionBar ().setTitle ("São José FC");
    }

    private void setupViewPager(ViewPager viewPager) {

        MenuItemCampeonatoSJFC.ViewPagerAdapter adapter = new MenuItemCampeonatoSJFC.ViewPagerAdapter(getSupportFragmentManager ());
        adapter.addFragment(JogosFragmentSJFC.newInstance(), "Tabela");
        adapter.addFragment(JogosFragmentSJFC.newInstance(), "Jogos");
        adapter.addFragment(ElencoFragmentSJFC.newInstance(), "Elenco");
        adapter.addFragment(JogosFragmentSJFC.newInstance(), "Localização");

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
