package com.example.acronymmeanings

import com.example.acronymmeanings.repo.FakeSearchRepoTest
import com.example.acronymmeanings.repo.Search
import dagger.Module
import dagger.Provides
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import dagger.hilt.testing.TestInstallIn

@Module
@TestInstallIn(
    components = [ViewModelComponent::class],
    replaces = [ViewModelModule::class]
)
object FakeViewModelModule {

    @Provides
    @ViewModelScoped
    fun injectRepo(): Search {
        return FakeSearchRepoTest()
    }

}