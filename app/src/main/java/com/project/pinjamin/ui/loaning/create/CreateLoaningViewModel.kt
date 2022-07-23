package com.project.pinjamin.ui.loaning.create

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.project.pinjamin.data.database.entity.Borrower
import com.project.pinjamin.data.database.entity.Category
import com.project.pinjamin.data.database.entity.Item
import com.project.pinjamin.data.database.entity.Loaning
import com.project.pinjamin.data.database.relation.CategoryWithItems
import com.project.pinjamin.usecase.borrower.GetAllBorrowerUseCase
import com.project.pinjamin.usecase.category.GetAllCategoryUseCase
import com.project.pinjamin.usecase.category.GetCategoryWithItemsUseCase
import com.project.pinjamin.usecase.loaning.InsertLoaningUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject

@HiltViewModel
class CreateLoaningViewModel @Inject constructor(
    private val insertLoaningUseCase: InsertLoaningUseCase,
    getAllBorrowerUseCase: GetAllBorrowerUseCase,
    getAllCategoryUseCase: GetAllCategoryUseCase,
    private val getCategoryWithItemsUseCase: GetCategoryWithItemsUseCase
) : ViewModel() {
    private var _selectedCategory: Category? = null
    private var _borrowDate: Date? = null
    private val _tempSelectedItems = mutableListOf<Item>()
    private val _selectedItems = MutableLiveData<List<Item>>()
    private val _selectedBorrower = MutableLiveData<Borrower>()
    private val _categoryWithItems = MutableLiveData<CategoryWithItems>()
    val selectedBorrower: LiveData<Borrower>
        get() = _selectedBorrower
    val selectedItems: LiveData<List<Item>>
        get() = _selectedItems
    val categories: LiveData<List<Category>> = getAllCategoryUseCase()
    val borrowers: LiveData<List<Borrower>> = getAllBorrowerUseCase()
    val categoryWithItems: LiveData<CategoryWithItems>
        get() = _categoryWithItems

    init {
        val category = getAllCategoryUseCase().value?.first()
        category?.let { changeCategory(it) }
    }

    fun changeCategory(category: Category) {
        _selectedCategory = category
        updateCategoryWithItems()
    }

    fun changeBorrower(borrower: Borrower) {
        _selectedBorrower.postValue(borrower)
    }

    fun selectItem(item: Item) {
        _tempSelectedItems.add(item)
        _selectedItems.postValue(_tempSelectedItems)
        updateCategoryWithItems()
    }

    fun removeItem(item: Item) {
        _tempSelectedItems.removeAll { item.idBarang == it.idBarang }
        _selectedItems.postValue(_tempSelectedItems)
        updateCategoryWithItems()
    }

    private fun updateCategoryWithItems() {
        viewModelScope.launch(Dispatchers.IO) {
            _selectedCategory?.let {
                val newCategory = getCategoryWithItemsUseCase(it.idKategori)
                val listIdItem: List<Int> =
                    _selectedItems.value?.map { item -> item.idBarang } ?: emptyList()
                newCategory.items =
                    newCategory.items.filter { item -> !listIdItem.contains(item.idBarang) }
                _categoryWithItems.postValue(newCategory)
            }
        }
    }

    fun addLoaning() {
        viewModelScope.launch(Dispatchers.IO) {
            insertLoaningUseCase(
                Loaning(
                    idAdmin = 1,
                    idPeminjam = selectedBorrower.value!!.idPeminjam,
                    tglPeminjaman = _borrowDate!!,
                    status = "Dipinjam"
                ),
                _selectedItems.value!!
            )
        }
    }

    fun changeDate(date: Date) {
        _borrowDate = date
    }

    fun isReadySubmit(): Boolean = _borrowDate != null
            && (_selectedItems.value?.size ?: 0) > 0
}
