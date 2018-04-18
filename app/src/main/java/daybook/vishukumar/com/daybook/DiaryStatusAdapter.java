package daybook.vishukumar.com.daybook;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class DiaryStatusAdapter extends RecyclerView.Adapter<DiaryStatusAdapter.StudentViewHolder> {

    private Context context;
    private List<DiaryStatus> diaryStatusList;

    public DiaryStatusAdapter(Context context, List<DiaryStatus> diaryStatusList) {
        this.context = context;
        this.diaryStatusList = diaryStatusList;
        Log.d("tag", "Constructor");
    }

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d("tag", "onCreateViewHolder start");
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        //View view = layoutInflater.inflate(R.layout.list_layout, null);
        Log.d("tag", "onCreateViewHolder start 2");
        View view = layoutInflater.inflate(R.layout.list_layout_all_status, null);
        StudentViewHolder studentViewHolder = new StudentViewHolder(view);
        Log.d("tag", "onCreateViewHolder");
        return studentViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder holder, int position) {
        Log.d("tag", "onBindViewHolder");
        final DiaryStatus diaryStatus = diaryStatusList.get(position);

        holder.textView1.setText("test");
        holder.textView2.setText("test2");
        //holder.textView1.setText(diaryStatus.getMood());
        //holder.textView2.setText(diaryStatus.getDescription());
        holder.constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Toast.makeText(context, "" + diaryStatus, Toast.LENGTH_SHORT).show();

                Intent toIndividualStatusPage = new Intent(context, IndividualStatusDisplayPage.class);
                toIndividualStatusPage.putExtra("_DATE", diaryStatus.getDate());
                toIndividualStatusPage.putExtra("_MOOD", diaryStatus.getMood());
                toIndividualStatusPage.putExtra("_DESC", diaryStatus.getDescription());
                context.startActivity(toIndividualStatusPage);*/

            }
        });
    }

    @Override
    public int getItemCount() {
        return diaryStatusList.size();
    }

    class StudentViewHolder extends RecyclerView.ViewHolder {

        ConstraintLayout constraintLayout;
        ImageView imageView;
        TextView textView1;
        TextView textView2;

        public StudentViewHolder(View itemView) {
            super(itemView);

            textView1 = (TextView) itemView.findViewById(R.id.id_textView_1);
            textView2 = (TextView) itemView.findViewById(R.id.id_textView_2);
            imageView = (ImageView) itemView.findViewById(R.id.id_imageView_1);
            constraintLayout = (ConstraintLayout) itemView.findViewById(R.id.id_constraint_layout_1);
        }

    }

}
