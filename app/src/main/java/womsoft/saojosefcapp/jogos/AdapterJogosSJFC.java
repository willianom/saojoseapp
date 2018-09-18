package womsoft.saojosefcapp.jogos;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import womsoft.saojosefcapp.R;

/**
 * Created by Willian.Matos on 03/02/2018.
 */

public class AdapterJogosSJFC extends RecyclerView.Adapter<AdapterJogosSJFC.ItemRowHolder> {

    private Context mContext;

    private ArrayList<BeanJogosSJFC> itemsList;
    private ParserJsonJogosSJFC parserJsonItemJogos;
    private List<BeanJogosSJFC> beanItemJogos;

    public AdapterJogosSJFC(Context mContext, ArrayList<BeanJogosSJFC> listJogos) {

        this.mContext = mContext;
        this.itemsList = listJogos;
    }

    @Override
    public ItemRowHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_jogo_sjfc, null);
        ItemRowHolder itemJogo = new ItemRowHolder (v);

        return itemJogo;
    }

    @Override
    public void onBindViewHolder(ItemRowHolder holder, int position) {

        final String nomeTimeMand    = itemsList.get(position).getTime_mand();
        final String nomeTimeVisit   = itemsList.get(position).getTime_visit();
        final String nomePlacarMand  = itemsList.get(position).getPlacar_mand();
        final String nomePlacarVisit = itemsList.get(position).getPlacar_visit();
        final String dataHoraJogo    = itemsList.get(position).getData_hora();
        final String localJogo       = itemsList.get(position).getLocal();
        //final String nomeCampeonato = itemsList.get(position).getNomeCampeonato();

        holder.txtTimeMand.setText(nomeTimeMand);
        holder.txtTimeVisit.setText(nomeTimeVisit);
        holder.txtPlacarMand.setText(nomePlacarMand);
        holder.txtPlacarVisit.setText(nomePlacarVisit);
        holder.txtDtaHorJogo.setText(dataHoraJogo);
        holder.txtLocalJogo.setText(localJogo);

    }

    @Override
    public int getItemCount() {
        return (null != itemsList ? itemsList.size() : 0);
    }


    public class ItemRowHolder extends RecyclerView.ViewHolder {

        protected TextView txtTimeMand;
        protected TextView txtTimeVisit;
        protected TextView txtPlacarMand;
        protected TextView txtPlacarVisit;
        protected TextView txtDtaHorJogo;
        protected TextView txtLocalJogo;
        protected TextView txtNomeCampeonato;


        public ItemRowHolder(View view) {
            super(view);

            this.txtTimeMand = (TextView) view.findViewById(R.id.txtTimeMand);
            this.txtTimeVisit = (TextView) view.findViewById(R.id.txtTimeVisit);
            this.txtPlacarMand = (TextView) view.findViewById(R.id.txtPlacarMand);
            this.txtPlacarVisit = (TextView) view.findViewById(R.id.txtPlacarVisit);
            this.txtDtaHorJogo = (TextView) view.findViewById(R.id.txtDataHoraJogo);
            this.txtLocalJogo = (TextView) view.findViewById(R.id.txtLocalJogo);
            //this.txtNomeCampeonato = (TextView) view.findViewById(R.id.txtNomeCampeon);

        }
    }
}
