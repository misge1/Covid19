package com.mirena.covid19;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import org.json.*;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.ArrayList;

public class AdapterMunicipios extends
        RecyclerView.Adapter<AdapterMunicipios.ViewHolder> {

    private ArrayList<Municipio> municipios;
    Context context;

    //el constructor para crear un adapter para municipios, dentro podriamos
    //enviarle el arraylist con los municipios
    public AdapterMunicipios(Context c) throws JSONException {
        context=c;
        Init();
    }

    public void Init() throws JSONException {
        // We read the JSON file and fill the “municipios” ArrayList
        municipios=new ArrayList<Municipio>();
        InputStream is = context.getResources().openRawResource(R.raw.municipioscv);
        Writer writer = new StringWriter();
        char[] buffer = new char[1024];
        try {
            Reader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            int n;
            while ((n = reader.read(buffer)) != -1) {
                writer.write(buffer, 0, n);
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        //JSONOBJECT = {}
        //JSONARRAY = [{}]
        //un jsonarray tiene jsonobjects
        //el file de json es un jsonobject muy grande que tiene dentro jsonarrays con jsonobjects


        String cadenajson = writer.toString();
        JSONArray jsonArray = new JSONArray(cadenajson);
        int num = jsonArray.length();
        for(int i=0; i<num; i++){
           JSONObject jsonObject = jsonArray.getJSONObject(i);
           Municipio municipionuevo = new Municipio(jsonObject.getInt("_id"), jsonObject.getLong("Casos PCR+"));
           municipios.add(municipionuevo);
        }

    }

    @Override
    public int getItemCount() {

        return municipios.size();
    }
    /**
     * Provide a reference to the type of views that you are using
     *
     * (custom ViewHolder).
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView textViewMunicipios;
        private final TextView textViewCasos;
        public ViewHolder(View view) {
            super(view);
            //cojo el textview donde voy a mostrar la información de municipios
            textViewMunicipios = (TextView) view.findViewById(R.id.municipiores);

            //cojo el textview donde voy a mostrar la informacion de los casos
            textViewCasos = (TextView) view.findViewById(R.id.casosres);
        }
        //funciones para coger el textView donde se va a mostrar la informacion
        //de las dos cosas
        public TextView getTextViewMunicipios() {
            return textViewMunicipios;
        }
        public TextView getTextViewCasos(){return textViewCasos;}
    }
    // llamado cuando RecyclerView necesita un viewHolder del tipo viewType
    //para representar un item
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.listparadaview, viewGroup, false);
        return new ViewHolder(view);
    }

    //llamado por el recyclerView para mostrar la información en la
    //posicion especificada
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //coges los textview que antes has creado para cambiar la información
        //e ir añadiendo a medida que lo lea del json
        holder.getTextViewMunicipios().setText(String.valueOf(municipios.get(position).getId()));
        holder.getTextViewCasos().setText(String.valueOf(municipios.get(position).getCasos_pcr()));
    }
}

