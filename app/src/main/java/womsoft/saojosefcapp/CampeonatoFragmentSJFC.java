package womsoft.saojosefcapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.google.gson.Gson;

import java.util.ArrayList;

import womsoft.saojosefcapp.campeonatos.AdapterCampeonatoSJFC;
import womsoft.saojosefcapp.campeonatos.BeanCampeonatoSJFC;
import womsoft.saojosefcapp.campeonatos.ParserJsonCampeonatoSJFC;
import womsoft.saojosefcapp.jogos.AdapterJogosSJFC;
import womsoft.saojosefcapp.jogos.BeanJogosSJFC;
import womsoft.saojosefcapp.jogos.ParserJsonJogosSJFC;

/**
 * Created by Willian.Matos on 04/02/2018.
 */

public class CampeonatoFragmentSJFC extends Fragment {

    private RecyclerView mRecyclerView;
    private ProgressBar progressBarCampeonato;

    private ParserJsonCampeonatoSJFC parserCampeonatoSJFC;
    private ArrayList<BeanCampeonatoSJFC> listCampeonato;
    private AdapterCampeonatoSJFC adapterCampeonato;

    private Gson gSon;

    public static CampeonatoFragmentSJFC newInstance() {
        
        Bundle args = new Bundle();
        
        CampeonatoFragmentSJFC fragment = new CampeonatoFragmentSJFC();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        gSon = new Gson();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view =inflater.inflate(R.layout.fragment_jogos_sjfc, container, false);

        mRecyclerView = (RecyclerView) view.findViewById (R.id.recJogos);
        mRecyclerView.setHasFixedSize (true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity (), LinearLayoutManager.VERTICAL, false));

        progressBarCampeonato = (ProgressBar) view.findViewById (R.id.progBarJogos);
        progressBarCampeonato.setVisibility (View.VISIBLE);

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

        String jsonCampeonato = getActivity().getResources().getString(R.string.json_campeonato);

        parserCampeonatoSJFC = gSon.fromJson (jsonCampeonato, ParserJsonCampeonatoSJFC.class);
        listCampeonato       = parserCampeonatoSJFC.getCampeonato();

        adapterCampeonato = new AdapterCampeonatoSJFC (getActivity (), listCampeonato);
        mRecyclerView.setAdapter (adapterCampeonato);

        progressBarCampeonato.setVisibility (View.GONE);
    }
}
