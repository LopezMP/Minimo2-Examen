package edu.upc.dsa.minimo2examen;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

import edu.upc.dsa.minimo2examen.models.Element;
import edu.upc.dsa.minimo2examen.models.Museums;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private MyAdapter recyclerAdapter;

    private Api api;

    private DelayedProgressDialog loader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        recyclerView=findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);


        getElements();
    }

    private void getElements(){
        api= ApiCon.connection();
        Call<Museums> call= api.get();
        call.enqueue(new Callback<Museums>() {
            @Override
            public void onResponse(Call<Museums> call, Response<Museums> response) {
                if (response.isSuccessful()) {
                    loader = new DelayedProgressDialog();
                    loader.show(getSupportFragmentManager(), "tag");
                    Museums museums = response.body();
                    recyclerAdapter = new MyAdapter(getApplicationContext(), museums.getElements());
                    recyclerView.setAdapter(recyclerAdapter);
                    recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                    loader.cancel();
                }
                else{
                    Context context = getApplicationContext();
                    int duration = Toast.LENGTH_SHORT;
                    CharSequence text = "Error";
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
            }

            @Override
            public void onFailure(Call<Museums> call, Throwable t) {
                Context context = getApplicationContext();
                int duration = Toast.LENGTH_LONG;
                CharSequence text = t.getMessage();
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }
        });

    }
}
