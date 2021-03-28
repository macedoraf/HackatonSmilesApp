package br.com.hacksmiles.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import br.com.hacksmiles.BR


abstract class DataBindingAdapter(private val entries: MutableList<Any> = mutableListOf()) :
    RecyclerView.Adapter<DataBindingAdapter.BindingViewHolder>(), BindableAdapter<Any> {

    abstract var onClick: ((position: Int) -> Unit)?

    abstract fun getLayoutId(): Int

    private fun getObject(position: Int): Any {
        return entries[position]
    }

    override fun getItemCount(): Int = entries.size

    override fun onBindViewHolder(holder: BindingViewHolder, position: Int) {
        holder.bind(getObject(position))
        holder.itemView.setOnClickListener { onClick?.invoke(position) }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BindingViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding =
            DataBindingUtil.inflate<ViewDataBinding>(inflater, getLayoutId(), parent, false)
        return BindingViewHolder(binding)
    }

    override fun setData(data: List<Any>) {
        entries.clear()
        entries.addAll(data)
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