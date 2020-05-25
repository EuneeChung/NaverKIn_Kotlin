package com.example.naverkin.di

import com.example.naverkin.data.source.NaverQuestionRepository
import com.example.naverkin.data.source.NaverQuestionRepositoryImpl
import com.example.naverkin.data.source.remote.NaverQuestionRemoteDataSource
import com.example.naverkin.data.source.remote.NaverQuestionRemoteDataSourceImpl
import org.koin.dsl.module

val repositoryModule = module {
    single<NaverQuestionRepository> {
        NaverQuestionRepositoryImpl(
            get()
        )
    }
    single<NaverQuestionRemoteDataSource> {
        NaverQuestionRemoteDataSourceImpl(get())
    }
}