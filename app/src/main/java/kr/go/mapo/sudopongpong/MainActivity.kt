package kr.go.mapo.sudopongpong
import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils.replace
import android.view.MenuItem
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentTransaction
import com.bumptech.glide.Glide
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kr.go.mapo.sudopongpong.fragment.BoardFragment
import kr.go.mapo.sudopongpong.fragment.HomeFragment
import kr.go.mapo.sudopongpong.fragment.MapFragment


class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //하단바
        bottom_nvg.setOnNavigationItemSelectedListener(this)
        bottom_nvg.selectedItemId = R.id.nvg_main

        //툴바
        setSupportActionBar(findViewById(R.id.toolbar))
        val noActionBar = supportActionBar!!
        noActionBar.setDisplayShowTitleEnabled(false)

        //퐁퐁이
        Glide.with(this).load(R.raw.gif_bg).into(bg_main)
        Glide.with(this).load(R.raw.gif_pongpong_basic).into(pongpong_main)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nvg_main -> {
                val transaction = supportFragmentManager.beginTransaction()
                transaction.replace(R.id.frame_nvg, HomeFragment())
                transaction.commit()
                return true
            }
            R.id.nvg_map -> {
                val transaction = supportFragmentManager.beginTransaction()
                transaction.replace(R.id.frame_nvg, MapFragment())
                transaction.commit()
                return true
            }
            R.id.nvg_board -> {
                val transaction = supportFragmentManager.beginTransaction()
                transaction.replace(R.id.frame_nvg, BoardFragment())
                transaction.commit()
                return true

            }
        }
        return false
    }
}

