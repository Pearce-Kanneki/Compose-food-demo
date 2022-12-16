package com.kanneki.fooddemo.di

import com.kanneki.fooddemo.data.repository.GetProductRepositoryImp
import com.kanneki.fooddemo.data.repository.GetProductTypeRepositoryImp
import com.kanneki.fooddemo.domain.repository.GetProductTypeRepository
import com.kanneki.fooddemo.domain.repository.GetProductsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindGetProductsRepository(
        productsRepositoryImp: GetProductRepositoryImp
    ): GetProductsRepository

    @Binds
    @Singleton
    abstract fun bindGetProductTypeRepository(
        typeRepository: GetProductTypeRepositoryImp
    ): GetProductTypeRepository
}