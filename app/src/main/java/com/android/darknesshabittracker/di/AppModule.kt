package com.android.darknesshabittracker.di

import android.app.Application
import androidx.room.Room
import com.android.darknesshabittracker.feature_habit.data.data_source.local.HabitDatabase
import com.android.darknesshabittracker.feature_habit.data.repository.HabitRepositoryImpl
import com.android.darknesshabittracker.feature_habit.domain.repository.HabitRepository
import com.android.darknesshabittracker.feature_habit.domain.use_case.DeleteHabit
import com.android.darknesshabittracker.feature_habit.domain.use_case.GetHabits
import com.android.darknesshabittracker.feature_habit.domain.use_case.HabitUseCases
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideHabitDatabase(context: Application): HabitDatabase {
        return Room.databaseBuilder(
            context,
            HabitDatabase::class.java,
            HabitDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideRepository(db: HabitDatabase): HabitRepository {
        return HabitRepositoryImpl(db.habitDao())
    }

    @Provides
    @Singleton
    fun provideUseCases(repository: HabitRepository): HabitUseCases {
        return HabitUseCases(
            getHabits = GetHabits(repository),
            deleteHabit = DeleteHabit(repository)
        )
    }

    @Provides
    @Singleton
    fun provideFirebaseFirebaseAuth(): FirebaseAuth {
        return Firebase.auth
    }
}