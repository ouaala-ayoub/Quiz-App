package com.example.autofilala.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import com.example.autofilala.*
import com.example.autofilala.databinding.ActivityAppBinding

class AppActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAppBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        binding = ActivityAppBinding.inflate(layoutInflater)

        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        //by default
        goToSeriesFragment()

        binding.seriesRv.setOnClickListener{
            //call the fragment associated
            goToSeriesFragment()
        }
        binding.experimentalRv.setOnClickListener {
            //call the fragment associated
            goToExperimentalFragment()
        }
        binding.explanationRv.setOnClickListener {
            //call the fragment associated
            goToExplanationFragment()
        }
        binding.theoryRv.setOnClickListener {
            //call the fragment associated
            goToTheoryFragment()
        }
        binding.routeSignsRv.setOnClickListener {
            //call the fragment associated
            goToRouteSignsFragment()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.settings_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle item selection
        return when (item.itemId) {
            R.id.settings ->{
                showSettingsDialog()
                true
            }
            R.id.update_app ->{
                updateApp()
                true
            }
            R.id.update_res ->{
                updateRes()
                true
            }
            R.id.share_app ->{
                shareApp()
                true
            }
            R.id.delete_temp ->{
                deleteTemp()
                true
            }
            R.id.download_pdf ->{
                downloadPdf()
                true
            }
            //
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun goToExperimentalFragment() {
        val experimentalFragment = ExperimentalFragment()
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment_container, experimentalFragment)
            commit()
        }
    }

    private fun goToSeriesFragment(){
        val seriesFragment = SeriesFragment()
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment_container, seriesFragment)
            commit()
        }
    }

    private fun goToExplanationFragment(){
        val explanationFragment = ExplanationFragment()
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment_container, explanationFragment)
            commit()
        }
    }

    private fun goToTheoryFragment(){
        val theoryFragment = TheoryFragment()
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment_container, theoryFragment)
            commit()
        }
    }

    private fun goToRouteSignsFragment(){
        val routeSignFragment = RouteSignsFragment()
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment_container, routeSignFragment)
            commit()
        }
    }

    private fun downloadPdf() {

    }

    private fun deleteTemp() {

    }

    private fun shareApp() {

    }

    private fun updateRes() {

    }

    private fun updateApp() {

    }

    private fun showSettingsDialog() {

    }
}