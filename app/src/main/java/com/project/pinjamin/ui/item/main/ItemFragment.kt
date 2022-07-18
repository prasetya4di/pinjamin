package com.project.pinjamin.ui.item.main

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.project.pinjamin.R
import com.project.pinjamin.data.database.entity.Item
import com.project.pinjamin.databinding.FragmentItemBinding
import com.project.pinjamin.ui.item.create.CreateItemActivity
import com.project.pinjamin.ui.item.update.UpdateItemActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ItemFragment : Fragment() {

    private var _binding: FragmentItemBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentItemBinding.inflate(inflater, container, false)
        val root: View = binding.root
        val layoutManager = LinearLayoutManager(this.context)
        val itemViewModel = ViewModelProvider(this)[ItemViewModel::class.java]
        binding.rvItem.layoutManager = layoutManager
        binding.fabAddItem.setOnClickListener {
            startActivity(Intent(this.context, CreateItemActivity::class.java))
        }
        itemViewModel.items.observeForever {
            val itemAdapter = ItemAdapter(
                it,
                object : ItemAdapter.ItemAdapterCallback {
                    override fun tapDelete(item: Item) {
                        this@ItemFragment.context?.let { it1 ->
                            AlertDialog.Builder(it1)
                                .setTitle("Konfirmasi Hapus")
                                .setMessage("Apakah anda yakin akan menghapus data ${item.nama} ??")
                                .setIcon(R.drawable.ic_delete)
                                .setPositiveButton("YES") { _, _ ->
                                    itemViewModel.delete(
                                        item
                                    )
                                }
                                .setNegativeButton("NO") { _, _ -> }
                                .show()
                        }
                    }

                    override fun tapEdit(item: Item) {
                        val intent =
                            Intent(this@ItemFragment.context, UpdateItemActivity::class.java)
                        intent.putExtra("id_item", item.idBarang)
                        startActivity(intent)
                    }
                }
            )
            binding.rvItem.adapter = itemAdapter
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
