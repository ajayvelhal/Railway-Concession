package com.example.ajay.concession.adapter;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.example.ajay.concession.R;
import com.example.ajay.concession.models.CancelConcess;
import com.example.ajay.concession.models.UpdateRply;
import com.example.ajay.concession.utils.RetrofitUtils;
import com.example.ajay.concession.utils.SharedPreference;
import java.util.ArrayList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import static java.security.AccessController.getContext;
/**
 * Created by Ajay on 2/7/2018.
 */
public class ListViewAdapter extends RecyclerView.Adapter<ListViewAdapter.MyViewHolder> {
    ArrayList<CancelConcess> listcan;
    View view;
    public ListViewAdapter(ArrayList<CancelConcess> listcan){
        this.listcan = listcan;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_items,parent,false);
        return new MyViewHolder(v);
    }
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        CancelConcess can= listcan.get(position);
        holder.Date.setText(can.getDate());
        holder.Token.setText(can.getToken());
    }
    @Override
    public int getItemCount() {
        return listcan.size();
    }
    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView Roll,Date,Token;
        ImageView img;
        SharedPreference pref;
        public MyViewHolder(View view) {
            super(view);

            Roll=(TextView) view.findViewById(R.id.lroll);
            Date=(TextView) view.findViewById(R.id.ldate);
            Token=(TextView) view.findViewById(R.id.ltoken);
            img=(ImageView)  view.findViewById(R.id.cancell);
            pref = new SharedPreference(view.getContext());
            Roll.setText(pref.getRoll());

            img.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(final View view) {
                    Log.e("roll",Roll.getText().toString());
                    RetrofitUtils.RetrofitService service= RetrofitUtils.getInstance();
                    Call<String> call=service.canConcess(Roll.getText().toString());
                    call.enqueue(new Callback<String>() {
                        @Override
                        public void onResponse(Call<String> call, Response<String> response) {
                            Log.e("****",response.toString());

                            String success=response.body();
                            if (success.equals("0")){
                                Toast.makeText(view.getContext(), "Cannot be cancelled" +
                                        "", Toast.LENGTH_SHORT).show();
                            }else if(success.equals("1")){
                                Toast.makeText(view.getContext(), "Cancelled Successfully", Toast.LENGTH_SHORT).show();
                                listcan.remove(getAdapterPosition());
                                notifyDataSetChanged();
                            }else{
                                Toast.makeText(view.getContext(), "Failed", Toast.LENGTH_SHORT).show();
                            }

                        }

                        @Override
                        public void onFailure(Call<String> call, Throwable t) {
                            Log.e("onFailure","Error",t);
                            Toast.makeText(view.getContext(), "Failed", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            });

        }
    }
}
