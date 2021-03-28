package br.com.hacksmiles.ui.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.hacksmiles.R
import br.com.hacksmiles.data.nome
import br.com.hacksmiles.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {
    lateinit var binding: FragmentProfileBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProfileBinding.inflate(inflater).apply {
            setupView()
        }
        return binding.root
    }

    private fun FragmentProfileBinding.setupView() {
        this.tvHello.text = "Olá $nome !"
    }
}