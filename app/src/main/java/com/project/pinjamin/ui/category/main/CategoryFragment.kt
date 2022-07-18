package com.project.pinjamin.ui.category.main

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
import com.project.pinjamin.data.database.entity.Category
import com.project.pinjamin.databinding.FragmentCategoryBinding
import com.project.pinjamin.ui.category.create.CreateCategoryActivity
import com.project.pinjamin.ui.category.update.UpdateCategoryActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CategoryFragment : Fragment() {

    private var _binding: FragmentCategoryBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCategoryBinding.inflate(inflater, container, false)
        val root: View = binding.root
        val layoutManager = LinearLayoutManager(this.context)
        val categoryViewModel =
            ViewModelProvider(this)[CategoryViewModel::class.java]
        binding.rvCategory.layoutManager = layoutManager
        binding.fabAddCategory.setOnClickListener {
            startActivity(Intent(this.context, CreateCategoryActivity::class.java))
        }
        categoryViewModel.categories.observeForever {
            val itemCategoryAdapter = ItemCategoryAdapter(
                it,
                object : ItemCategoryAdapter.ItemCategoryAdapterCallback {
                    override fun tapDelete(category: Category) {
                        this@CategoryFragment.context?.let { it1 ->
                            AlertDialog.Builder(it1)
                                .setTitle("Konfirmasi Hapus")
                                .setMessage("Apakah anda yakin akan menghapus data ${category.nama} ??")
                                .setIcon(R.drawable.ic_delete)
                                .setPositiveButton("YES") { _, _ ->
                                    categoryViewModel.deleteCategory(
                                        category
                                    )
                                }
                                .setNegativeButton("NO") { _, _ -> }
                                .show()
                        }
                    }

                    override fun tapEdit(category: Category) {
                        val intent = Intent(
                            this@CategoryFragment.context,
                            UpdateCategoryActivity::class.java
                        )
                        intent.putExtra("id_category", category.idKategori)
                        startActivity(intent)
                    }
                }
            )
            binding.rvCategory.adapter = itemCategoryAdapter
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
