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

import womsoft.saojosefcapp.elenco.AdapterElencoSJFC;
import womsoft.saojosefcapp.elenco.BeanElencoSJFC;
import womsoft.saojosefcapp.elenco.ParserJsonElencoSJFC;
import womsoft.saojosefcapp.jogos.AdapterJogosSJFC;
import womsoft.saojosefcapp.jogos.ParserJsonJogosSJFC;

/**
 * Created by Willian.Matos on 09/02/2018.
 */

public class ElencoFragmentSJFC extends Fragment {

    private RecyclerView mRecyclerView;
    private ProgressBar progressBarElenco;

    private ParserJsonElencoSJFC parserElencoSJFC;
    private ArrayList<BeanElencoSJFC> listElenco;
    private AdapterElencoSJFC adapterElenco;

    private Gson gSon;

    public static ElencoFragmentSJFC newInstance() {
        
        Bundle args = new Bundle();
        
        ElencoFragmentSJFC fragment = new ElencoFragmentSJFC();
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
        View view =inflater.inflate(R.layout.fragment_elenco_sjfc, container, false);

        mRecyclerView = (RecyclerView) view.findViewById (R.id.recElenco);
        mRecyclerView.setHasFixedSize (true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity (), LinearLayoutManager.VERTICAL, false));

        progressBarElenco = (ProgressBar) view.findViewById (R.id.progBarElenco);
        progressBarElenco.setVisibility (View.VISIBLE);

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

        String jsonElenco = getActivity().getResources().getString(R.string.json_elenco);
        //System.out.println("Jogos: " +jsonJogos);

        parserElencoSJFC = gSon.fromJson (jsonElenco, ParserJsonElencoSJFC.class);
        listElenco      = parserElencoSJFC.getElenco();

        adapterElenco = new AdapterElencoSJFC(getActivity (), listElenco);
        mRecyclerView.setAdapter (adapterElenco);

        progressBarElenco.setVisibility (View.GONE);
    }
}
