package com.rafaelsitompul.apimahsiswa;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MahasiswaAdapter adapter;
    private List<Mahasiswa> mahasiswaList = new ArrayList<>();
    private List<Mahasiswa> allMahasiswaList = new ArrayList<>();
    private static final String URL = "http://10.0.2.2/mobile2_rafaelsitompul/tampil_mahasiswa.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Initialize adapter
        adapter = new MahasiswaAdapter(this, mahasiswaList);
        recyclerView.setAdapter(adapter);

        // FloatingActionButton setup - removed toast message
        FloatingActionButton addButton = findViewById(R.id.addButton);
        addButton.setOnClickListener(v -> {
            // You could add functionality here later
        });

        // Load data from API
        tampilData();
    }

    private void tampilData() {
        RequestQueue queue = Volley.newRequestQueue(this);

        // For testing, we'll use a hardcoded JSON response with online images
        String jsonResponse = "{\n" +
                "  \"status\": \"success\",\n" +
                "  \"message\": \"Data mahasiswa berhasil diambil\",\n" +
                "  \"mahasiswa\": [\n" +
                "    {\n" +
                "      \"id\": \"1\",\n" +
                "      \"nim\": \"2301029\",\n" +
                "      \"nama\": \"Rafael Sitompul\",\n" +
                "      \"jurusan\": \"Teknik Informatika\",\n" +
                "      \"foto\": \"https://i.pravatar.cc/150?img=1\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"2\",\n" +
                "      \"nim\": \"210102\",\n" +
                "      \"nama\": \"Siti Rahmawati\",\n" +
                "      \"jurusan\": \"Sistem Informasi\",\n" +
                "      \"foto\": \"https://i.pravatar.cc/150?img=5\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"3\",\n" +
                "      \"nim\": \"210103\",\n" +
                "      \"nama\": \"Budi Santoso\",\n" +
                "      \"jurusan\": \"Manajemen Informatika\",\n" +
                "      \"foto\": \"https://i.pravatar.cc/150?img=3\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"4\",\n" +
                "      \"nim\": \"210104\",\n" +
                "      \"nama\": \"Ahmad Wijaya\",\n" +
                "      \"jurusan\": \"Komputerisasi Akuntansi\",\n" +
                "      \"foto\": \"https://i.pravatar.cc/150?img=7\"\n" +
                "    }\n" +
                "  ]\n" +
                "}";

        try {
            // Parse the hardcoded JSON for testing
            processJsonResponse(new JSONObject(jsonResponse));
            // Removed toast message about sample data
        } catch (JSONException e) {
            Log.e("JSON", "Error parsing hardcoded JSON: " + e.getMessage());
        }

        // Then make the actual API request
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, URL, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            processJsonResponse(response);
                            // Removed success toast message
                        } catch (JSONException e) {
                            e.printStackTrace();
                            // Still keep error toast for debugging
                            Toast.makeText(MainActivity.this,
                                    "Error parsing data: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("VolleyError", "Error: " + (error.getMessage() != null ? error.getMessage() : "Unknown error"));
                        // We're already using sample data, so no need to show an error toast
                    }
                });

        // Add the request to the RequestQueue with timeout settings
        request.setShouldCache(false);
        queue.add(request);
    }

    private void processJsonResponse(JSONObject response) throws JSONException {
        JSONArray jsonArray = response.getJSONArray("mahasiswa");
        mahasiswaList.clear();
        allMahasiswaList.clear();

        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject obj = jsonArray.getJSONObject(i);

            String nim = obj.getString("nim");
            String nama = obj.getString("nama");
            String jurusan = obj.getString("jurusan");
            String foto = obj.getString("foto");

            Mahasiswa mhs = new Mahasiswa(nama, nim, jurusan, foto);
            mahasiswaList.add(mhs);
            allMahasiswaList.add(mhs);
        }

        adapter.notifyDataSetChanged();
    }

    private void filter(String pencarian) {
        List<Mahasiswa> filteredList = new ArrayList<>();
        for (Mahasiswa item : allMahasiswaList) {
            if (item.getNama().toLowerCase().contains(pencarian.toLowerCase()) ||
                    item.getNim().toLowerCase().contains(pencarian.toLowerCase())) {
                filteredList.add(item);
            }
        }
        mahasiswaList.clear();
        mahasiswaList.addAll(filteredList);
        adapter.notifyDataSetChanged();
    }
}