//Создаю класс со структурой заметок

package com.hfad.mynotes.domain;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.DrawableRes;

public class Notes implements Parcelable {
    private String nameNotes; //наименование заметки

    public String getNameNotes() {
        return nameNotes;
    }

    public int getIcon() {
        return icon;
    }

    //private String descriptionOfNotes; //описание заметки
    private @DrawableRes //иконка заметки
            int icon;

    public Notes(String nameNotes, int icon) {
        this.nameNotes = nameNotes;
        this.icon = icon;
    }


    protected Notes(Parcel in) {
        nameNotes = in.readString();
        icon = in.readInt();
    }

    public static final Creator<Notes> CREATOR = new Creator<Notes>() {
        @Override
        public Notes createFromParcel(Parcel in) {
            return new Notes(in);
        }

        @Override
        public Notes[] newArray(int size) {
            return new Notes[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nameNotes);
        dest.writeInt(icon);
    }
}























