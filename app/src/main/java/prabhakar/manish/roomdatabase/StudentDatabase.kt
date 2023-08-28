package prabhakar.manish.roomdatabase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import java.sql.Types.NULL

@Database(entities = [Student::class], version = 1)
@TypeConverters(Converters::class)
abstract class StudentDatabase :RoomDatabase()
{
    abstract fun studentDao() : StudentDao
    companion object
    {
        @Volatile
        private  var INSTANCE : StudentDatabase? = null
        fun getDatabase(context: Context) : StudentDatabase
        {
            if(INSTANCE == null)
            {
                synchronized(this)
                {
                    INSTANCE = Room.databaseBuilder(context.applicationContext,StudentDatabase::class.java,"StudetnDB").build()
                }
            }
            return INSTANCE!!
        }

    }
}