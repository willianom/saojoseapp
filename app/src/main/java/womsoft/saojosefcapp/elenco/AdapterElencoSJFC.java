package womsoft.saojosefcapp.elenco;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import womsoft.saojosefcapp.R;
import womsoft.saojosefcapp.jogos.AdapterJogosSJFC;
import womsoft.saojosefcapp.jogos.BeanJogosSJFC;
import womsoft.saojosefcapp.jogos.ParserJsonJogosSJFC;

/**
 * Created by Willian.Matos on 09/02/2018.
 */

public class AdapterElencoSJFC extends RecyclerView.Adapter<AdapterElencoSJFC.ItemRowHolder>{

    private Context mContext;

    private ArrayList<BeanElencoSJFC> itemsList;
    private ParserJsonElencoSJFC parserJsonItemElenco;
    private List<BeanElencoSJFC> beanItemElenco;

    public AdapterElencoSJFC(Context mContext, ArrayList<BeanElencoSJFC> itemsList) {
        this.mContext = mContext;
        this.itemsList = itemsList;
    }

    @Override
    public ItemRowHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_elenco_sjfc, null);
        AdapterElencoSJFC.ItemRowHolder itemElenco = new AdapterElencoSJFC.ItemRowHolder(v);

        return itemElenco;
    }

    @Override
    public void onBindViewHolder(ItemRowHolder holder, int position) {

        final String idJogador    = itemsList.get(position).getId_jogador();
        final String nomeJogador    = itemsList.get(position).getNome_jogador();
        final String apelidoJogador   = itemsList.get(position).getApelido_jogador();
        final String idadeJogador  = itemsList.get(position).getIdade_jogador();
        final String posicaoJogador = itemsList.get(position).getPosicao_jogador();

        holder.txtIdJogador = idJogador;
        holder.txtNomeJogador.setText(nomeJogador);
        holder.txtApelidoJogador.setText(apelidoJogador);
        holder.txtIdadeJogador.setText(idadeJogador);
        holder.txtPosicaoJogador.setText(posicaoJogador);

    }

    @Override
    public int getItemCount() {
        return (null != itemsList ? itemsList.size() : 0);
    }

    public class ItemRowHolder extends RecyclerView.ViewHolder {

        protected String txtIdJogador;
        protected ImageView imgJogador;
        protected TextView txtNomeJogador;
        protected TextView txtApelidoJogador;
        protected TextView txtIdadeJogador;
        protected TextView txtPosicaoJogador;

        public ItemRowHolder(View view) {
            super(view);

            this.imgJogador = (ImageView) view.findViewById(R.id.imgJogador);
            this.txtNomeJogador = (TextView) view.findViewById(R.id.txtNomeJogador);
            this.txtApelidoJogador = (TextView) view.findViewById(R.id.txtApelidoJogador);
            this.txtIdadeJogador = (TextView) view.findViewById(R.id.txtIdadeJogador);
            this.txtPosicaoJogador = (TextView) view.findViewById(R.id.txtPosicaoJogador);
        }
    }
}
