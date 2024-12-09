package com.ww.space_tubespemogramanmobile

import android.os.Parcel
import android.os.Parcelable

data class Note(
    var title: String,
    var summary: String,  // Summary yang lebih ringkas
    var content: String, // Konten lengkap
    val dateCreated: Long // Menyimpan tanggal dalam format long (timestamp)
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readLong()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(title)
        parcel.writeString(summary)
        parcel.writeString(content)
        parcel.writeLong(dateCreated)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Note> {
        override fun createFromParcel(parcel: Parcel): Note {
            return Note(parcel)
        }

        override fun newArray(size: Int): Array<Note?> {
            return arrayOfNulls(size)
        }
    }
}
