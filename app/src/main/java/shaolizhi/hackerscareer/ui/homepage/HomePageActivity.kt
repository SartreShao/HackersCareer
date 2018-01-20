package shaolizhi.hackerscareer.ui.homepage

import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.NavigationView
import android.support.design.widget.Snackbar
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import android.view.View
import kotlinx.android.synthetic.main.activity_home_page.*
import kotlinx.android.synthetic.main.app_bar_home_page.*
import shaolizhi.hackerscareer.R
import shaolizhi.hackerscareer.ui.base.BaseActivity

class HomePageActivity : BaseActivity(),
        NavigationView.OnNavigationItemSelectedListener, HomePageContract.View {

    //Views
    private val toolBar: Toolbar = home_page_act_toolbar
    private val floatButton: FloatingActionButton = home_page_act_floatingactionbutton
    private val drawerLayout: DrawerLayout = home_page_act_drawerlayout
    private val navigationView: NavigationView = home_page_act_navigationview

    //click event
    private fun clickFloatButton(view: View) {
        Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
    }

    //for presenter
    override fun setUpView() {
        setSupportActionBar(toolBar)

        floatButton.setOnClickListener { view ->
            clickFloatButton(view)
        }

        val toggle = ActionBarDrawerToggle(this, drawerLayout, toolBar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        navigationView.setNavigationItemSelectedListener(this)
    }

    //BaseActivity
    override fun layoutId(): Int {
        return R.layout.activity_home_page
    }

    //BaseActivity
    override fun created(bundle: Bundle?) {
    }

    //BaseActivity
    override fun resumed() {

    }

    //后退按钮与抽屉菜单的联动
    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    //创建Toolbar上的菜单
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.home_page, menu)
        return true
    }

    //添加Toolbar上菜单的点击事件
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    //抽屉菜单中的点击事件
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_camera -> {

            }
            R.id.nav_gallery -> {

            }
            R.id.nav_slideshow -> {

            }
            R.id.nav_manage -> {

            }
            R.id.nav_share -> {

            }
            R.id.nav_send -> {

            }
        }

        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }
}
