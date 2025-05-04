package com.example.DummyAplikasi;

import android.os.Bundle;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegistrasiActivity extends AppCompatActivity {

    private static final String TAG = "RegisterActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_register); // layout bisa kosong untuk testing

        // Contoh panggilan langsung ke API register
        ApiInterface api = ApiClient.getRetrofitInstance().create(ApiInterface.class);

        Call<ResponseBody> call = api.register("Nama Anda", "email@example.com", "password123");
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    if (response.isSuccessful() && response.body() != null) {
                        String result = response.body().string();
                        Log.d(TAG, "Berhasil: " + result);
                    } else {
                        Log.e(TAG, "Gagal (status code): " + response.code());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    Log.e(TAG, "Gagal parsing response: " + e.getMessage());
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.e(TAG, "Gagal koneksi: " + t.getMessage());
            }
        });
    }
}
