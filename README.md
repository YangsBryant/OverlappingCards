# OverlappingCards
卡片重叠的滑动切换

## 引入module
```java
allprojects {
    repositories {
        google()
        jcenter()
        maven { url 'https://www.jitpack.io' }
    }
}
```

```java
implementation 'com.github.YangsBryant:OverlappingCards:1.0.2'
```
## 如果报NoSuchMethodError错误，是此库的Glide版本和你项目的Glide版本不一致导致，可添加如下代码：
```java
/*在app的build.gradle文件里的dependencies标签内添加，代码里glide的版本为对比出的最低版本。也可将你的项目glide版本改为4.9.0即可*/
configurations.all {
        resolutionStrategy {
            force 'com.github.bumptech.glide:glide:*'
        }
      }
```

##SimpleOverlayAdapter还有另一个构造器
```java
SimpleOverlayAdapter(Context context, Drawable error,Drawable load)//图片加载异常显示的占位图，图片加载中显示的占位图
``

## 主要代码
```java

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
                //想获取正确的下标如下：
                Toast.makeText(MainActivity.this,i % imgUrls.length+"",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
    }
}
```
