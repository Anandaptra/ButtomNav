package com.example.buttomnav

import FirstFragment
import SecondFragment
import ThirdFragment
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.buttomnav.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val firstFragment = FirstFragment()
        val secondFragment = SecondFragment()
        val thirdFragment = ThirdFragment()

        setFragment(firstFragment)
        setFragment(secondFragment)
        setFragment(thirdFragment)

        binding.bottomNavigationView.setOnNavigationItemReselectedListener{
            when(it.itemId) {
                R.id.home -> setFragment(firstFragment)
                R.id.person -> setFragment(secondFragment)
                R.id.settings -> setFragment(thirdFragment)
            }
            true
        }
    }

    private fun setFragment(fragment : Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragment, fragment)
            commit()
        }
    }
}