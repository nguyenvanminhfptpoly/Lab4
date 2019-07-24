package com.minhnv.lab4;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.minhnv.lab4.model2.Post;
import com.minhnv.lab4.ultil.APIUltil;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Comment;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostCatesActivity extends AppCompatActivity {

    private ImageView mImageView;
    private TextView mTextView;
    List<Post> posts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_cates);

        Loaddata();
        mTextView = findViewById(R.id.textView);
    }

    private void Loaddata() {

        APIUltil.getData().getPost("18", "5", "1").enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                if(!response.isSuccessful()){
                    mTextView.setText("COde" + response.code());
                    return;
                }

                List<Post> posts = response.body();
                for (Post post: posts){
                    String content="";

                    content += "Id: " + post.getTitle().getRendered() +"\n";


                    mTextView.append(content);
                }
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                Log.e("FF", t.getMessage());

            }
        });

    }
}
