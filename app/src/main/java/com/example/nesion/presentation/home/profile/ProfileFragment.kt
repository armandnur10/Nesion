package com.example.nesion.presentation.home.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.nesion.R
import com.example.nesion.databinding.FragmentProfileBinding
import com.example.nesion.databinding.FragmentSignInBinding
import com.google.firebase.auth.FirebaseAuth


class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding as FragmentProfileBinding

    private lateinit var auth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        auth = FirebaseAuth.getInstance()

        // load data from user
//        auth.currentUser?.let {
//            binding.apply {
//                txtTitleProfile.text = it.displayName
//                txtEmailProfile.text = it.email
//                btnLogOut.setOnClickListener {
//                    auth.signOut()
//                    findNavController().navigate(R.id.action_profileFragment_to_signInFragment)
//                }
//                btnBackProfile.setOnClickListener {
//                    findNavController().navigate(R.id.action_profileFragment_to_homeFragment)
//                }
//            }
//        }

        return binding.root
    }
}