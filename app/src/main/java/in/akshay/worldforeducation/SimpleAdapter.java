package in.akshay.worldforeducation;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import me.grantland.widget.AutofitTextView;

public class SimpleAdapter extends
        RecyclerView.Adapter<SimpleAdapter.MyViewHolder> {

    private List<String> list_item ;
    public Context mcontext;
    private String[] mdescribe;
    private String[] dlink;
    private String[] wlink;
    private ArrayList<Integer> imglink;





    public SimpleAdapter(List<String> list, Context context,String[] describe,String[] link,String[] wdlink, ArrayList<Integer> ilink) {

        list_item = list;
        mcontext = context;
        mdescribe=describe;
        dlink=link;
        wlink=wdlink;
        imglink=ilink;

    }

    // Called when RecyclerView needs a new RecyclerView.ViewHolder of the given type to represent an item.
    @Override
    public SimpleAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                         int viewType) {
        // create a layout
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.layout, null);

        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    // Called by RecyclerView to display the data at the specified position.
    @Override
    public void onBindViewHolder(final MyViewHolder viewHolder, final int position ) {

        Random rnd = new Random();
        int color = Color.argb(80, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));


        viewHolder.name.setText(list_item.get(position));
        viewHolder.lay.setBackgroundColor(color);
        viewHolder.late.setBackgroundColor(color);

       viewHolder.mimg.setImageResource(imglink.get(position));

        if(mdescribe[position].equalsIgnoreCase("")||mdescribe[position].equalsIgnoreCase(null))
        {
            viewHolder.desc.setText("No Description Available.");
        }else {
            viewHolder.desc.setText(mdescribe[position]);
        }




            viewHolder.open.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if(wlink[position].equalsIgnoreCase("")||wlink[position].equalsIgnoreCase(null))
                    {
                        Toast.makeText(mcontext,"No Web-link available for "+list_item.get(position),Toast.LENGTH_SHORT).show();
                    }else {

                        AlertDialog.Builder builder;

                        builder = new AlertDialog.Builder(mcontext);

                        builder.setTitle("Open Module Website")
                                .setMessage("Are you sure you want to open module providers website?")
                                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        Intent intent = new Intent();
                                        intent.setAction(Intent.ACTION_VIEW);
                                        intent.addCategory(Intent.CATEGORY_BROWSABLE);
                                        intent.setData(Uri.parse(wlink[position]));
                                        mcontext.startActivity(intent);
                                        dialog.dismiss();
                                    }
                                })
                                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.dismiss();
                                    }
                                })
                                .setIcon(android.R.drawable.ic_dialog_alert)
                                .show();
                    }




                }
            });


        viewHolder.down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder;

                builder = new AlertDialog.Builder(mcontext);

                builder.setTitle("Download Module")
                        .setMessage("Are you sure you want to download this module?")
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent = new Intent();
                                intent.setAction(Intent.ACTION_VIEW);
                                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                                intent.setData(Uri.parse(dlink[position]));
                                mcontext.startActivity(intent);
                                dialog.dismiss();
                            }
                        })
                        .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        })
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show();




            }
        });





    }

    // initializes textview in this class
    public static class MyViewHolder extends RecyclerView.ViewHolder {

        public AutofitTextView name;
        public AutofitTextView desc;
        public LinearLayout lay;
        public LinearLayout late;
        public TextView open;
        public ImageView down;
        public ImageView mimg;

        public MyViewHolder(View itemLayoutView) {
            super(itemLayoutView);

            name = (AutofitTextView) itemLayoutView.findViewById(R.id.appname);
            desc = (AutofitTextView) itemLayoutView.findViewById(R.id.desc);
            lay=(LinearLayout)itemLayoutView.findViewById(R.id.layout);
            open=(TextView)itemLayoutView.findViewById(R.id.open);
            down=(ImageView) itemLayoutView.findViewById(R.id.download);
            late=(LinearLayout)itemLayoutView.findViewById(R.id.layt);
            mimg=(ImageView)itemLayoutView.findViewById(R.id.mimg);

        }
    }

    //Returns the total number of items in the data set hold by the adapter.
    @Override
    public int getItemCount() {
        return list_item.size();
    }

}