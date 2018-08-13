package com.vancat.newframework.ui.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.MenuItem;

import com.vancat.newframework.R;
import com.vancat.newframework.helper.BottomNavigationViewHelper;
import com.vancat.newframework.ui.base.BaseCompatActivity;
import com.vancat.newframework.ui.fragments.book.BookRootFragment;
import com.vancat.newframework.ui.fragments.gank.GankIoRootFragment;
import com.vancat.newframework.ui.fragments.home.HomeRootFragment;
import com.vancat.newframework.ui.fragments.movie.MovieRootFragment;
import com.vancat.newframework.ui.fragments.person.PersonalRootFragment;
import com.vancat.newframework.ui.widgets.MovingImageView;
import com.vancat.newframework.utils.NavigationUtils;

import butterknife.BindView;
import de.hdodenhof.circleimageview.CircleImageView;
import me.yokeyword.fragmentation.SupportFragment;

public class MainActivity extends BaseCompatActivity implements HomeRootFragment.OnOpenDrawerLayoutListener {


    @BindView(R.id.bviv_bar)
    BottomNavigationView bvivBar;
    @BindView(R.id.nv_menu)
    NavigationView nvMenu;
    @BindView(R.id.dl_root)
    DrawerLayout dlRoot;

    //底部五个按钮
    public static final int FIRST = 0;
    public static final int SECOND = 1;
    public static final int THIRD = 2;
    public static final int FOURTH = 3;
    public static final int FIFTH = 4;

    private SupportFragment[] mFragments = new SupportFragment[5];
    private MovingImageView mivMenu;
    private CircleImageView civHead;

    // 再点一次退出程序时间设置
    private static final long WAIT_TIME = 2000L;
    private long TOUCH_TIME = 0;

    /**
     * 初始化视图 这里处理fragment的切换
     * @param savedInstanceState savedInstanceState
     */
    @Override
    protected void initView(Bundle savedInstanceState) {
        nvMenu = findViewById(R.id.nv_menu);
        bvivBar = findViewById(R.id.bviv_bar);
        dlRoot = findViewById(R.id.dl_root);

        if (savedInstanceState == null) {
            mFragments[FIRST] = HomeRootFragment.newInstance();
            mFragments[SECOND] = GankIoRootFragment.newInstance();
            mFragments[THIRD] = MovieRootFragment.newInstance();
            mFragments[FOURTH] = BookRootFragment.newInstance();
            mFragments[FIFTH] = PersonalRootFragment.newInstance();

            loadMultipleRootFragment(R.id.fl_container, FIRST,
                    mFragments[FIRST],
                    mFragments[SECOND],
                    mFragments[THIRD],
                    mFragments[FOURTH],
                    mFragments[FIFTH]);
        } else {
            // 这里库已经做了Fragment恢复,所有不需要额外的处理了, 不会出现重叠问题
            // 这里我们需要拿到mFragments的引用,也可以通过getSupportFragmentManager.getFragments()
            // 自行进行判断查找(效率更高些),用下面的方法查找更方便些
            mFragments[FIRST] = findFragment(HomeRootFragment.class);
            mFragments[SECOND] = findFragment(GankIoRootFragment.class);
            mFragments[THIRD] = findFragment(MovieRootFragment.class);
            mFragments[FOURTH] = findFragment(BookRootFragment.class);
            mFragments[FIFTH] = findFragment(PersonalRootFragment.class);
        }

        NavigationUtils.disableNavigationViewScrollbars(nvMenu);
        mivMenu = nvMenu.getHeaderView(0).findViewById(R.id.miv_menu);
        civHead = nvMenu.getHeaderView(0).findViewById(R.id.civ_head);
        BottomNavigationViewHelper.disableShiftMode(bvivBar);
        bvivBar.setOnNavigationItemSelectedListener(new BottomNavigationView
                .OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_item_home:
                        showHideFragment(mFragments[FIRST]);
                        break;
                    case R.id.menu_item_gank_io:
                        showHideFragment(mFragments[SECOND]);
                        break;
                    case R.id.menu_item_movie:
                        showHideFragment(mFragments[THIRD]);
                        break;
                    case R.id.menu_item_book:
                        showHideFragment(mFragments[FOURTH]);
                        break;
                    case R.id.menu_item_personal:
                        showHideFragment(mFragments[FIFTH]);
                        break;
                }
                return true;
            }
        });
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void onOpen() {
        if (!dlRoot.isDrawerOpen(GravityCompat.START)) {
            dlRoot.openDrawer(GravityCompat.START);
        }
    }
}
