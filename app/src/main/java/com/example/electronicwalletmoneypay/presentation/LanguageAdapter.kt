package com.example.electronicwalletmoneypay.presentation

import android.annotation.SuppressLint

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.electronicwalletmoneypay.R
import com.example.electronicwalletmoneypay.databinding.ItemLanguageBinding
import com.example.electronicwalletmoneypay.presentation.LanguageEnum.*


class LanguageAdapter(val onClickLanguageItem: (LanguageEnum) -> Unit, val currentLocate: String) :
    RecyclerView.Adapter<LanguageAdapter.ViewHolder>() {
    private val languageEnumData = values()

    private var currentIndex = -1
    private var firstCheck = true

    class ViewHolder(val binding: ItemLanguageBinding) : RecyclerView.ViewHolder(binding.root) {
        companion object {
            fun create(parent: ViewGroup): ViewHolder {
                val binding = ItemLanguageBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )
                return ViewHolder(binding)
            }
        }

        fun bind(languageEnum: LanguageEnum) {
            binding.apply {
                languageTextItemTitle.setText(languageEnum.textId)
                languageImageItem.setImageResource(languageEnum.imageId)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.create(parent)
    }
    override fun getItemCount(): Int = values().size
    @SuppressLint("NotifyDataSetChanged")
    override fun onBindViewHolder(holder: ViewHolder, @SuppressLint("RecyclerView") position: Int) {
        val itemIndex = languageEnumData[position]
        holder.bind(itemIndex)
        holder.binding.root.setOnClickListener {
            onClickLanguageItem(itemIndex)
            currentIndex = position
            notifyDataSetChanged()
        }

        val newColorSelected = ContextCompat.getColor(
            holder.binding.languageTextItemTitle.context, R.color.color_selected
        )
        val newColorUnSelect = ContextCompat.getColor(
            holder.binding.languageTextItemTitle.context, R.color.color_gray6
        )

        if (currentIndex == position || (itemIndex.locate == currentLocate && firstCheck)) {
            holder.binding.languageTextItemTitle.setTextColor(newColorSelected)
            holder.binding.languageIconRadio.setImageResource(R.drawable.ic_radio_selected)
            holder.binding.root.isSelected = true
            if (itemIndex.locate == currentLocate) {
                firstCheck = false
            }
        } else {
            holder.binding.languageTextItemTitle.setTextColor(newColorUnSelect)
            holder.binding.languageIconRadio.setImageResource(R.drawable.ic_radio_unselect)
            holder.binding.root.isSelected = false
        }
    }
}