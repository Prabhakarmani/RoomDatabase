package prabhakar.manish.roomdatabase

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "student")
data class Student(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo val serial_no : Int,
    @ColumnInfo val roll_no : Int,
    @ColumnInfo val name : String,
    @ColumnInfo val grade : String,
    @ColumnInfo val DOA : Date
)
