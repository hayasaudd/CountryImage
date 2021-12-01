package com.example.android.marsphotos.overview
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.android.marsphotos.databinding.GridViewItemBinding
import com.example.android.marsphotos.network.ConntryPhoto
import com.example.android.marsphotos.network.photoResposmodul


class PhotoGridAdapter : ListAdapter<ConntryPhoto,
        PhotoGridAdapter.ContryPhotoViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PhotoGridAdapter.ContryPhotoViewHolder {
        return ContryPhotoViewHolder(GridViewItemBinding.inflate(
            LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: PhotoGridAdapter.ContryPhotoViewHolder, position: Int) {
        val contrypho = getItem(position)
        holder.bind(contrypho)
    }
    class ContryPhotoViewHolder(private var binding:
                                GridViewItemBinding
    ):
        RecyclerView.ViewHolder(binding.root) {
        fun bind(conntryPhotolist : ConntryPhoto) {
            binding.photo = conntryPhotolist
            binding.executePendingBindings()
        }
    }
    companion object DiffCallback : DiffUtil.ItemCallback<ConntryPhoto>() {
        override fun areContentsTheSame(oldItem: ConntryPhoto, newItem: ConntryPhoto): Boolean {
           return oldItem.name == newItem.name
        }

        override fun areItemsTheSame(oldItem: ConntryPhoto, newItem: ConntryPhoto): Boolean {
            return oldItem.flag == newItem.flag
        }


    }
}