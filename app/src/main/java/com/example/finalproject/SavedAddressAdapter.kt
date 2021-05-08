package com.example.finalproject

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class SavedAddressAdapter(private val addressList : List<SavedAddressItem>) :
    RecyclerView.Adapter<SavedAddressAdapter.AddressHolder>() {

    class AddressHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val imgAddressThumbnail: ImageView = itemView.findViewById(R.id.imgAddressThumnail)
        val txtStreetAddress : TextView = itemView.findViewById(R.id.txtStreetAddress)
        val txtCity : TextView = itemView.findViewById(R.id.txtCity)
        val txtState : TextView = itemView.findViewById(R.id.txtState)
        val txtZip : TextView = itemView.findViewById(R.id.txtZip)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AddressHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.saved_address,parent,false)
        return AddressHolder(view)
    }

    override fun onBindViewHolder(holder: AddressHolder, position: Int) {
        val currentItem = addressList[position]
        holder.txtStreetAddress.text = currentItem.address.streetAddress
        holder.txtCity.text = currentItem.address.city
        holder.txtState.text = currentItem.address.state
        holder.imgAddressThumbnail
        holder.itemView.setOnClickListener(ShortPressListener())
        holder.itemView.setOnLongClickListener(LongPressListener())

        if(!currentItem.imgURL.isNullOrBlank())
            Picasso.get().load(currentItem.imgURL).into(holder.imgAddressThumbnail)
        else holder.imgAddressThumbnail.setImageResource(R.drawable.no_image_available)
    }

    override fun getItemCount(): Int { return addressList.size}


    private fun OpenItem(v: View?) {
        //TODO implement creation of intent to go to SearchResult with data from the selected item
    }

    private inner class ShortPressListener : View.OnClickListener {
        override fun onClick(v: View?) {
            OpenItem(v)
        }
    }

    //TODO confirm if this is needed in combination with OnClick
    private inner class LongPressListener : View.OnLongClickListener {
        override fun onLongClick(v: View?): Boolean {
            OpenItem(v)
            return false
        }
    }
}