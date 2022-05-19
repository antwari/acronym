package com.example.acronymmeanings

import com.example.acronymmeanings.repo.Search
import com.example.acronymmeanings.repo.SearchRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object ViewModelModule {

    @Provides
    @ViewModelScoped
    fun injectRepo(): Search {
        return SearchRepo()
    }

}


