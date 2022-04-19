//Создаю класс со структурой заметок

package com.hfad.mynotes.domain;

import androidx.annotation.DrawableRes;

public class Notes {
    private String nameNotes;
    private String descriptionOfNotes;
    private @DrawableRes
    int icon;

    public Notes(String nameNotes, String descriptionOfNotes, int icon) {
        this.nameNotes = nameNotes;
        this.descriptionOfNotes = descriptionOfNotes;
        this.icon = icon;
    }

    public String getNameNotes() {
        return nameNotes;
    }

    public String getDescriptionOfNotes() {
        return descriptionOfNotes;
    }

    public int getIcon() {
        return icon;
    }

}
    






















