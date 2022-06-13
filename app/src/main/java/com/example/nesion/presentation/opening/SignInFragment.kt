package com.example.nesion.presentation.opening

import android.graphics.Color
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.style.ForegroundColorSpan
import android.text.style.UnderlineSpan
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.nesion.R
import com.example.nesion.databinding.FragmentSignInBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class SignInFragment : Fragment() {

    private var _binding: FragmentSignInBinding? = null
    private val binding get() = _binding as FragmentSignInBinding

    private lateinit var auth: FirebaseAuth


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSignInBinding.inflate(inflater, container, false)
        auth = FirebaseAuth.getInstance()

        Log.i("SignIn", "onCreateView: ${auth.currentUser}")

        // if user logged in
        if(auth.currentUser != null) {
            // then navigate to home
            findNavController().navigate(R.id.action_signInFragment_to_homeFragment)
        }

        val dontHaveAccountBuilder =
            SpannableStringBuilder(getString(R.string.txt_info_sign_up))
        dontHaveAccountBuilder.setSpan(
            ForegroundColorSpan(Color.parseColor("#7455F6")),
            18, // start
            dontHaveAccountBuilder.length, // end
            Spannable.SPAN_EXCLUSIVE_INCLUSIVE
        )
        val forgotPasswordBuilder = SpannableStringBuilder(getString(R.string.txt_forgot_password))
        forgotPasswordBuilder.setSpan(
            UnderlineSpan(), // start
            0,
            forgotPasswordBuilder.length,// end
            Spannable.SPAN_EXCLUSIVE_INCLUSIVE
        )

        binding.apply {
            tvDontHaveAccount.apply {
                text = dontHaveAccountBuilder
                setOnClickListener {
                    findNavController().navigate(R.id.action_signInFragment_to_signUpFragment)
                }
            }
            tvForgotPassword.text = forgotPasswordBuilder

            //btnSignIn -> ke fragment home
            btnSignIn.setOnClickListener {
                val email = edtEmail.text.toString()
                val password = edtPassword.text.toString()

                auth.signInWithEmailAndPassword(email, password).addOnSuccessListener {
                    Log.i("SignIn", "onCreateView: $email $password")
                }
            }

        }
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = auth.currentUser
        updateUi(currentUser)
    }

    fun updateUi(currentUser : FirebaseUser?){

    }

}

//findNavController().navigate(R.id.action_signInFragment_to_homeFragment)