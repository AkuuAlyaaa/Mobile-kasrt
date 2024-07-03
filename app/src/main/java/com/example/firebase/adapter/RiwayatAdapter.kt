package com.example.firebase.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.firebase.R
import com.example.firebase.model.RiwayatKas

class RiwayatAdapter(private val riwayatList: MutableList<RiwayatKas>) : RecyclerView.Adapter<RiwayatAdapter.RiwayatViewHolder>() {

    class RiwayatViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textViewNama: TextView = itemView.findViewById(R.id.textViewNama)
        val textViewAlamat: TextView = itemView.findViewById(R.id.textViewAlamat)
        val textViewIuranKas: TextView = itemView.findViewById(R.id.textViewIuranKas)
        val textViewIuranKeamanan: TextView = itemView.findViewById(R.id.textViewIuranKeamanan)
        val textViewIuranKebersihan: TextView = itemView.findViewById(R.id.textViewIuranKebersihan)
        val textViewDanaSosial: TextView = itemView.findViewById(R.id.textViewDanaSosial)
        val buttonHapus: Button = itemView.findViewById(R.id.buttonHapus)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RiwayatViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_riwayat, parent, false)
        return RiwayatViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: RiwayatViewHolder, position: Int) {
        val currentItem = riwayatList[position]
        holder.textViewNama.text = "Nama Warga: ${currentItem.namaWarga}"
        holder.textViewAlamat.text = "Alamat: ${currentItem.alamat}"
        holder.textViewIuranKas.text = "Iuran Kas: ${currentItem.iuranKas}"
        holder.textViewIuranKeamanan.text = "Iuran Keamanan: ${currentItem.iuranKeamanan}"
        holder.textViewIuranKebersihan.text = "Iuran Kebersihan: ${currentItem.iuranKebersihan}"
        holder.textViewDanaSosial.text = "Dana Sosial: ${currentItem.danaSosial}"

        holder.buttonHapus.setOnClickListener {
            riwayatList.removeAt(holder.adapterPosition)
            notifyItemRemoved(holder.adapterPosition)
        }
    }

    override fun getItemCount() = riwayatList.size
}