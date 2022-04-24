package com.hfad.mynotes.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.hfad.mynotes.R;
import com.hfad.mynotes.domain.Notes;

public class DogsDetailsFragment extends Fragment {
    private static final String ARG_NOTES = "ARG_NOTES";//константа

    public static DogsDetailsFragment newInstance(Notes notes) {

        Bundle args = new Bundle();
        args.putParcelable(ARG_NOTES,notes);

        DogsDetailsFragment fragment = new DogsDetailsFragment();//экземляр класса фрагмента
        fragment.setArguments(args);
        return fragment;
    }

    public DogsDetailsFragment() {
        super(R.layout.fragment_dogs_details);//layout, через который отображаем фрагмент
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView title = view.findViewById(R.id.title);
        ImageView icon = view.findViewById(R.id.icon);
        Notes notes = getArguments().getParcelable(ARG_NOTES);
        title.setText(notes.getNameNotes());
        icon.setImageResource(notes.getIcon());
    }
}
