package com.hfad.mynotes.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;

import com.hfad.mynotes.R;
import com.hfad.mynotes.domain.Notes;

public class DogsDetailsFragment extends Fragment {
    private static final String ARG_NOTES = "ARG_NOTES";//константа

    public static DogsDetailsFragment newInstance(Notes notes) {

        Bundle args = new Bundle();
        args.putParcelable(ARG_NOTES, notes);

        DogsDetailsFragment fragment = new DogsDetailsFragment();//экземляр класса фрагмента
        fragment.setArguments(args);
        return fragment;
    }


    public DogsDetailsFragment() {
        super(R.layout.fragment_dogs_details);//layout, через который отображаем фрагмент
    }

    private TextView title;
    private ImageView icon;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        title = view.findViewById(R.id.title);
        icon = view.findViewById(R.id.icon);
        getParentFragmentManager()
                .setFragmentResultListener(BlankFragment.DOGS_CLICKED_KEY, getViewLifecycleOwner(), new FragmentResultListener() {
                    @Override
                    public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {
                        Notes notes = result.getParcelable(BlankFragment.SELECTED_DOGS);
                        showDogs(notes);
                    }
                });
        if (getArguments() != null && getArguments().containsKey(ARG_NOTES)) {
            Notes notes = getArguments().getParcelable(ARG_NOTES);
            showDogs(notes);
        }

    }

    private void showDogs(Notes notes) {
        title.setText(notes.getNameNotes());
        icon.setImageResource(notes.getIcon());
    }

}
