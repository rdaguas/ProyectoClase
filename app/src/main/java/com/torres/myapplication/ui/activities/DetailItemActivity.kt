package com.torres.myapplication.ui.activities

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import com.torres.myapplication.R
import com.torres.myapplication.data.network.entities.oneNews.OneNewsDataClass
import com.torres.myapplication.databinding.ActivityDetailItemBinding
import com.torres.myapplication.logic.usercases.GetOneNewsUserCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DetailItemActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailItemBinding
    private var itemId: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailItemBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        intent.extras.let {
//            itemId = it?.getString("id").toString()
//        }
//
//        lifecycleScope.launch(Dispatchers.Main) {
//
//            val item = withContext(Dispatchers.IO) {
//                getData()
//            }
//
//            if (item != null) {
//                binding.txtIdItem.text = item.title
//            }
//        }
    }


    suspend fun getData(): OneNewsDataClass? {
        var item: OneNewsDataClass? = null
        val x = GetOneNewsUserCase().invoke(itemId)
        x.onSuccess {
            item = it
        }
        x.onFailure {
            Log.d("API", "El llamado a la Api Fallo")
        }
        return item
    }

}