package com.example.firebase

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.firebase.adapter.RiwayatAdapter
import com.example.firebase.model.RiwayatKas

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class RiwayatFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var riwayatAdapter: RiwayatAdapter
    private var riwayatList: MutableList<RiwayatKas> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_riwayat, container, false)

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerViewRiwayat)
        recyclerView.layoutManager = LinearLayoutManager(context)

        riwayatList.addAll(getDummyData())
        riwayatAdapter = RiwayatAdapter(riwayatList)
        recyclerView.adapter = riwayatAdapter

        view.findViewById<Button>(R.id.buttonTambahData).setOnClickListener {
            showAddDataDialog()
        }

        return view
    }

    private fun showAddDataDialog() {
        val dialogView = LayoutInflater.from(context).inflate(R.layout.dialog_add_data, null)
        val editTextNama = dialogView.findViewById<EditText>(R.id.editTextNama)
        val editTextAlamat = dialogView.findViewById<EditText>(R.id.editTextAlamat)
        val editTextIuranKas = dialogView.findViewById<EditText>(R.id.editTextIuranKas)
        val editTextIuranKeamanan = dialogView.findViewById<EditText>(R.id.editTextIuranKeamanan)
        val editTextIuranKebersihan = dialogView.findViewById<EditText>(R.id.editTextIuranKebersihan)
        val editTextDanaSosial = dialogView.findViewById<EditText>(R.id.editTextDanaSosial)

        AlertDialog.Builder(context)
            .setTitle("Tambah Data Iuran Kas")
            .setView(dialogView)
            .setPositiveButton("Tambah") { _, _ ->
                val nama = editTextNama.text.toString()
                val alamat = editTextAlamat.text.toString()
                val iuranKas = editTextIuranKas.text.toString()
                val iuranKeamanan = editTextIuranKeamanan.text.toString()
                val iuranKebersihan = editTextIuranKebersihan.text.toString()
                val danaSosial = editTextDanaSosial.text.toString()

                val newItem = RiwayatKas(nama, alamat, iuranKas, iuranKeamanan, iuranKebersihan, danaSosial)
                riwayatList.add(newItem)
                riwayatAdapter.notifyItemInserted(riwayatList.size - 1)
            }
            .setNegativeButton("Batal", null)
            .show()
    }

    private fun getDummyData(): List<RiwayatKas> {
        return listOf(
            RiwayatKas("Alya Sefhia Eka Putri", "Blok D8/02", "Rp50.000", "Rp20.000", "Rp20.000", "Rp20.000"),
            RiwayatKas("Zidna Soleda Zulfa", "Blok D8/03", "Rp50.000", "Rp20.000", "Rp20.000", "Rp20.000"),
        )
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            RiwayatFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}