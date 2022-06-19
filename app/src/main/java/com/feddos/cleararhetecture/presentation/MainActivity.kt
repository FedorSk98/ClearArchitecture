package com.feddos.cleararhetecture.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.feddos.cleararhetecture.R
import com.feddos.cleararhetecture.app.App
import com.feddos.cleararhetecture.data.repository.UserRepositoryImpl
import com.feddos.cleararhetecture.data.storage.SharedPrefUserStorage
import com.feddos.cleararhetecture.domain.models.SaveUserName
import com.feddos.cleararhetecture.domain.usercase.GetUserNameUseCase
import com.feddos.cleararhetecture.domain.usercase.SaveUserNameUseCase

class MainActivity : AppCompatActivity() {

    // region Элементы экрана
    private lateinit var resultText: TextView
    private lateinit var editText: EditText
    private lateinit var saveTextBtn: Button
    private lateinit var getTextBtn: Button
    // endregion
    private lateinit var viewModel: MainViewModel

    @javax.inject.Inject
    lateinit var vmFactory: MainViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        (applicationContext as App).appComponent.inject(this)

        editText = findViewById(R.id.editSaveText)
        saveTextBtn = findViewById(R.id.saveDataBtn)
        getTextBtn = findViewById(R.id.getDataBtn)
        resultText = findViewById(R.id.dataResultText)


        viewModel = ViewModelProvider(this,
            vmFactory).get(MainViewModel::class.java)

        saveTextBtn.setOnClickListener{
             viewModel.save(editText.text.toString())
        }

        getTextBtn.setOnClickListener{
          viewModel.load()
        }

        viewModel.resultLive.observe(this) {
            resultText.text = it
        }
    }
}