package prabhakar.manish.roomdatabase

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface StudentDao
{
    @Insert
    fun insertStudent(student: Student)
    @Update
    fun updateStudent(student: Student)
    @Delete
    fun deleteStudent(student: Student)
    @Query("SELECT* FROM STUDENT")
    fun getStudent() : LiveData<List<Student>>
    @Query("SELECT* FROM STUDENT WHERE serial_no = 4")
    fun getstudentfour() : LiveData<List<Student>>

    @Query("SELECT grade FROM student WHERE serial_no = 4")
    fun getGradeForStudentFour(): LiveData<String>

    @Query("SELECT grade FROM student WHERE serial_no = :serialNo")
    fun getGradeForSerialNumber(serialNo: Int): LiveData<String>


}