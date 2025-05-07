package com.rafaelsitompul.apimahsiswa;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

public class MahasiswaAdapter extends RecyclerView.Adapter<MahasiswaAdapter.ViewHolder> {
    private List<Mahasiswa> mahasiswaList;
    private Context context;
    private static final String TAG = "MahasiswaAdapter";

    public MahasiswaAdapter(Context context, List<Mahasiswa> mahasiswaList) {
        this.context = context;
        this.mahasiswaList = mahasiswaList;
    }

    @Override
    public MahasiswaAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_mahasiswa,
                parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MahasiswaAdapter.ViewHolder holder, int position) {
        Mahasiswa mhs = mahasiswaList.get(position);

        // Set text values
        holder.txtNama.setText(mhs.getNama());
        holder.txtNim.setText(mhs.getNim());
        holder.txtJurusan.setText(mhs.getJurusan());

        // Handle image loading with better error management
        String fotoUrl = mhs.getFoto();
        try {
            // Log the image URL for debugging
            Log.d(TAG, "Loading image for " + mhs.getNama() + ": " + fotoUrl);

            // Create request options with placeholders and caching
            RequestOptions options = new RequestOptions()
                    .placeholder(R.drawable.ic_baseline_person_outline_24)
                    .error(R.drawable.ic_baseline_person_outline_24)
                    .diskCacheStrategy(DiskCacheStrategy.ALL);

            if (fotoUrl != null && !fotoUrl.isEmpty()) {
                // Check if the image URL is already a full URL
                if (fotoUrl.startsWith("http")) {
                    // It's already a full URL, use as is
                    Glide.with(context)
                            .load(fotoUrl)
                            .apply(options)
                            .into(holder.imgMahasiswa);
                } else {
                    // It's a relative path, combine with base URL
                    String urlFoto = "http://10.0.2.2/mobile2_rafaelsitompul/foto/" + fotoUrl;
                    Glide.with(context)
                            .load(urlFoto)
                            .apply(options)
                            .into(holder.imgMahasiswa);
                }
            } else {
                // If foto is null or empty, just use the placeholder
                holder.imgMahasiswa.setImageResource(R.drawable.ic_baseline_person_outline_24);
            }
        } catch (Exception e) {
            // Log the error and use placeholder
            Log.e(TAG, "Error loading image: " + e.getMessage());
            holder.imgMahasiswa.setImageResource(R.drawable.ic_baseline_person_outline_24);
        }
    }

    @Override
    public int getItemCount() {
        return mahasiswaList != null ? mahasiswaList.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtNama, txtNim, txtJurusan;
        ImageView imgMahasiswa;

        public ViewHolder(View itemView) {
            super(itemView);
            txtNama = itemView.findViewById(R.id.txt_Nama);
            txtNim = itemView.findViewById(R.id.txt_Nim);
            txtJurusan = itemView.findViewById(R.id.txt_Jurusan);
            imgMahasiswa = itemView.findViewById(R.id.img_Mahasiwa);
        }
    }
}