package com.project.pinjamin.usecase.loaning.impl

import com.project.pinjamin.data.database.entity.Item
import com.project.pinjamin.data.database.entity.Loaning
import com.project.pinjamin.data.database.entity.LoaningDetail
import com.project.pinjamin.data.database.reference.LoaningDetailItemCrossRef
import com.project.pinjamin.data.repository.ItemRepository
import com.project.pinjamin.data.repository.LoaningDetailRepository
import com.project.pinjamin.data.repository.LoaningRepository
import com.project.pinjamin.data.source.local.loaning_detail.LoaningDetailItemCrossRefDao
import com.project.pinjamin.usecase.loaning.InsertLoaningUseCase
import javax.inject.Inject

class InsertLoaningUseCaseImpl @Inject constructor(
    private val loaningRepository: LoaningRepository,
    private val loaningDetailRepository: LoaningDetailRepository,
    private val loaningDetailItemCrossRefDao: LoaningDetailItemCrossRefDao,
    private val itemRepository: ItemRepository
) : InsertLoaningUseCase {
    override fun invoke(loaning: Loaning, items: List<Item>) {
        val idLoaning = loaningRepository.insert(loaning)
        items.forEach {
            val idLoaningDetail =
                loaningDetailRepository.insert(LoaningDetail(idPeminjaman = idLoaning.toInt()))
            loaningDetailItemCrossRefDao.insert(
                LoaningDetailItemCrossRef(
                    idLoaningDetail.toInt(),
                    it.idBarang
                )
            )
        }
    }
}
