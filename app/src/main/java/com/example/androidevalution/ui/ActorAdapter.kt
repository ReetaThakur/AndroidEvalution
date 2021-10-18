package com.example.androidevalution.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.androidevalution.R
import com.example.androidevalution.databinding.ActivityMainBinding
import com.example.androidevalution.responseData.ResponseModelItem

class ActorAdapte:PagingDataAdapter<ResponseModelItem, ActorAdapte.ActorViewHolder>(diffUtil){

    private lateinit var binding:ActivityMainBinding

    companion object{
        val diffUtil=object :DiffUtil.ItemCallback<ResponseModelItem>(){
            override fun areItemsTheSame(
                oldItem: ResponseModelItem,
                newItem: ResponseModelItem,
            ): Boolean {
                return oldItem.id==newItem.id
            }

            override fun areContentsTheSame(
                oldItem: ResponseModelItem,
                newItem: ResponseModelItem,
            ): Boolean {
                return oldItem.equals(newItem)
            }

        }
    }

    override fun onBindViewHolder(holder: ActorViewHolder, position: Int) {
       val response=getItem(position)
        response.let {
            if (it!=null){
                holder.setData(it)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActorViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.item_layout,parent,false)
        return ActorViewHolder(view)
    }


    class ActorViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        val image=itemView.findViewById<ImageView>(R.id.actorImage)
        val actorName=itemView.findViewById<TextView>(R.id.actorName)
        val countryName=itemView.findViewById<TextView>(R.id.txtCountryName)
        val countryCode=itemView.findViewById<TextView>(R.id.countryCode)
        val countryZone=itemView.findViewById<TextView>(R.id.countryZone)
        val birthdate=itemView.findViewById<TextView>(R.id.birthdate)
        val deathDate=itemView.findViewById<TextView>(R.id.deathdate)
        fun setData(response: ResponseModelItem){
            try {
              if (response.image.original!=null)  Glide.with(image).load(response.image.original).into(image)
              if (response.name!=null)  actorName.text="Actor Name = ${response.name}"
                if (response.country.name!=null) countryName.text="Country=${response.country.name}"
                if (response.country.code!=null) countryCode.text="Code=${response.country.code}"
                if (response.country.timezone!=null) countryZone.text="TimeZone=${response.country.timezone}"
                if (response.birthday!= null) birthdate.text="BirthDate=${response.birthday}"
                if (response.deathday!=null) deathDate.text="DeathDate=${response.deathday}"

            }catch (e:Exception){
               e.message
            }
        }
    }
}