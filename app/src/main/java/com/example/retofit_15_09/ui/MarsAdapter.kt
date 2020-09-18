package com.example.retofit_15_09.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.retofit_15_09.R
import com.example.retofit_15_09.model.Terrain
import kotlinx.android.synthetic.main.item_list_view.view.*

class MarsAdapter(val callback: CallbackInterface):RecyclerView.Adapter<MarsAdapter.TerrainViewHolder>() {

    private var terrainList = emptyList<Terrain>()

    fun updateAdapter(mList: List<Terrain>){
         terrainList = mList
        notifyDataSetChanged()
    }

    inner class TerrainViewHolder(itemView: View): RecyclerView.ViewHolder(itemView), View.OnClickListener {
        val itemImg = itemView.imageView
        override fun onClick(p0: View?) {
            callback.passTheData(terrainList[adapterPosition])
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TerrainViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list_view, parent, false)
        return TerrainViewHolder(view)
    }

    override fun onBindViewHolder(holder: TerrainViewHolder, position: Int) {
        Glide.with(holder.itemView.context).load(terrainList[position].imgSrc).into(holder.itemImg)
    }

    override fun getItemCount() = terrainList.size

    interface CallbackInterface {
        fun passTheData(terrain: Terrain)
    }

}