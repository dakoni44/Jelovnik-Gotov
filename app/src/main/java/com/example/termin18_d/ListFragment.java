package com.example.termin18_d;


import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


import com.example.termin18_d.adapter.MyAdapter;
import com.example.termin18_d.model.Jelo;
import com.example.termin18_d.model.JeloProvider;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListFragment extends Fragment {

   private ListView lvJela;
   private ArrayList<Jelo> jela;
   private OnItemClickListener listener;



    public ListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            listener= (OnItemClickListener) context;
        }catch (ClassCastException e){
            Toast.makeText(context,"Implementiraj interfejs",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final ArrayList<Jelo> jela= JeloProvider.getJela();
        lvJela=view.findViewById(R.id.lvJela);
        MyAdapter adapter=new MyAdapter(getActivity(),jela);
        lvJela.setAdapter(adapter);
        lvJela.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                listener.OnItemClicked(jela.get(position).getId());
            }
        });
    }

    public interface OnItemClickListener{
        void OnItemClicked(int id);
    }
}
