package com.mohit.navdrawer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import android.widget.Toolbar
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    lateinit var nav:NavigationView
    lateinit var toggle: ActionBarDrawerToggle
    lateinit var drawerLayout: DrawerLayout
    lateinit var toolbar: androidx.appcompat.widget.Toolbar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        toolbar=findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        nav=findViewById(R.id.navmenu)
        drawerLayout=findViewById(R.id.drawer)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        toggle=ActionBarDrawerToggle(this, drawerLayout,R.string.open,R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        nav.setNavigationItemSelectedListener { menuItem ->
            menuItem.isChecked = true
            drawerLayout.closeDrawers()
            when (menuItem.itemId) {

                R.id.profile -> {
                    Toast.makeText(this, "Profile", Toast.LENGTH_LONG).show()
                    drawerLayout.closeDrawer(GravityCompat.START)
                }
                R.id.logout -> {
                    Toast.makeText(this, "Logout", Toast.LENGTH_LONG).show()
                    drawerLayout.closeDrawer(GravityCompat.START)

                }
                R.id.downloads -> {
                    Toast.makeText(this, "Downloads", Toast.LENGTH_LONG).show()
                    drawerLayout.closeDrawer(GravityCompat.START)

                }
                R.id.home -> {
                    Toast.makeText(this, "Home", Toast.LENGTH_LONG).show()
                    drawerLayout.closeDrawer(GravityCompat.START)

                }
            }


            true
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                drawerLayout.openDrawer(GravityCompat.START)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
    }



