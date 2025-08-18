package com.echo.basicleaning.demo.component

import android.os.Parcel
import android.os.Parcelable

data class Student(
    val name: String,
    var age: Int,
    val studentId: String,
    var grade: Double = 0.0
):Parcelable{
    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readInt(),
        parcel.readString()!!,
        parcel.readDouble()
    ) {
    }

    override fun describeContents(): Int = 0

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(name)
        dest.writeInt(age)
        dest.writeString(studentId)
        dest.writeDouble(grade)
    }

    companion object CREATOR : Parcelable.Creator<Student> {
        override fun createFromParcel(parcel: Parcel): Student {
            return Student(parcel)
        }

        override fun newArray(size: Int): Array<Student?> {
            return arrayOfNulls(size)
        }
    }

}