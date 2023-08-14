package com.udacity.shoestore.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {
    private lateinit var binding:FragmentLoginBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        // Inflate(create) the layout for this fragment
        binding =
            DataBindingUtil.inflate(inflater,
                R.layout.fragment_login, container,
                false)

        binding.emailEt.setText("")

        //set the onclicklistener for signup btn
        binding.signupBtn.setOnClickListener {view:View ->
            //checks if email is empty
            if(binding.emailEt.text.toString().isNotEmpty()){
                //validates to check for a valid email address
                if(!android.util.Patterns.EMAIL_ADDRESS.matcher(binding.emailEt.text).matches()){
                    Toast.makeText(context, "Please enter valid email", Toast.LENGTH_LONG).show()
                }else{
                    //checks if password is empty
                    if(binding.passwordEt.text.toString().isNotEmpty()){
                        Toast.makeText(context, "You've signed up!", Toast.LENGTH_SHORT).show()
                        view.findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment())
                    }else{
                        Toast.makeText(context, "Please enter password", Toast.LENGTH_SHORT).show()
                    }
                }
            }
            else{
                Toast.makeText(context, "Please enter email", Toast.LENGTH_SHORT).show()
            }
        }

        //set the onclicklistener for login btn
        binding.loginBtn.setOnClickListener {view:View ->
            if(binding.emailEt.text.toString().isNotEmpty()){
                if(!android.util.Patterns.EMAIL_ADDRESS.matcher(binding.emailEt.text).matches()){
                    Toast.makeText(context, "Please enter valid email", Toast.LENGTH_SHORT).show()
                }else{
                    if(binding.passwordEt.text.toString().isNotEmpty()){
                        //checks if correct authentication details are being entered
                        if(binding.emailEt.text.toString() == "padmakn7@gmail.com" && binding.passwordEt.text.toString() == "123456"){
                            Toast.makeText(context, "You've successfully logged in!", Toast.LENGTH_SHORT).show()
                            view.findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment())

                        }

                        else{
                            Toast.makeText(context, "Please enter correct password", Toast.LENGTH_SHORT).show()

                        }

                    }else{
                        Toast.makeText(context, "Please enter password", Toast.LENGTH_LONG).show()
                    }
                }

            }
            else{
                Toast.makeText(context, "Please enter email", Toast.LENGTH_LONG).show()
            }

        }

        return binding.root
    }


    override fun onPause() {
        binding.emailEt.setText("")
        binding.passwordEt.setText("")
        super.onPause()
    }
}