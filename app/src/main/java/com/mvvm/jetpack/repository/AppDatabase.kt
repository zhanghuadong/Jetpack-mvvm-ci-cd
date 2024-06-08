package com.mvvm.jetpack.repository

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.mvvm.jetpack.bean.User
import com.mvvm.jetpack.dao.UserDao


@Database(entities = [User::class], version =7,exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao

    companion object {
        private var instance: AppDatabase? = null

        @Synchronized
        fun getDatabase(context: Context): AppDatabase {
            instance?.let {
                return it
            }
            return Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                "user_db"
            ).fallbackToDestructiveMigration().build().apply {
                instance = this
            }
        }
    }
}
