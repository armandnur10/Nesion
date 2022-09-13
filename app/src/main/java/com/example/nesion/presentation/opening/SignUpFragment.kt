package com.example.nesion.presentation.opening

import android.graphics.Color
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.style.ForegroundColorSpan
import android.util.Patterns
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.nesion.R
import com.example.nesion.databinding.FragmentSignUpBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.UserProfileChangeRequest

class SignUpFragment : Fragment() {

    private var _binding: FragmentSignUpBinding? = null
    private val binding get() = _binding as FragmentSignUpBinding

    private lateinit var auth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSignUpBinding.inflate(inflater, container, false)
        auth = FirebaseAuth.getInstance()

        val alreadyHaveAccountBuilder =
            SpannableStringBuilder(getString(R.string.txt_already_have_account))

        alreadyHaveAccountBuilder.setSpan(
            ForegroundColorSpan(Color.parseColor("#7455F6")),
            alreadyHaveAccountBuilder.indexOf("login"), // start
            alreadyHaveAccountBuilder.length, // end
            Spannable.SPAN_EXCLUSIVE_INCLUSIVE
        )

//        binding.apply {
//            tvAlreadyHaveAccount.apply {
//                text = alreadyHaveAccountBuilder
//                setOnClickListener {
//                    findNavController().navigate(R.id.action_signUpFragment_to_signInFragment)
//                }
//            }
//
//            btnSignUp.setOnClickListener {
//                signUpUser()
//            }
//        }


        // Inflate the layout for this fragment
        return binding.root
    }

    private fun signUpUser(){
        binding.apply {
            if (edtName.text.toString().isEmpty()){
                edtName.error = "Tolong masukan nama"
                edtName.requestFocus()
                return
            }

            if (edtEmail.text.toString().isEmpty()){
                edtEmail.error = "Tolong masukan Email"
                edtEmail.requestFocus()
                return
            }

            if (!Patterns.EMAIL_ADDRESS.matcher(edtEmail.text.toString()).matches()){
                edtEmail.error = "Tolong masukan Email"
                edtEmail.requestFocus()
                return
            }

            if (edtPassword.text.toString().isEmpty()){
                edtPassword.error = "Tolong masukan nama"
                edtPassword.requestFocus()
                return
            }

//            auth.createUserWithEmailAndPassword(edtEmail.text.toString(), edtPassword.text.toString())
//                .addOnCompleteListener() { task ->
//                    if (task.isSuccessful) {
//                        auth.currentUser?.let {
//                            val profileUpdates = UserProfileChangeRequest.Builder()
//                                .setDisplayName(binding.edtName.text.toString())
//                                .build()
//                            it.updateProfile(profileUpdates).addOnSuccessListener {
//                                findNavController().navigate(R.id.action_signUpFragment_to_signInFragment)
//                            }
//                        }
//                    } else {
//                        Toast.makeText(context, "Sign Up failed.",
//                            Toast.LENGTH_SHORT).show()
//                    }
//                }
        }
    }

}