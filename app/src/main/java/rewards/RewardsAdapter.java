package rewards;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rewardsandpointssystem.R;

import java.util.List;

public class RewardsAdapter extends RecyclerView.Adapter<RewardsAdapter.RewardsViewHolder> {

    private List<Rewards> mRewards;

    public void setData(List<Rewards> list) {
        this.mRewards = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RewardsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rewards, parent, false);
        return new RewardsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RewardsViewHolder holder, int position) {
        Rewards rewards = mRewards.get(position);
        if(rewards == null){
            return;
        }
        holder.imgRewards.setImageResource(rewards.getResourceId());
        holder.tvTitle.setText(rewards.getTitle());
        holder.tvPoint.setText(rewards.getPoint());

    }

    @Override
    public int getItemCount() {
        if (mRewards != null){
            return mRewards.size();
        }
        return 0;
    }

    public class RewardsViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgRewards;
        private TextView tvTitle;
        private TextView tvPoint;

        public RewardsViewHolder(@NonNull View itemView) {
            super(itemView);

            imgRewards = itemView.findViewById(R.id.img_rewards);
            tvTitle = itemView.findViewById(R.id.tv_title);
            tvPoint = itemView.findViewById(R.id.tv_point);

        }
    }
}
