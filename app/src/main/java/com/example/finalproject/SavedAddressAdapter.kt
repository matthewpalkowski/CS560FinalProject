package com.example.finalproject

import android.content.Intent
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
        lateinit var addressEntity : AddressEntity
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AddressHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.saved_address,parent,false)
        return AddressHolder(view)
    }

    override fun onBindViewHolder(holder: AddressHolder, position: Int) {
        holder.addressEntity = addressList[position]
        holder.txtStreetAddress.text = holder.addressEntity.streetAddress
        holder.txtCity.text = holder.addressEntity.city
        holder.txtState.text = holder.addressEntity.state

        val stringBuilder = StringBuilder()
        stringBuilder.append(holder.addressEntity.country)
        stringBuilder.append(", ")
        stringBuilder.append(holder.addressEntity.zip)
        holder.txtCountryAndZip.text = stringBuilder.toString()

        holder.imgAddressThumbnail
        holder.itemView.setOnClickListener(ShortPressListener())
        holder.itemView.setOnLongClickListener(LongPressListener())

        if(!holder.addressEntity.imageURL.isNullOrBlank())
            Picasso.get().load(holder.addressEntity.imageURL).into(holder.imgAddressThumbnail) //TODO Need places API connected - might store photos directly
        else holder.imgAddressThumbnail.setImageResource(R.drawable.no_image_available)
    }

    private fun generateAddress(holder : AddressHolder): Address{
        val entity = holder.addressEntity
        return Address(
            entity.streetAddress,
            entity.city,
            entity.state,
            entity.country,
            entity.zip,
        )
    }

    override fun getItemCount(): Int {return addressList.size}

    private fun OpenItem(v: View?) {
        val intent = Intent(v!!.context, SearchResultActivity::class.java) //FIXME probably need the parent context
        val address = generateAddress(v!! as AddressHolder)
        intent.putExtra(GlobalStrings.ADDRESS_KEY,address) //FIXME can't use the getString in this context
        //TODO add other items as required (i.e. imageURL)
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