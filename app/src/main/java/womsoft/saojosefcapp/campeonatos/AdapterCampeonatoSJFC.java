package womsoft.saojosefcapp.campeonatos;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import womsoft.saojosefcapp.R;
import womsoft.saojosefcapp.jogos.AdapterJogosSJFC;
import womsoft.saojosefcapp.jogos.BeanJogosSJFC;
import womsoft.saojosefcapp.jogos.ParserJsonJogosSJFC;

/**
 * Created by Willian.Matos on 04/02/2018.
 */

public class AdapterCampeonatoSJFC extends RecyclerView.Adapter<AdapterCampeonatoSJFC.ItemRowHolder>{

    private Context mContext;

    private ArrayList<BeanCampeonatoSJFC> itemsList;
    private ParserJsonCampeonatoSJFC parserJsonItemCamp;
    private List<BeanCampeonatoSJFC> beanItemCamp;

    public AdapterCampeonatoSJFC(Context mContext, ArrayList<BeanCampeonatoSJFC> listCampeonato) {

        this.mContext = mContext;
        this.itemsList = listCampeonato;
    }

    @Override
    public ItemRowHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_campeonato_sjfc, null);
        AdapterCampeonatoSJFC.ItemRowHolder itemCampeonato = new AdapterCampeonatoSJFC.ItemRowHolder(v);

        return itemCampeonato;
    }

    @Override
    public void onBindViewHolder(ItemRowHolder holder, int position) {

        final String nomeCampeonato     = itemsList.get(position).getNome_campeonato();
        final String dtInicioCampeonato = itemsList.get(position).getData_inicio();
        final String idCampeonato       = itemsList.get(position).getId_campeonato();

        holder.txtNomeCampeonato.setText(nomeCampeonato);
        holder.txtDtInicioCampeonato.setText(dtInicioCampeonato);
        holder.idCampeonato = idCampeonato;
    }

    @Override
    public int getItemCount() {
        return (null != itemsList ? itemsList.size() : 0);
    }

    public class ItemRowHolder extends RecyclerView.ViewHolder {

        protected TextView txtNomeCampeonato;
        protected TextView txtDtInicioCampeonato;
        protected String idCampeonato;


        public ItemRowHolder(View view) {
            super(view);

            this.txtNomeCampeonato = (TextView) view.findViewById(R.id.txtNomeCamp);
            this.txtDtInicioCampeonato = (TextView) view.findViewById(R.id.txtInicioCamp);
        }
    }
}
