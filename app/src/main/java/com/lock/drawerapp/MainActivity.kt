package com.lock.drawerapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.core.view.GravityCompat
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.google.android.material.navigation.NavigationView
import com.lock.drawerapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding= ActivityMainBinding.inflate(LayoutInflater.from(this))
        val view=binding.root
        setContentView(view)

        val navviiew=findViewById<NavigationView>(R.id.nav_drawer)
        val navcontroller =this.findNavController(R.id.fragment)
        navviiew.itemIconTintList=null
        NavigationUI.setupWithNavController(navviiew,navcontroller)
        navcontroller.addOnDestinationChangedListener{ controller,desination,arguments ->
            binding.txtCustom.text = desination.label
        }
        binding.imgMenu.setOnClickListener{
            binding.drawerLayout.openDrawer(GravityCompat.START)
        }
    }
}