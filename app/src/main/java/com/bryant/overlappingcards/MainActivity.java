package com.bryant.overlappingcards;


import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;
import com.bryant.cardslibrary.SimpleOverlayAdapter;

public class MainActivity extends AppCompatActivity {
    private ViewPager viewpage;
    private String[] imgUrls = new String[]{"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1602677009150&di=05a2180f741d3535068e19611c9a8445&imgtype=0&src=http%3A%2F%2Fimg.pconline.com.cn%2Fimages%2Fupload%2Fupc%2Ftx%2Fphotoblog%2F1202%2F17%2Fc1%2F10471952_10471952_1329445671906_mthumb.jpg"
            , "https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=2553538999,2212131319&fm=15&gp=0.jpg"
            , "https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=3428658608,95895171&fm=15&gp=0.jpg"
            , "https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=3025648586,2213869874&fm=15&gp=0.jpg"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewpage = findViewById(R.id.viewpage);
        SimpleOverlayAdapter adapter =
                new SimpleOverlayAdapter(this);
        adapter.setImgUrlsAndBindViewPager(viewpage, imgUrls, imgUrls.length);
        viewpage.setAdapter(adapter);
        viewpage.setCurrentItem(0);

        viewpage.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                Toast.makeText(MainActivity.this,i % imgUrls.length+"",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
    }
}
