package com.example.senthil.kotlin_navigationdrawer

import android.os.Build
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.View.OnClickListener
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.senthil.kotlin_navigationdrawer.adapter.OuterAdapter
import com.example.senthil.kotlin_navigationdrawer.data.topLevelItems
import com.example.senthil.kotlin_navigationdrawer.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationView


class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener,
    OnClickListener {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // setSupportActionBar(binding.childAppBar.toolbar)

        val toggle = ActionBarDrawerToggle(
            this,
            binding.drawerLayout,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        binding.drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        binding.navView.setNavigationItemSelectedListener(this)
        binding.childAppBar.contentMain.ivDrawer.setOnClickListener(this)
        nestedRecyclerView()
    }

    private fun nestedRecyclerView() {
        binding.childAppBar.contentMain.outerRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.childAppBar.contentMain.outerRecyclerView.adapter =
            OuterAdapter(topLevelItems, this)
    }

    override fun onBackPressed() {
        if (binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            binding.drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }


    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.

        binding.drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            binding.childAppBar.contentMain.ivDrawer.id -> {
                binding.drawerLayout.open()
            }
        }
    }


}
