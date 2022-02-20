package com.example.assignment2;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BlankFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BlankFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    //ImageView img = (ImageView) getView().findViewById(R.id.imageView);
    //TextView headline = (TextView) getView().findViewById(R.id.textView2);
    //TextView bodyView = (TextView) getView().findViewById(R.id.textView3);

    public BlankFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BlankFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BlankFragment newInstance(String param1, String param2) {
        BlankFragment fragment = new BlankFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {


        class fetchnews extends Thread{

            String news1 = "";

            @Override
            public void run() {
                try {
                    URL url1 = new URL("https://petwear.in/mc2022/news/news_0.json");
                    HttpURLConnection httpconn = (HttpURLConnection) url1.openConnection();
                    InputStream inp = httpconn.getInputStream();
                    BufferedReader br = new BufferedReader(new InputStreamReader(inp));
                    String line;
                    while ((line =  br.readLine())!=null){
                        news1 = news1+line;
                    }
                    if (!news1.isEmpty()){
                        JSONObject jobj = new JSONObject(news1);
                        String body = jobj.getString("body");
                        String imgurl = jobj.getString("image-url");
                        String head = jobj.getString("title");

                        //headline.setText(head);
                        //bodyView.setText(body);
                        //URL imgurlurl = new URL(imgurl);
                        //img.setImageBitmap(BitmapFactory.decodeStream(imgurlurl.openConnection().getInputStream()));

                    }

                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }

        fetchnews newsone = new fetchnews();
        newsone.run();
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blank, container, false);
    }
}