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

import womsoft.saojosefcapp.jogos.AdapterJogosSJFC;
import womsoft.saojosefcapp.jogos.BeanJogosSJFC;
import womsoft.saojosefcapp.jogos.ParserJsonJogosSJFC;

/**
 * Created by Willian.Matos on 03/02/2018.
 */

public class JogosFragmentSJFC extends Fragment {

    private RecyclerView mRecyclerView;
    private ProgressBar progressBarJogos;

    private ParserJsonJogosSJFC parserJogosSJFC;
    private ArrayList<BeanJogosSJFC> listJogos;
    private AdapterJogosSJFC adapterJogos;

    private Gson gSon;


    public static JogosFragmentSJFC newInstance() {
        
        Bundle args = new Bundle();
        
        JogosFragmentSJFC fragment = new JogosFragmentSJFC();
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

        progressBarJogos = (ProgressBar) view.findViewById (R.id.progBarJogos);
        progressBarJogos.setVisibility (View.VISIBLE);
        
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

        String jsonJogos = getActivity().getResources().getString(R.string.json_tabela);
        System.out.println("Jogos: " +jsonJogos);

        parserJogosSJFC = gSon.fromJson (jsonJogos, ParserJsonJogosSJFC.class);
        listJogos       = parserJogosSJFC.getJogos();

        adapterJogos = new AdapterJogosSJFC (getActivity (), listJogos);
        mRecyclerView.setAdapter (adapterJogos);

        progressBarJogos.setVisibility (View.GONE);
    }
}
