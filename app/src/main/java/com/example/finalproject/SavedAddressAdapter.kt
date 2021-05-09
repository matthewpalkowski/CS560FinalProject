package com.example.finalproject

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.finalproject.databaseobjects.AddressEntity
import com.squareup.picasso.Picasso

class SavedAddressAdapter(private val addressList : List<AddressEntity>) :
    RecyclerView.Adapter<SavedAddressAdapter.AddressHolder>() {

    class AddressHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val imgAddressThumbnail: ImageView = itemView.findViewById(R.id.imgAddressThumnail)
        val txtStreetAddress : TextView = itemView.findViewById(R.id.txtStreetAddress)
        val txtCity : TextView = itemView.findViewById(R.id.txtCity)
        val txtState : TextView = itemView.findViewById(R.id.txtState)
        val txtCountryAndZip : TextView = itemView.findViewById(R.id.txtCountryAndZip)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AddressHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.saved_address,parent,false)
        return AddressHolder(view)
    }

    //FIXME needs to be changed to match the database objects, not SavedAddressItem
    override fun onBindViewHolder(holder: AddressHolder, position: Int) {
        val currentItem = addressList[position]
        holder.txtStreetAddress.text = currentItem.streetAddress
        holder.txtCity.text = currentItem.city
        holder.txtState.text = currentItem.state

        val stringBuilder = StringBuilder()
        stringBuilder.append(currentItem.country)
        stringBuilder.append(", ")
        stringBuilder.append(currentItem.zip)
        holder.txtCountryAndZip.text = stringBuilder.toString()

        holder.imgAddressThumbnail
        holder.itemView.setOnClickListener(ShortPressListener())
        holder.itemView.setOnLongClickListener(LongPressListener())

        if(!currentItem.imageURL.isNullOrBlank())
            Picasso.get().load(currentItem.imageURL).into(holder.imgAddressThumbnail) //TODO Need places API connected - might store photos directly
        else holder.imgAddressThumbnail.setImageResource(R.drawable.no_image_available)
    }

    override fun getItemCount(): Int {return addressList.size}


    private fun OpenItem(v: View?) {
        //TODO implement creation of intent to go to SearchResult with data from the selected item
    }

    private fun RemoveItem(v: View?){

    }

    private inner class ShortPressListener : View.OnClickListener {
        override fun onClick(v: View?) {
            OpenItem(v)
        }
    }

    private inner class LongPressListener : View.OnLongClickListener {
        override fun onLongClick(v: View?): Boolean {
            RemoveItem(v)
            return false
        }
    }
}