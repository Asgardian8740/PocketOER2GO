package in.akshay.worldforeducation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class recycler extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    public EditText search;
    List<String> list = new ArrayList<>();
    public SimpleAdapter mAdapter;
    public String[] describe;
    public String[] download;
    public String[] web;
    ArrayList<Integer> myImageList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);
        search = (EditText) findViewById( R.id.search);
        describe=getResources().getStringArray(R.array.description);

        myImageList=new ArrayList<>();

        myImageList.add(R.drawable.african);
        myImageList.add(R.drawable.algebrao);
        myImageList.add(R.drawable.binofino);
        myImageList.add(R.drawable.blockygames);
        myImageList.add(R.drawable.bookdashbooks);
        myImageList.add(R.drawable.boundless);
        myImageList.add(R.drawable.boundless);
        myImageList.add(R.drawable.careergirls);
        myImageList.add(R.drawable.catanddogbooks);
        myImageList.add(R.drawable.causesierraleone);
        myImageList.add(R.drawable.ckkolibri);
        myImageList.add(R.drawable.ckkolibri);
        myImageList.add(R.drawable.collegecourses);
        myImageList.add(R.drawable.coreknowledge);
        myImageList.add(R.drawable.eaath);
        myImageList.add(R.drawable.edisonrobotics);
        myImageList.add(R.drawable.educate);
        myImageList.add(R.drawable.engage);
        myImageList.add(R.drawable.englishstorybook);
        myImageList.add(R.drawable.fairshakereentry);
        myImageList.add(R.drawable.fantasticphonicsadults);
        myImageList.add(R.drawable.fanatsticphonicschildren);
        myImageList.add(R.drawable.feedthemoster);
        myImageList.add(R.drawable.fileshare);
        myImageList.add(R.drawable.gcflearnfree);
        myImageList.add(R.drawable.greatbooksoftheworld);
        myImageList.add(R.drawable.esperianealthuides);
        myImageList.add(R.drawable.infonebiovision);
        myImageList.add(R.drawable.kalite);
        myImageList.add(R.drawable.kalite);
        myImageList.add(R.drawable.khanacademy);
        myImageList.add(R.drawable.khanacademyheal);
        myImageList.add(R.drawable.khanastick);
        myImageList.add(R.drawable.kolibriindex);
        myImageList.add(R.drawable.learnsaylor);
        myImageList.add(R.drawable.localcontent);
        myImageList.add(R.drawable.athxpression);
        myImageList.add(R.drawable.edicalformation);
        myImageList.add(R.drawable.medlineplus);
        myImageList.add(R.drawable.medlineplus);
        myImageList.add(R.drawable.mitscratch);
        myImageList.add(R.drawable.moodleonrachel);
        myImageList.add(R.drawable.musictheory);
        myImageList.add(R.drawable.mustardseedbooks);
        myImageList.add(R.drawable.fricaeading);
        myImageList.add(R.drawable.ducationalackages);
        myImageList.add(R.drawable.openstaxextbooks);
        myImageList.add(R.drawable.medlineplus);
        myImageList.add(R.drawable.coreknowledge);
        myImageList.add(R.drawable.medlineplus);
        myImageList.add(R.drawable.eacebuildingesources);
        myImageList.add(R.drawable.phet);
        myImageList.add(R.drawable.phetzimbased);
        myImageList.add(R.drawable.phet);
        myImageList.add(R.drawable.practicalaction);
        myImageList.add(R.drawable.radiolab);
        myImageList.add(R.drawable.raspiuserrguide);
        myImageList.add(R.drawable.sayloracademytextbooks);
        myImageList.add(R.drawable.scaleoftheuniverse);
        myImageList.add(R.drawable.sikana);
        myImageList.add(R.drawable.iyavula);
        myImageList.add(R.drawable.anzanianxams);
        myImageList.add(R.drawable.eacherraining);
        myImageList.add(R.drawable.alks);
        myImageList.add(R.drawable.touchableearth);
        myImageList.add(R.drawable.nderstandinglgebra);
        myImageList.add(R.drawable.lectronicibrary);
        myImageList.add(R.drawable.wass);
        myImageList.add(R.drawable.ikibooks);
        myImageList.add(R.drawable.ikiow);
        myImageList.add(R.drawable.ikipedia);
        myImageList.add(R.drawable.ikipediaforchools);
        myImageList.add(R.drawable.ikipediaforchools);
        myImageList.add(R.drawable.ikisource);
        myImageList.add(R.drawable.ikiversity);
        myImageList.add(R.drawable.ikivoyage);
        myImageList.add(R.drawable.iktionary);
        myImageList.add(R.drawable.indowpplications);
        myImageList.add(R.drawable.omennfricanistory);
        myImageList.add(R.drawable.worldmapzoom);
        myImageList.add(R.drawable.worldmapzoom);


        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        mRecyclerView.setHasFixedSize(true);
        web=getResources().getStringArray(R.array.site_link);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        list=Arrays.asList(getResources().getStringArray(R.array.NAME));
        download=getResources().getStringArray(R.array.download);
        mAdapter = new SimpleAdapter(list,this,describe,download,web,myImageList);
        mRecyclerView.setAdapter(mAdapter);

        addTextListener();
    }

    public void addTextListener(){

        search.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {}

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            public void onTextChanged(CharSequence query, int start, int before, int count) {

                query = query.toString().toLowerCase();

                final List<String> filteredList = new ArrayList<>();

                for (int i = 0; i < list.size(); i++) {

                    final String text = list.get(i).toLowerCase();
                    if (text.contains(query)) {

                        filteredList.add(list.get(i));
                    }
                }

                mRecyclerView.setLayoutManager(new LinearLayoutManager(recycler.this));
                mAdapter = new SimpleAdapter(filteredList, recycler.this,describe,download,web,myImageList);
                mRecyclerView.setAdapter(mAdapter);
                mAdapter.notifyDataSetChanged();  // data set changed
            }
        });
    }



}
