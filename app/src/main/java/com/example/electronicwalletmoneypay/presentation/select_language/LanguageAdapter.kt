package com.example.electronicwalletmoneypay.presentation.select_language

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.electronicwalletmoneypay.R
import com.example.electronicwalletmoneypay.databinding.ItemLanguageBinding
import com.example.electronicwalletmoneypay.widget.circle


class LanguageAdapter(
    var context: Context,
    val onItemClick: (LanguageEnum, Int) -> Unit,
    private val languages: List<LanguageEnum>,
    selectedLanguage: LanguageEnum?
) : RecyclerView.Adapter<LanguageAdapter.ViewHolder>() {
    var currentLanguage: LanguageEnum

    init {
        currentLanguage = selectedLanguage ?: LanguageEnum.ENGLISH
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val languageModel = languages[position]
        holder.bind(languageModel, currentLanguage)
        holder.binding.apply {
            languageIconRadio
                .setOnClickListener {
                onItemClick(languageModel, position)
            }
        }
    }

    fun updateCurrentLanguage(languageModel: LanguageEnum, position: Int) {

        val oldPosition = languages.indexOf(currentLanguage)

        if (oldPosition == position) {
            return
        }
        currentLanguage = languageModel
        notifyItemChanged(position)
        if (oldPosition != -1) {
            notifyItemChanged(oldPosition)
        }
    }

    override fun getItemCount(): Int = languages.size

    class ViewHolder(
        val binding: ItemLanguageBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        companion object {
            fun create(parent: ViewGroup): ViewHolder {
                val binding = ItemLanguageBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                return ViewHolder(binding)
            }
        }

        fun bind(language: LanguageEnum, currentLanguage: LanguageEnum) {
            binding.apply {
                val selected = language.code == currentLanguage.code
                root.isSelected = selected
                languageIconRadio.isSelected = selected
                languageTextItemTitle.text = language.title
                if (selected) {
                    val selectedTextColor = binding.root.resources.getColor(R.color.color_red)
                    languageTextItemTitle.setTextColor(selectedTextColor)
                }  else {
                    val unSelectedTextColor = binding.root.resources.getColor(R.color.color_gray3)
                    languageTextItemTitle.setTextColor(unSelectedTextColor)
                }
                languageImageItem.circle(language.icon).into(languageImageItem)
            }
        }
    }
}