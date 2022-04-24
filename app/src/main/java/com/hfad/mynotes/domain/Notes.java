//Создаю класс со структурой заметок

package com.hfad.mynotes.domain;

import androidx.annotation.DrawableRes;

public class Notes {
    private String nameNotes; //наименование заметки
    //private String descriptionOfNotes; //описание заметки
    private @DrawableRes //иконка заметки
            int icon;

    public Notes(String nameNotes, int icon) {
        this.nameNotes = nameNotes;
        this.icon = icon;
    }

    public String getNameNotes() {
        return nameNotes;
    }

    public int getIcon() {
        return icon;
    }

}
    






















