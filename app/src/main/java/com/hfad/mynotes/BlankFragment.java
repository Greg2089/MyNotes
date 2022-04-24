package com.hfad.mynotes;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.hfad.mynotes.domain.InMemoryNotesRepository;
import com.hfad.mynotes.domain.Notes;

import java.util.List;


public class BlankFragment extends Fragment {
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);//после вызова этого метода появляется Context
    }

    //Метод onCreateView() вызывается тогда, когда Android потребуется макет фрагмента.
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blank, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        List<Notes> note = InMemoryNotesRepository.getInstance(requireContext()).getAll();/*получаем список,
        методом requireContext()) возвращаем Context (если он null, обработатываю исключение), метод getContex */
        LinearLayout container = view.findViewById(R.id.container);//находим контейнер из xml
        for (Notes notes : note) {
            View itemView = getLayoutInflater().inflate(R.layout.item_dogs, container, false);
            itemView.findViewById(R.id.root).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(requireContext(), notes.getNameNotes(), Toast.LENGTH_SHORT).show();
                }
            });
            ImageView icon = itemView.findViewById(R.id.icon);
            icon.setImageResource(notes.getIcon());
            TextView title = itemView.findViewById(R.id.title);
            title.setText(notes.getNameNotes());
            container.addView(itemView);
        }

    }
}