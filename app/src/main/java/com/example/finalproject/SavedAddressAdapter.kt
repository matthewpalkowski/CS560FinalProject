package com.example.finalproject

import android.app.Application
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.finalproject.databaseobjects.AddressEntity
import com.example.finalproject.databaseobjects.RoomDatabaseAddresses
import com.squareup.picasso.Picasso

class SavedAddressAdapter(private val addressList : MutableList<AddressEntity>) :
    RecyclerView.Adapter<SavedAddressAdapter.AddressHolder>() {

    lateinit var applicationContext : Application

    inner class AddressHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val imgAddressThumbnail: ImageView = itemView.findViewById(R.id.imgAddressThumnail)
        val txtStreetAddress : TextView = itemView.findViewById(R.id.txtStreetAddress)
        val txtCity : TextView = itemView.findViewById(R.id.txtCity)
        val txtState : TextView = itemView.findViewById(R.id.txtState)
        val txtCountryAndZip : TextView = itemView.findViewById(R.id.txtCountryAndZip)
        lateinit var addressEntity : AddressEntity

        init{
            itemView.setOnClickListener {
                val intent = Intent(
                    itemView.context,
                    SearchResultActivity::class.java)
                val address = generateAddress(this)
                intent.putExtra(GlobalStrings.ADDRESS_KEY, address)
                this.itemView.context.startActivity(intent)
            }

            itemView.setOnLongClickListener {
                removeItem(this)
                return@setOnLongClickListener false
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AddressHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.saved_address,parent,false)
        applicationContext = parent.context.applicationContext as Application
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

        if(holder.addressEntity.imageURL.isNotBlank())
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
            entity.zip)
    }

    override fun getItemCount(): Int {return addressList.size}

    private fun removeItem(holder: AddressHolder){
        val entity = holder.addressEntity
        Thread{
            val db = RoomDatabaseAddresses.getAddressDatabase(applicationContext)
            db.contactDAO().deleteAddress(entity)
        }.start()
        addressList.remove(entity)
        notifyDataSetChanged()
        if(addressList.isEmpty()) (holder.itemView.context as SavedAddressesActivity).manageVisibility()
    }
}