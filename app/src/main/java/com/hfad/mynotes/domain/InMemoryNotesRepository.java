//для возвращения списка, формируемого в интерфейсе NotesRepository
package com.hfad.mynotes.domain;

import android.content.Context;

import com.hfad.mynotes.R;

import java.util.ArrayList;
import java.util.List;

public class InMemoryNotesRepository implements NotesRepository {

    private static NotesRepository INSTANCE;

    public static NotesRepository getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = new InMemoryNotesRepository(context);
        }
        return INSTANCE;
    }

    private Context context; /*Context – это объект, который предоставляет доступ
к базовым функциям приложения: доступ к ресурсам, к файловой системе, вызов активности и т.д.
Activity является подклассом Context, поэтому в коде мы можем использовать её как ИмяАктивности.this
(напр. MainActivity.this), или укороченную запись this. Классы Service, Application и др. также работают с контекстом.*/

    private InMemoryNotesRepository(Context context) {
        this.context = context;
    }

    @Override
    public List<Notes> getAll() {
        ArrayList<Notes> result = new ArrayList<>();
        result.add(new Notes(context.getString(R.string.corgi), R.drawable.corgi));
        result.add(new Notes(context.getString(R.string.germanShepherd), R.drawable.german_shepherd));
        result.add(new Notes(context.getString(R.string.caucasianShepherdDog), R.drawable.caucasian_shepherd_dog));
        result.add(new Notes(context.getString(R.string.centralAsianShepherdDog), R.drawable.central_asian_shepherd_dog));
        return result;
    }

    @Override
    public void add(Notes notes) {

    }
}
