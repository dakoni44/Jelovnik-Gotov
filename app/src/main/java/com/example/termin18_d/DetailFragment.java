package com.example.termin18_d;


import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


import com.example.termin18_d.model.JeloProvider;

import java.io.InputStream;
import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class DetailFragment extends Fragment {

    TextView tvNaziv,tvCena;
    ImageView slikaJela;
    ListView lvSastojci;
    Spinner spinner;
    private int position=0;
    ArrayList<String> kategorije=new ArrayList<>();

    public DetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (savedInstanceState != null) {
            position = savedInstanceState.getInt("position");
        }

        slikaJela=view.findViewById(R.id.slikaJela);
        try {
            InputStream is = getActivity().getAssets().open(JeloProvider.getJeloById(position).getSlika());
            Drawable drawable = Drawable.createFromStream(is,"");
            slikaJela.setImageDrawable(drawable);
        }catch (Exception e){
            e.printStackTrace();
        }
        tvNaziv=view.findViewById(R.id.tvNaziv);

        tvNaziv.setText("Naziv: "+JeloProvider.getJeloById(position).getNaziv());
        tvCena=view.findViewById(R.id.tvCena);
        tvCena.setText("Cena: "+JeloProvider.getJeloById(position).getCena()+" dinara");
        spinner=view.findViewById(R.id.sKategorija);
        for(int i=0;i<JeloProvider.getJela().size();i++){
            kategorije.add(JeloProvider.getJeloById(i).getOpis().getNaziv());
        }
        ArrayAdapter<String> adapter2=new ArrayAdapter<>(getActivity(),android.R.layout.simple_list_item_1,kategorije);
        spinner.setAdapter(adapter2);
        spinner.setSelection(JeloProvider.getJeloById(position).getOpis().getId());
        lvSastojci=view.findViewById(R.id.lvSastojci);
        ArrayList<String> sastojci=JeloProvider.getJeloById(position).getSastojci();
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(getContext(),android.R.layout.simple_list_item_1,sastojci);
        lvSastojci.setAdapter(adapter);
    }

    public void setContent(final int position) {

        this.position = position;

    }

    public void updateContent(final int position){
        this.position = position;
        slikaJela=getView().findViewById(R.id.slikaJela);
        try {
            InputStream is = getActivity().getAssets().open(JeloProvider.getJeloById(position).getSlika());
            Drawable drawable = Drawable.createFromStream(is,"");
            slikaJela.setImageDrawable(drawable);
        }catch (Exception e){
            e.printStackTrace();
        }
        tvNaziv=getView().findViewById(R.id.tvNaziv);

        tvNaziv.setText("Naziv: "+JeloProvider.getJeloById(position).getNaziv());
        tvCena=getView().findViewById(R.id.tvCena);
        tvCena.setText("Cena: "+JeloProvider.getJeloById(position).getCena()+" dinara");
        spinner=getView().findViewById(R.id.sKategorija);
        for(int i=0;i<JeloProvider.getJela().size();i++){
            kategorije.add(JeloProvider.getJeloById(i).getOpis().getNaziv());
        }
        ArrayAdapter<String> adapter2=new ArrayAdapter<>(getActivity(),android.R.layout.simple_list_item_1,kategorije);
        spinner.setAdapter(adapter2);
        spinner.setSelection(JeloProvider.getJeloById(position).getOpis().getId());
        lvSastojci=getView().findViewById(R.id.lvSastojci);
        ArrayList<String> sastojci=JeloProvider.getJeloById(position).getSastojci();
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(getContext(),android.R.layout.simple_list_item_1,sastojci);
        lvSastojci.setAdapter(adapter);

    }
}
