package com.example.retofit_15_09.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.retofit_15_09.R
import com.example.retofit_15_09.model.Terrain
import com.example.retofit_15_09.viewmodel.MarsViewModel
import kotlinx.android.synthetic.main.fragment_first.*

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment(), MarsAdapter.CallbackInterface {
    //1- declaro variable del viewmodel
    lateinit var mViewModel: MarsViewModel
    lateinit var adapter: MarsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //2- Asigno el viewmodel a esta vista
        mViewModel = ViewModelProvider(this).get(MarsViewModel::class.java)
        adapter = MarsAdapter(this)
    }


    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = recyclerView
        recyclerView.layoutManager = GridLayoutManager(context,2)
        recyclerView.adapter = adapter

        //3. Observo la funcion que retornara LiveData desde el viewModel
        mViewModel.exposeLiveDataFromDatabase().observe(viewLifecycleOwner, Observer {
            Log.d("VIEW", it.toString())
            adapter.updateAdapter(it)
        })

        //    findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
    }

    override fun passTheData(terrain: Terrain) {
        TODO("Not yet implemented")
    }
}