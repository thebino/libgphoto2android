package de.stuermerbenjamin.sample

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.Observable
import de.stuermerbenjamin.sample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val mainViewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        val viewmodel = mainViewModel
        binding.viewmodel = mainViewModel

        if (savedInstanceState == null) {
            observeAndSave(viewmodel)
        }
    }

    private fun observeAndSave(viewModel: MainViewModel) {
        viewModel.addOnPropertyChangedCallback(object : Observable.OnPropertyChangedCallback() {
            override fun onPropertyChanged(sender: Observable?, propertyId: Int) {
                Log.d("MainActivity", "onPropertyChanged => $propertyId")
            }
        })
    }
}
