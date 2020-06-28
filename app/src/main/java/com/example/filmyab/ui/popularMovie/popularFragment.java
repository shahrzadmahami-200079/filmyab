package com.example.filmyab.ui.popularMovie;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.filmyab.ModelItem;
import com.example.filmyab.R;
import com.example.filmyab.RecyclerAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class popularFragment extends Fragment {

    RecyclerView recyclerView;
    RecyclerAdapter recyclerAdapter;
    List<ModelItem> listpopular;
    String URL;
    String RESULT_URL;
    String URL_Image = "https://image.tmdb.org/t/p/w500";
    String BASE_URL = "https://api.themoviedb.org/3/movie/";
    String API_KEY = "?api_key=428d813822be63eb8b0974061d27d530";
    RequestQueue requestQueue;


    @Override

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_popular, container, false);
        recyclerView = root.findViewById(R.id.rv_popular);
        GridLayoutManager mGridLayoutManager = new GridLayoutManager(getActivity(), 2);
        recyclerView.setLayoutManager(mGridLayoutManager);
        getData();
        return root;
    }

    public void showRecyclerView() {
        recyclerAdapter = new RecyclerAdapter(getActivity(), listpopular);
        recyclerView.setAdapter(recyclerAdapter);
    }


    public void getData() {
        listpopular = new ArrayList<>();
        RESULT_URL = "popular";
        URL = BASE_URL + RESULT_URL + API_KEY;
        requestQueue = Volley.newRequestQueue(getActivity());
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, URL, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray jsonArray = response.getJSONArray("results");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject results = jsonArray.getJSONObject(i);
                        String title = results.getString("title");
                        String backdrop_path = results.getString("backdrop_path");
                        String overview = results.getString("overview");
                        listpopular.add(new ModelItem(title, overview, URL_Image + backdrop_path + API_KEY));
                    }
                    showRecyclerView();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        requestQueue.add(jsonObjectRequest);
//        listpopular.add(new ModelItem("title 1", "overview", "URL_Image + backdrop_path + API_KEY"));
//        listpopular.add(new ModelItem("title 2", "overview", "URL_Image + backdrop_path + API_KEY"));
//        listpopular.add(new ModelItem("title 3", "overview", "URL_Image + backdrop_path + API_KEY"));
//        showRecyclerView();
    }
}
