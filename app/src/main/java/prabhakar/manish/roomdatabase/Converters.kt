package prabhakar.manish.roomdatabase

import androidx.room.TypeConverter
import java.util.Date

class Converters
{
    @TypeConverter
    fun fromdatatolong(value:Date):Long
    {
        return value.time
    }
    @TypeConverter
    fun fromlongtodate(value:Long):Date
    {
        return Date(value)
    }
}