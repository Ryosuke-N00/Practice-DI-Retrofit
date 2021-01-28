package com.example.ryousuke.practice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    //アクティビティの初期化を遅らせる理由→onSupportNavigateUpに画面遷移したことを伝えるため
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //どのフラグメントが遷移を含むアクティビティであるかを伝える
        navController = findNavController(R.id.navHostFragment)

        //さらにここで目的地を決める
        val appBarConfiguration = AppBarConfiguration(
            setOf(R.id.recipeFragment,
                R.id.favoriteFragment,
                R.id.jokeFragment)
        )

        //ボトムナビゲーションを含むアクティビティを与える
        bottomNavigationView.setupWithNavController(navController)
        //ここでメニューを押したときに画面遷移が対応する→ここで押したところに移動する
        setupActionBarWithNavController(navController,appBarConfiguration)
    }

    //ここで遷移が起きたかを判断している
    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}