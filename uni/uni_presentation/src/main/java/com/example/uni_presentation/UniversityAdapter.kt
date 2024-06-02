package com.example.uni_presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.common_db.model.University
import com.example.uni_presentation.databinding.UniversityItemBinding


class UniversityAdapter(val listener: RecyclerClickListener) :
    RecyclerView.Adapter<UniversityAdapter.MyViewHolder>() {

    private var list = listOf<University>()

    fun setData(list: List<University>) {
        this.list = list
        notifyItemInserted(this.list.lastIndex)
    }

    inner class MyViewHolder(val viewDataBinding: UniversityItemBinding) :
        RecyclerView.ViewHolder(viewDataBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding =
            UniversityItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.viewDataBinding.apply {
            val item = list[position]
            tvUniName.text = item.name
            tvUniState.text = "${item.stateProvince} ${item.country}"
            root.setOnClickListener {
                listener.onItemClickListener(position, list[position])
            }
        }
    }

    override fun getItemCount(): Int {
        return this.list.size
    }


}

interface RecyclerClickListener {
    fun onItemClickListener(position: Int, item: University)
}