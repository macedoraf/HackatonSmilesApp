package br.com.hacksmiles

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView


abstract class DataBindingAdapter(private val entries: MutableList<Any>) :
    RecyclerView.Adapter<DataBindingAdapter.BindingViewHolder>() {

    abstract fun getLayoutId(): Int

    private fun getObject(position: Int): Any {
        return entries[position]
    }

    override fun onBindViewHolder(holder: BindingViewHolder, position: Int) {
        holder.bind(getObject(position))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BindingViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding =
            DataBindingUtil.inflate<ViewDataBinding>(inflater, getLayoutId(), parent, false)
        return BindingViewHolder(binding)
    }

    fun setData(vararg entry: Any) {
        entries.clear()
        entries.add(entry)
        notifyDataSetChanged()
    }

    class BindingViewHolder(private val binding: ViewDataBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(obj: Any) {
            binding.setVariable(BR.obj, obj)
            binding.executePendingBindings()
        }
    }
}