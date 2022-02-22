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

        String cadenajson = writer.toString();
        JSONArray jsonArray = new JSONArray(cadenajson);
        int num = jsonArray.length();
        for(int i=0; i<num; i++){
           JSONObject jsonObject = jsonArray.getJSONObject(i);
           Municipio municipionuevo = new Municipio(jsonObject.getInt("_id"));
           municipios.add(municipionuevo);
        }

    }

    @Override
    public int getItemCount() {

        return municipios.size();
    }
    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView textView;
        public ViewHolder(View view) {
            super(view);
            textView = (TextView) view.findViewById(R.id.textViewNumber);
        }
        public TextView getTextView() {
            return textView;
        }
    }
    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.listparadaview, viewGroup, false);
        return new ViewHolder(view);
    }
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        holder.getTextView().setText(String.valueOf(municipios.get(position).getId()));
    }
}

