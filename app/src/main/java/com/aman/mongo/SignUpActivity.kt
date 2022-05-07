package com.aman.mongo

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.aman.mongo.databinding.ActivitySignUpBinding
import com.aman.mongo.model.SignUpModel
import com.aman.mongo.network.SignUpEndPoint
import com.aman.mongo.network.SignupClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignUpActivity : AppCompatActivity() {
     lateinit var binding:ActivitySignUpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val view = ActivitySignUpBinding.inflate(layoutInflater)
        binding =view
        setContentView(view.root)

        binding.signupButton.setOnClickListener {
            val name = binding.name.text.toString()
            val email = binding.email.text.toString()
            val pass = binding.pass.text.toString()

            postData(name,email,pass)
        }
    }

    private fun postData(name: String, email: String, pass: String) {

        val retrofit = SignupClient().getInstance().create(SignUpEndPoint::class.java)

        val model = SignUpModel(name,email,pass)

        val call = retrofit.sendUser(model)

        val temp = Temp(binding)

         call.enqueue(temp)

        binding.email.setText("")
        binding.pass.setText("")
        binding.name.setText("")
    }

}
private class Temp(val binding:ActivitySignUpBinding):Callback<SignUpModel> {
    override fun onResponse(call: Call<SignUpModel>, response: Response<SignUpModel>) {
        val model = response.body()!!

        binding.tv.text = model.toString()
    }

    override fun onFailure(call: Call<SignUpModel>, t: Throwable) {

    }
}


