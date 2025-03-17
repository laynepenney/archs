/*
 * Copyright (c) Layne Penney 2025.
 */

package pro.layne.sample.archs.test.app.testdi

import dagger.Binds
import dagger.Module
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn
import pro.layne.sample.archs.core.data.PatternRepository
import pro.layne.sample.archs.core.data.di.DataModule
import pro.layne.sample.archs.core.data.di.FakePatternRepository

@Module
@TestInstallIn(
    components = [SingletonComponent::class],
    replaces = [DataModule::class]
)
interface FakeDataModule {

    @Binds
    abstract fun bindRepository(
        fakeRepository: FakePatternRepository
    ): PatternRepository
}
