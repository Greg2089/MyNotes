//интерфейс со списком заметок
package com.hfad.mynotes.domain;

import java.util.List;

public interface NotesRepository {
    List<Notes> getAll();

    void add(Notes notes);
}
