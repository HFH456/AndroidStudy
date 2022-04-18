package com.thoughtworks.androidtrain.data

import android.os.Parcel
import android.os.Parcelable

class Phone(var name: String?, var phone_number: String?) : Parcelable {
    constructor(parcel: Parcel) : this(parcel.readString(), parcel.readString()) {

    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Phone> {
        override fun createFromParcel(parcel: Parcel): Phone {
            return Phone(parcel)
        }

        override fun newArray(size: Int): Array<Phone?> {
            return arrayOfNulls(size)
        }
    }

}